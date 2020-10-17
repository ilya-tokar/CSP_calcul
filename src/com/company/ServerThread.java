package com.company;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String InputLine, outputLine;
            while ((InputLine = in.readLine()) != null){
                String[] arr = InputLine.split(" ", 3);
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[2]);
                switch (arr[1]) {
                    case "+":
                        out.println(a + b);
                        break;
                    case "-":
                        out.println(a - b);
                        break;
                    case "*":
                        out.println(a * b);
                        break;
                    case "/":
                        out.println(a / b);
                        break;
                    default:
                        out.println("hello, world!");
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
