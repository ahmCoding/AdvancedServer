package org.example.app.executor;

import org.example.app.command.ConcurrCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Klasse zur Verwaltung der Aufgaben, die nach Executor, shutdown() gesendet wurden.
 */
public class RejectedTaskController implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        ConcurrCommand command = (ConcurrCommand) runnable;
        Socket clientSocket = command.getSocket();
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message = "The server is shutting down. Your request can not be served."
                    + " Shuting Down: "
                    + executor.isShutdown()
                    + ". Terminated: "
                    + executor.isTerminated()
                    + ". Terminating: "
                    + executor.isTerminating();
            out.println(message);
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            // TODO log the exception
            e.printStackTrace();
        }
    }
}
