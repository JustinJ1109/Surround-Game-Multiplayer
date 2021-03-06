/**
 * GameServer.java
 * 
 * @version 4.17.22
 * @author  Justin Jahlas, 
 * 			Brennan Luttrel, 
 * 			Prakash Lingden, 
 * 			Cole Blunt, 
 * 			Noah Meyers
 */

import java.io.IOException;
import java.net.*;

/********************************************************************
 * Main Game Server that dispatches threads to handle every unique
 * connection
 *******************************************************************/
public class GameServer {

    private static final int DEFAULT_LISTENING_PORT = 1370;
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;
        ServerHandler sh;

        int listenPort = args.length != 1 ? DEFAULT_LISTENING_PORT : Integer.parseInt(args[0]);

        try {
            serverSocket = new ServerSocket(listenPort);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + listenPort);
            e.printStackTrace();
            System.exit(-1);
        }

        while(listening) {
            try {
                sh = new ServerHandler(serverSocket.accept());
                Thread t = new Thread(sh);
                t.start();
            }
            catch (Exception e) {
                System.err.println("Could not open thread");
                e.printStackTrace();
            }
        }
    }
}
