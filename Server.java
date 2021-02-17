package level2lesson06.offline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        startServer();
    }

    private static void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(666)){
            System.out.println("Server is listening");
            try (
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    Scanner sc = new Scanner(System.in);
            ){
                System.out.println("Client is connected");
                out.println("Hello client");
                out.flush();

                String messageFromUser = "";
                String myMessage = "";
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
                    messageFromUser = in.readLine();
                    out.println("Recieved : "+messageFromUser);
                    out.flush();

                    myMessage = sc.nextLine();
                    out.println(myMessage);
                    out.flush();

                    myMessage = in.readLine();
                    out.println("Recieved : "+myMessage);
                    out.flush();
                }while(!messageFromUser.equalsIgnoreCase("stop"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
