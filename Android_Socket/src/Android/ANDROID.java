//package Android;
//import java.io.*;
//import java.net.ServerSocket;
//import java.nio.*;
//import java.net.*;
//import java.util.ArrayList;
//
//class connect implements Runnable {
//    @Override
//    public void run() {
//        ArrayList<Socket> clients = new ArrayList<>();
//        try {
//            ServerSocket server = new ServerSocket(9999);
//            while(true){
//                Socket client = server.accept();
//                clients.add(client);
//                System.out.println(client);
//                String name = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
//                System.out.println(name);
//                // main thread theke call korte hbe erokom theory o ache
//                Thread thread_obj = new Thread(new recv(client));
//                thread_obj.start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class recv implements Runnable {
//    public Socket client_my;
//    public recv(Socket client_my){
//        this.client_my  =client_my;
//    }
//    @Override
//    public void run() {
//        System.out.println(client_my);
//        while(true){
//
//            try {
//                String her_message = new BufferedReader(new InputStreamReader(client_my.getInputStream())).readLine();
//                System.out.println(her_message);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//class send_every_where implements Runnable {
//    public send_every_where(ArrayList<Socket> clients,String message){
//        for(Socket trans : clients){
//            System.out.println(trans);
//        }
//        System.out.println(message+"from send_class");
//    }
//    @Override
//    public void run() {
//
//    }
//}
//public class ANDROID {
//
//    public static void main(String[] args) {
//        Thread conn_thread = new Thread(new connect());
//        conn_thread.start();
//    }
//}
