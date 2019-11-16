package com.pawelmazur.ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client extends Thread {
    enum Requests{
        GET_INGREDIENTS,

        EXIT;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 5000)) {
            socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            Requests request = Requests.GET_INGREDIENTS;
            String data;

            do {
                System.out.println("Enter string to be echoed: ");
                request = scanner.nextLine();

                stringToEcho.println(request);
                if (!request.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
