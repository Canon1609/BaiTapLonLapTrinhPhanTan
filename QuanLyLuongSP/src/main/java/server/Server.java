package server;

import java.io.*;
import java.net.*;
import gui_Form.Form_DangNhap;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9999;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                new Thread(() -> {
                    Form_DangNhap formDangNhap = new Form_DangNhap();

                    formDangNhap.setLocationRelativeTo(null);

                    formDangNhap.setVisible(true);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
