package org.example.app.command;

import org.example.server.ServerRemote;

import java.net.Socket;
import java.rmi.RemoteException;

/**
 * Klasse zur Implementierung des Befehls "Shutdown"
 */
public class ShutdownCommand extends ConcurrCommand {
    private final ServerRemote server;

    public ShutdownCommand(String[] argument, ServerRemote server, Socket socket) {
        super(argument, socket);
        this.server = server;
    }

    @Override
    public String execute() throws RemoteException {
        return server.shutdown();
    }
}
