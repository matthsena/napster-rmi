package samples.con_demo;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConcorrente {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);

        while (true) {
            System.out.println("Waiting for connection...");
            Socket no = server.accept(); // blocking
            System.out.println("Connection established");
            
            ThreadAtendimento t = new ThreadAtendimento(no);
            t.start();
        }
    }
}
