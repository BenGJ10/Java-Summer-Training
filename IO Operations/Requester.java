/* IP address is the unique identifier for a device on a network.
   Port number is used to identify a specific process or service on that device.
   Sockets are used to establish a connection between two devices over a network.
   Sockets are the combination of IP address and Port Number.
*/ 

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Requester {
   Socket requestSocket;
   ObjectOutputStream out;
   ObjectInputStream in;
   String message;
   Requester() {}

   void communicate(){
      try{
         // 1. Creating a socket to connect to the server
         requestSocket = new Socket("localhost", 52000); // 127.0.0.1
         System.out.println("Connected to localhost in port "); 

         // 2. Get Input and Output streams
         out = new ObjectOutputStream(requestSocket.getOutputStream());
         out.flush();
         in = new ObjectInputStream(requestSocket.getInputStream());

         // 3. Communicating with the server
         do{
            try{
               message = (String)in.readObject();
               System.out.println("server> " + message);

               sendMessage("Hi!");
               sendMessage("Welcome to the custom server.");
               sendMessage("Let's freshen up our Java skills.");
               message = "bye";
               sendMessage("bye");
            }
            catch(ClassNotFoundException classNot){
               System.err.println("Data received in unknown format.");
            }
         }  while(!message.equals("bye"));
      }
      catch(UnknownHostException unknownHost){
         System.err.println("You are trying to connect to an unknown host!");
      }
      catch(IOException io){
         io.printStackTrace();
      }
      finally{
            
         // 5. Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
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
         System.out.println("client> " + msg);
      }
      catch(IOException io){
         io.printStackTrace();
      }
   }

   public static void main(String args[]){
      Requester client = new Requester();
      client.communicate();
   }
}
