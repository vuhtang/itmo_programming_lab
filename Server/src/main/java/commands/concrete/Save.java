package commands.concrete;

import collection.WorkerColManager;
import collection.entity.Worker;
import commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Save command. Saves the collection in a file whose path is bound to the collection.
 * Data is written in csv format.
 */
public class Save extends Command {
    /**
     * Collection manager to work with.
     */
    private final WorkerColManager colManager;

    /**
     * Initialised collection manager, the name and the description of the new command.
     */
    public Save(WorkerColManager colManager) {
        super("save", "save the collection to a file");
        this.colManager = colManager;
    }

    /**
     * Calls saveCollection method. If an error occurs during execution, a message will be displayed
     * and the collection will not be saved.
     *
     * @param args an empty string as an imperfection of the program model
     */
    @Override
    public List<String> action(String args, Worker worker) {
        List<String> response = new ArrayList<>();
        if (!colManager.saveCollection()) response.add("Failed to save the collection to file");
        else response.add("Collection saved successfully");
        return response;
    }
}