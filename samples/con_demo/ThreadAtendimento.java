package samples.con_demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadAtendimento extends Thread{
    private Socket no = null;
    
    public ThreadAtendimento(Socket node) {
        no = node;
    }

    public void run() {
        try {
            InputStreamReader is = new InputStreamReader(no.getInputStream());
            BufferedReader reader = new BufferedReader(is);

            OutputStream out = no.getOutputStream();
            DataOutputStream writter = new DataOutputStream(out);

            String text = reader.readLine(); // blocking

            writter.writeBytes(text.toUpperCase() + '\n');

            no.close();

        } catch (Exception e) {
            // TODO: handle exception
        }


    }
}
