package org.example.app.command;

import org.example.app.utilities.DAO;

import java.net.Socket;

/**
 * Klasse zur Implementierung des Befehls "Query"
 */
public class QueryCommand extends ConcurrCommand {
    public QueryCommand(String[] argument, Socket socket) {
        super(argument, socket);
        cacheable = true;
    }

    @Override
    public String execute() {
        DAO dao = DAO.getDao();
        if (arguments.length == 5) {
            return dao.query(arguments[3], arguments[4]);
        }
        if (arguments.length == 6) {
            try {
                return dao.query(arguments[3], arguments[4], Short.parseShort(arguments[5]));
            } catch (IllegalArgumentException e) {
                return "Year must be a number " + e.getMessage();
            }
        }
        //TODO log error message
        return " Bad arguments";
    }
}
