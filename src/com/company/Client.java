package com.company;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        if (args.length != 2){
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        String Host = args[0];
        int Port = Integer.parseInt(args[1]);

        try (
            Socket socket = new Socket(Host, Port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ){
            String UserInput;
            while((UserInput = stdin.readLine())!= null){
                out.println(UserInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don`t know about host " + Host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + Host);
            System.exit(1);
        }
    }
}
