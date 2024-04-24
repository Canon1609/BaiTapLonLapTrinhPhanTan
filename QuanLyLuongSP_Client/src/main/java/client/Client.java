package client;

import java.io.*;
import java.net.*;

import gui_Form.Form_DangNhap;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Đổi thành địa chỉ IP thực của máy chủ
        final int PORT = 9999;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            if (socket.isConnected()) {
                System.out.println("Connected to server: " + socket);

                // Gửi yêu cầu hiển thị giao diện cho server
                out.println("SHOW_INTERFACE");

                // Đọc phản hồi từ server
                String response = in.readLine();
                if (response.equals("DISPLAY_INTERFACE")) {
                    System.out.println("Server requested to display the interface.");
                    // Hiển thị giao diện ở đây
                    // Ví dụ:
                     Form_DangNhap formDangNhap = new Form_DangNhap();
                     formDangNhap.setLocationRelativeTo(null);
                     formDangNhap.setVisible(true);
                } else {
                    System.out.println("Unexpected response from server: " + response);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

