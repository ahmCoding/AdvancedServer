package org.example.app.command;

import java.net.Socket;

/**
 * Klasse zur Implementierung des Befehls "Error"
 */
public class ErrorCommand extends ConcurrCommand {
    public ErrorCommand(String[] argument, Socket socket) {
        super(argument, socket);
    }

    @Override
    public String execute() {
        // TODO log the error
        return "Error";
    }
}
