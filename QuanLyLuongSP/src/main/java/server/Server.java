package server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9999;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                        String request = in.readLine();
                        if (request.equals("SHOW_INTERFACE")) {
                            System.out.println("Client requested to show the interface.");

                            // Gửi phản hồi cho client để yêu cầu hiển thị giao diện
                            out.println("DISPLAY_INTERFACE");
                        } else {
                            System.out.println("Unexpected request from client: " + request);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
