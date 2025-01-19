package org.example.app.executor;

import org.example.app.command.ConcurrCommand;

import java.util.concurrent.FutureTask;

/**
 * Representiert die Tasks, die durch den Executor von Server ausgefürht werden.
 * Indem ich diese Klasse implementiere, kann in Executor später auf Command object und damit
 * auf username, socket usw. zugreifen um statistik zu erfassen.
 */
public class ServerTask<V> extends FutureTask<V> implements Comparable<ServerTask<V>> {
    private ConcurrCommand command;

    public ServerTask(ConcurrCommand command) {
        super(command, null);
        this.command = command;
    }

    public ConcurrCommand getCommand() {
        return command;
    }

    public void setCommand(ConcurrCommand command) {
        this.command = command;
    }

    @Override
    public int compareTo(ServerTask<V> other) {
        return command.compareTo(other.command);
    }
}
