package org.example.app.command;


import org.example.server.ServerRemote;

import java.net.Socket;
import java.rmi.RemoteException;

/**
 * Gibt den aktuellen Status des Servers zurück.
 */
public class ServerStatusCommand extends CuncurCommand {
    private final ServerRemote server;

    public ServerStatusCommand(String[] argument, ServerRemote server, Socket socket) {
        super(argument, socket);
        this.server = server;
    }

    @Override
    public String execute() {
        try {
            return server.getState();
        } catch (RemoteException e) {
            // TODO log the exception
            throw new RuntimeException(e);
        }
    }
}
