package org.example.app.command;

import java.net.Socket;
import java.rmi.RemoteException;

public class CancelTaskCommand extends CuncurCommand {

    public CancelTaskCommand(String[] argument, Socket socket) {
        super(argument, socket);
    }

    @Override
    public String execute() throws RemoteException {
        /*TODO:
            - implement a function Server.cancelTask(getUsername())
            - log a message 'task a from user b was canceled'
            - return the message
        */
        return "Not implemented";
    }
}
