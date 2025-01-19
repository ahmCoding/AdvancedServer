package org.example.app.command;


import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 * Abstrakte Klasse zur Implementierung von Commands, die in einem Thread ausgeführt werden,
 * einen Auftraggeber/username und eine Priorität haben
 */
public abstract class ConcurrCommand extends Command implements Runnable, Comparable<ConcurrCommand> {
    private String username;
    private byte priority;
    private Socket socket;

    /**
     * @param argument String[] {q/r/s/c/z,username,priority,countyCode,indicatorCode,[year]}
     * @param socket   client socket to send the response
     */
    public ConcurrCommand(String[] argument, Socket socket) {
        super(argument);
        this.socket = socket;
        username = argument[1];
        priority = Byte.parseByte(argument[2]);
    }

    /**
     * Gibt das Socket des Clients zurück
     *
     * @return Socket
     */
    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        // TODO log a message with the username and priority of the command
        String ret;
        try {
            ret = execute();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(ret);
            socket.close();
        } catch (Exception e) {
            // TODO log the exception
            e.printStackTrace();
        }
        // TODO cache the result in the ServeCache
        // TODO log the response
        System.out.println(ret);
    }

    @Override
    public abstract String execute() throws RemoteException;

    @Override
    public int compareTo(ConcurrCommand other) {
        //return priority - o.priority;
        return Byte.compare(priority, other.priority);
    }

    public String getUsername() {
        return username;
    }
    

}
