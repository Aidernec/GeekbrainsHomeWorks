package level2lesson06.offline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        startClient();
    }

    private static void startClient(){
        try (Socket socket  = new Socket("localhost", 666);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)){
            String myMessage = "";
            String messageFromServer = "";
            Thread serverReader = new Thread(() -> {
                String serverMessage = "";
                try {
                    while(!socket.isClosed()) {
                        serverMessage = in.readLine();
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReader.start();
            do{
                messageFromServer = in.readLine();
                out.println("Recieved : "+messageFromServer);
                out.flush();

                myMessage = sc.nextLine();
                out.println(myMessage);
                out.flush();

                messageFromServer = in.readLine();
                out.println("Recieved : "+messageFromServer);
                out.flush();
            }while(!myMessage.equalsIgnoreCase("stop"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
