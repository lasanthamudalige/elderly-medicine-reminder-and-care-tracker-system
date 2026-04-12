public class Reminder {
    String medicineName;
    String reminderTime;
    String note;

    public Reminder(String medicineName, String reminderTime, String note) {
        this.medicineName = medicineName;
        this.reminderTime = reminderTime;
        this.note = note;
    }

    public void displayReminder() {
        System.out.println("Medicine Name: " + medicineName);
        System.out.println("Reminder Time: " + reminderTime);
        System.out.println("Note: " + note);
    }
}