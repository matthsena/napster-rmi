package samples.con_demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9000);

        OutputStream out = s.getOutputStream();
        DataOutputStream writter = new DataOutputStream(out);

        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(is);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        String sentence = inFromUser.readLine();
        writter.writeBytes(sentence + '\n');

        String response = reader.readLine(); // blocking
        System.out.println("FROM SERVER: " + response);

        s.close();
    }
}
