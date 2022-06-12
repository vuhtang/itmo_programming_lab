package commands.concrete;

import collection.entity.Worker;
import commands.Command;
import transferring.Request;
import transferring.Transfer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Info command. Displays type, initialization date and amount of elements of the collection.
 */
public class Info extends Command {
    private final Transfer transfer;

    /**
     * Initialised collection manager, the name and the description of the new command.
     */
    public Info(Transfer transfer) {
        super("info", "print information about the collection to standard output");
        this.transfer = transfer;
    }

    /**
     * Displays information about the given collection.
     *
     * @param args an empty string as an imperfection of the program model
     */
    @Override
    public List<String> action(String args, Worker worker) {
        Request request = new Request(getName(), args);
        List<String> result = new ArrayList<>();
        try {
            result.addAll(transfer.transfer(request));
        } catch (IOException e) {
            result.add("Input/output exception");
        } catch (ClassNotFoundException e) {
            result.add("Object came to us broken");
        }
        return result;
    }
}
