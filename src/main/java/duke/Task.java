package duke;

import java.io.Serializable;

public class Task implements Serializable {
    private String name;
    private boolean marked = false;

    /**
     * Returns the name of the task.
     *
     * @param name name of the task.
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * Indicates the task as marked.
     */
    public void markTask() {
        this.marked = true;
    }

    /**
     * Indicates the task as un-marked.
     */
    public void unMarkTask() {
        this.marked = false;
    }

    /**
     * Returns the boolean of whether the task is marked.
     *
     * @return true if marked and false otherwise.
     */
    public boolean isMarked() {
        return this.marked;
    }

    /**
     * Gets the content of the task.
     *
     * @return content of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a string of text to the end of the current task content.
     *
     * @param addition String to be added to the current task content.
     */
    public void editName(String addition) {
        this.name += addition;
    }
}