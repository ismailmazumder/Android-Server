package Android;
import java.io.*;
import java.net.ServerSocket;
import java.nio.*;
import java.net.*;
import java.util.ArrayList;
import java.io.IOException;

class connect implements Runnable {
    @Override
    public void run() {
        ArrayList<Socket> clients = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket();//bind added
            server.bind(new InetSocketAddress("127.0.0.1",9999));
            //server.bind(new InetSocketAddress("127.0.0.1", 9999));
            while(true){
                Socket client = server.accept();
                clients.add(client);
                System.out.println(client);
                String name = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
                System.out.println(name);
                // main thread theke call korte hbe erokom theory o ache
                Thread thread_obj = new Thread(new recv(client,clients));
                thread_obj.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class recv implements Runnable {
    public Socket client_my;
    ArrayList<Socket> clients;
    public recv(Socket client_my,ArrayList<Socket> clients){
        this.client_my  =client_my;
        this.clients = clients;
    }
    @Override
    public void run() {
        System.out.println(client_my);
        while(true){

            try {
                String her_message = new BufferedReader(new InputStreamReader(client_my.getInputStream())).readLine();
                // new condition
                if(her_message==null){continue;}
                System.out.println(her_message);
//                ArrayList<Socket> clients = new ArrayList<>();
                send_every_where send_every_where_obj = new send_every_where(clients,her_message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class send_every_where implements Runnable {
    public send_every_where(ArrayList<Socket> clients,String message){
        for(Socket trans : clients){
            System.out.println(trans+"transssssssssssssss");
            try {
                PrintWriter send_every = new PrintWriter(trans.getOutputStream());
                send_every.println(message);
                send_every.flush();
                System.out.println("sent");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message+"from send_class");
    }
    @Override
    public void run() {

    }
}
public class ANDROID_TWO {

    public static void main(String[] args) {
        Thread conn_thread = new Thread(new connect());
        conn_thread.start();
    }
}
