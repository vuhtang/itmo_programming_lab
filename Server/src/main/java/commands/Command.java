package commands;

import collection.entity.Worker;
import transferring.Token;

import java.util.List;

/**
 * Abstract class from which all commands are extended. It has an abstract method "action" as
 * a specific action of each concrete command.
 */
public abstract class Command {
    /**
     * The command description.
     */
    private final String description;
    /**
     * The command name.
     */
    private final String name;

    /**
     * Initialized the name and the description of the new command.
     *
     * @param name the command name
     * @param desc the command description
     */
    public Command(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public abstract List<String> action(String args, Worker worker, Token token);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
