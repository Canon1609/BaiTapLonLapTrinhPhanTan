package client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        // Địa chỉ IP của máy chủ
        final String SERVER_ADDRESS = "192.168.1.11"; // Đổi thành địa chỉ IP thực của máy chủ
        final int PORT = 9999;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
			if (socket.isConnected()) {
				System.out.println("Connected to server: " + socket);
			}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
