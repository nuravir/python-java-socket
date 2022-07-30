import java.net.*;
import java.io.*;


public class Client {

    static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;

    public static void main(String[] args) throws IOException{
        
        String ip = "127.0.0.1";
        int port = 8000;
        try{

            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));
    
        }
        catch(IOException e){
            throw e;
        }
  

        try{

            out.println("From Client: Message Received\n");
            String resp = in.readLine();
            System.out.println(resp);
            out.flush();
        }
        catch (IOException e){
            throw e;
        }

        try{
    
            in.close();
            out.close();
            clientSocket.close();
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }

}