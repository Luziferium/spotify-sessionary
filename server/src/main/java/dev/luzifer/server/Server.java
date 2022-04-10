package dev.luzifer.server;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Server {
    
    private static final Map<Socket, PrintWriter> connectedClients = new HashMap<>();
    private static final Logger logger = LogManager.getLogger();
    
    public static void start() throws IOException {
        
        Thread thread = new Thread(new MessageReceiver(), "Receiver");
        thread.start();
        
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                
                Socket clientSocket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                
                logger.log(Level.INFO, MessageFormat.format("Client connected: {0}", clientSocket.getInetAddress().getHostAddress()));
                
                connectedClients.put(clientSocket, printWriter);
            }
        }
    }
    
    public static void sendAll(String message) {
        
        for (PrintWriter printWriter : connectedClients.values()) {
            printWriter.println(message);
            printWriter.flush();
        }
        
        logger.log(Level.INFO, MessageFormat.format("Sent message to all clients: {0}", message));
    }
    
    public static Map<Socket, PrintWriter> getConnectedClients() {
        return connectedClients;
    }
    
    private Server() {}
}
