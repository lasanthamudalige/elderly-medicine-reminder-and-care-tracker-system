public class Caretaker {
    String name;
    String phone;
    String patientName;

    public Caretaker(String name, String phone, String patientName) {
        this.name = name;
        this.phone = phone;
        this.patientName = patientName;
    }

    public void displayCaretaker() {
        System.out.println("Caretaker Name: " + name);
        System.out.println("Phone Number: " + phone);
        System.out.println("Looks After Patient: " + patientName);
    }
}