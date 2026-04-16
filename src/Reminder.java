import java.time.LocalTime;

public class Reminder {
    String patientName;
    String medicineName;
    LocalTime time;
    String note;
    boolean taken;

    public Reminder(String patientName, String medicineName, LocalTime time, String note) {
        this.patientName = patientName;
        this.medicineName = medicineName;
        this.time = time;
        this.note = note;
        this.taken = false;
    }

    public void markAsTaken() {
        this.taken = true;
    }

    public void displayReminder() {
        System.out.println("Patient: " + patientName);
        System.out.println("Medicine: " + medicineName);
        System.out.println("Time: " + time);
        System.out.println("Note: " + note);
        System.out.println("Status: " + (taken ? "Taken" : "Pending"));
    }
}