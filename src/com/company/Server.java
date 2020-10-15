package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int Port = Integer.parseInt(args[0]);

        try(
                ServerSocket serverSocket = new ServerSocket(Port);
                Socket ClientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
                ) {
            String InputLine;
            while ((InputLine = in.readLine()) != null){
                out.println("hello, world!");
                System.out.println(InputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
