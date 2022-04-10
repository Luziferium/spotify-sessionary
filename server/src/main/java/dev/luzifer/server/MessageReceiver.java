package dev.luzifer.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessageReceiver implements Runnable {
    
    private final Map<Socket, BufferedReader> readerCache = new HashMap<>();
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
                String message;
                for(BufferedReader reader : readerCache.values())
                    if((message = reader.readLine()) != null)
                        Server.sendAll(message);
                
                updateReader();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void updateReader() throws IOException {
        for(Socket socket : Server.getConnectedClients().keySet())
            if(!Server.getConnectedClients().containsKey(socket))
                readerCache.put(socket, new BufferedReader(new InputStreamReader(socket.getInputStream())));
    }
    
}
