import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Provider {
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    Provider() {}  

    void process(){
        try{
            // 1. Creating a server socket
            providerSocket = new ServerSocket(52000);
            
            // 2. Waiting for connection
            System.out.println("Waiting for connection...");
            connection = providerSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName());

            // 3. Get Input and Output streams
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection established successfully.");

            // 4. The two parts will communicate via the input and output streams
            do{
                try{
                    message = (String)in.readObject();
                    System.out.println("client> " + message);
                    if(message.equals("bye"))
                        sendMessage("bye");
                }
                catch(ClassNotFoundException classNot){
                    System.err.println("Data received in unknown format.");
                }
            }while(!message.equals("bye"));
        }
        catch(IOException io){
            io.printStackTrace();
        }
        finally{
            // 5. Closing connection
            try{
                in.close();
                out.close();
                providerSocket.close();
            }
            catch(IOException io){
                io.printStackTrace();
            }
        }
    }

    void sendMessage(String msg){
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("server> " + msg);
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }

    public static void main(String args[]){
        Provider server = new Provider();
        while(true){
            server.process();
        }
    }
}
