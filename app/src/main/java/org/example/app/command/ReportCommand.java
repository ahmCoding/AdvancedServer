package org.example.app.command;

import org.example.app.utilities.DAO;

import java.net.Socket;

/**
 * Klasse zur Implementierung des Befehls "Report"
 */
public class ReportCommand extends CuncurCommand {
    public ReportCommand(String[] argument, Socket socket) {
        super(argument, socket);
        cacheable = true;
    }

    @Override
    public String execute() {
        DAO dao = DAO.getDao();
        if (arguments.length == 4) {
            return dao.report(arguments[3]);
        }
        //TODO log error message
        return " Bad arguments";
    }
}
