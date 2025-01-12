package org.example.app.command;

/**
 * Klasse zur Implementierung des Befehls "Fake" zum Testzwecken
 */
//TODO: Create a fake command for testing
public class FakeCommand extends Command {
    public FakeCommand(String command) {
        super(command);
    }

    @Override
    public String execute() {
        return "Fake command does nothing";
    }
}
