package com.tarikcurto.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author tcurto
 */
@ApplicationScoped
@ServerEndpoint("/ws")
public class Server {

    /**
     *
     */
    protected final Logger logger = Logger.getLogger( Server.class.getName() );
    
    @OnOpen
    public void open(Session session) {
        
        logger.log(Level.INFO, "Conected user_id: {0}", session.getId());
    }

    @OnClose
    public void close(Session session) {
        
        logger.log(Level.INFO, "Disconnected user_id: {0}", session.getId());
    }

    @OnError
    public void onError(Throwable error) {
        
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        
        logger.log(Level.INFO, "Message user_id: {0}", session.getId());
        
        try {
            session.getBasicRemote().sendText("Client message is: " + message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
