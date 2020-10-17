package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int Port = Integer.parseInt(args[0]);

        try(
                ServerSocket serverSocket = new ServerSocket(Port);
                ) {
            while (true) {
                new ServerThread(serverSocket.accept()).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
