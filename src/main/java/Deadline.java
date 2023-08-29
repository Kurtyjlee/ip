import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Deadline extends Task {
    private final char taskType = 'D';
    private LocalDate date;
    private boolean hasDate = false;

    public Deadline(String name, String date) {
        super(name);
        try {
            this.date = LocalDate.parse(date);
            this.hasDate = true;
        } catch (DateTimeParseException e) {
            super.editName(String.format(" (by: %s)", date));
        }
    }

    @Override
    public String toString() {
        String checkBox = super.isMarked() ? "[X]" : "[ ]";
        String taskType = String.format("[%c]", this.taskType);
        if (hasDate) {
            return String.format(
                    "%s%s %s (by: %s)",
                    taskType, checkBox, super.getName(), this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
        }
        return String.format(
                "%s%s %s",
                taskType, checkBox, super.getName());
    }
}