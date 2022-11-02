package Android;
import java.io.*;
import java.net.ServerSocket;
import java.nio.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIENT {
    public Socket ser_conn;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = s.nextLine();
        try {
            Socket ser_conn = new Socket("192.168.1.110",9999);

            PrintWriter pr = new PrintWriter(ser_conn.getOutputStream());
            pr.println(name);
            pr.flush();
            while(true) {
                System.out.println("Enter your message : ");
                String message = s.nextLine();
                pr.println(message);
                pr.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
