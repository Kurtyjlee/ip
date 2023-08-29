package duke;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private final String filePath;
    public Storage(String filePath) {
        this.filePath = filePath;

        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            Ui.printWrapped("\u2639 OOPS!!! An error occurred while creating the file.");
        }
    }

    /**
     * Loads the taskList stored in the file.
     *
     * @return ArrayList representing the taskList.
     * @throws DukeException Duke exception to let the user know what went wrong.
     */
    public ArrayList<Task> load() throws DukeException {
        // Loading the serialised object
        try {
            FileInputStream fileIn = new FileInputStream(this.filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            @SuppressWarnings("unchecked")
            ArrayList<Task> loadedList = (ArrayList<Task>) objectIn.readObject();
            return loadedList;
        } catch (IOException | ClassNotFoundException e) {
            throw new DukeException("\u2639 OOPS!!! An error occurred while reading data.");
        }
    }

    /**
     * Writes the current list of task into the storage file.
     *
     * @param tasks list of task to be written.
     * @throws DukeException Lets the user know what went wrong.
     */
    public void write(TaskList tasks) throws DukeException {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(tasks.getTasks());
        } catch (IOException e) {
            throw new DukeException("\u2639 OOPS!!! Something went wrong when saving data");
        }
    }
}