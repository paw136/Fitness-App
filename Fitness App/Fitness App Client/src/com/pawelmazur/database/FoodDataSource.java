package com.pawelmazur.database;

import java.sql.*;
import java.util.ArrayList;

public class FoodDataSource {
    public static final String DB_NAME = "Food.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\pawel\\Desktop\\Fitness App\\Databases\\" + DB_NAME;

    public static final String TABLE_INGREDIENTS = "Ingrendients";
    public static final String COLUMN_INGREDIENTS_ID = "id";
    public static final String COLUMN_INGREDIENTS_NAME = "Name";
    public static final String COLUMN_INGREDIENTS_TYPE = "Type";
    public static final String COLUMN_INGREDIENTS_CALORIES = "Calories";
    public static final String COLUMN_INGREDIENTS_SUPPLIERS = "Type Suppliers";

    public static final String TABLE_INGREDIENT_TYPE = "Ingredient Type";
    public static final String COLUMN_INGREDIENT_TYPE_ID = "id";
    public static final String COLUMN_INGREDIENT_TYPE_NAME = "Name";

    public static final String TABLE_INGREDIENTS_IN_RECIPES = "Ingredient Type";
    public static final String COLUMN_INGREDIENTS_IN_RECIPES_RECIPE = "Recipe";
    public static final String COLUMN_INGREDIENTS_IN_RECIPES_INGREDIENT = "Ingredients";
    public static final String COLUMN_INGREDIENTS_IN_RECIPES_AMMOUNT = "Ammount";

    public static final String TABLE_RECIPES = "Recipes";
    public static final String COLUMN_RECIPES_ID = "id";
    public static final String COLUMN_RECIPES_NAME = "Name";
    public static final String COLUMN_RECIPES_DIRECTIONS = "Directions";

    private Connection conn;

    public void open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    /**
     * method returning an array list with all ingredients
     * @return array list with ingrendients ---> name calories suppliers type
     */
    public ArrayList<ArrayList<String>> parse_Ingredients() {
        open();

        ArrayList<ArrayList<String>> ingredients = new ArrayList<>();
        ArrayList<String> ingredient = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * FROM ");
        sb.append(TABLE_INGREDIENTS);

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
            while (resultSet.next()) {
                ingredient.add(resultSet.getString(COLUMN_INGREDIENTS_ID));
                ingredient.add(resultSet.getString(COLUMN_INGREDIENTS_NAME));
                ingredient.add(resultSet.getString(COLUMN_INGREDIENTS_TYPE));
                ingredient.add(resultSet.getString(COLUMN_INGREDIENTS_CALORIES));
                ingredient.add(resultSet.getString(COLUMN_INGREDIENTS_SUPPLIERS));

                ingredients.add(ingredient);

                ingredient = new ArrayList<>();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ingredients);
        close();

        return ingredients;
    }
}
