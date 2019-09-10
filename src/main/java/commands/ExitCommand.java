package commands;

import duke.Duke;
import duke.TaskList;
import duke.Ui;
import duke.Storage;

import java.io.IOException;

/**
 * ExitCommand is a class that terminates the program.
 */
public class ExitCommand extends Command {

    /**
     * Constructor for ExitCommand.
     * Boolean isExit is set to true because
     * program should be terminated after command is executed.
     *
     * @param commandArr String array containing the split text retrieved from user input.
     */
    public ExitCommand(String[] commandArr) {
        this.commandArr = commandArr;
        Duke.setShouldExitProgram(true);
    }

    /**
     * Exits the program.
     *
     * @param tasks the TaskList object storing all recorded Tasks.
     * @param ui the Ui object dealing with user interaction.
     * @param storage the Storage object that reads from and writes to the file.
     * @return String output reply from Duke.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        // Save the new task list to the hard disk
        try {
            storage.save(tasks);
        } catch (IOException e) {
            ui.showSavingError(e.getMessage());
        }
        return "     Bye. Hope to see you again soon!\n";
    }

}
