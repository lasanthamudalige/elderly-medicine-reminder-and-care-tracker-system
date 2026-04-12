import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Caretaker> caretakers = new ArrayList<>();
    static ArrayList<Medicine> medicines = new ArrayList<>();
    static ArrayList<Reminder> reminders = new ArrayList<>();

    public static void main(String[] args) {
        Login login = new Login();

        if (login.authenticate()) {
            System.out.println("Welcome to System!");
            loadDefaultData();
            mainMenu();
        } else {
            System.out.println("Login Failed. Exiting...");
        }
    }

    public static void loadDefaultData() {
        patients.add(new Patient("Nimal Perera", 70));
        patients.add(new Patient("Kamal Silva", 68));
        patients.add(new Patient("Sunil Fernando", 75));

        caretakers.add(new Caretaker("Saman", "0771234567", "Nimal Perera"));
        caretakers.add(new Caretaker("Ruwan", "0779876543", "Kamal Silva"));
        caretakers.add(new Caretaker("Malini", "0714567890", "Sunil Fernando"));

        medicines.add(new Medicine("Panadol", 500, "Morning"));
        medicines.add(new Medicine("Vitamin C", 250, "Night"));
        medicines.add(new Medicine("Aspirin", 100, "After Breakfast"));

        reminders.add(new Reminder("Panadol", "8.00 AM", "Take after breakfast"));
        reminders.add(new Reminder("Vitamin C", "8.00 PM", "Take after dinner"));
        reminders.add(new Reminder("Aspirin", "9.00 AM", "Drink water with medicine"));
    }

    public static void mainMenu() {
        int choice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Patient");
            System.out.println("2. Caretaker");
            System.out.println("3. Medicine");
            System.out.println("4. Reminder");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: patientMenu(); break;
                case 2: caretakerMenu(); break;
                case 3: medicineMenu(); break;
                case 4: reminderMenu(); break;
                case 5: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    public static void patientMenu() {
        int choice;

        do {
            System.out.println("\n--- PATIENT MENU ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewPatients(); break;
                case 3: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = input.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = input.nextInt();
        input.nextLine();

        patients.add(new Patient(name, age));
        System.out.println("Patient added successfully.");
    }

    public static void viewPatients() {
        System.out.println("\n--- PATIENT LIST ---");
        int count = 1;
        for (Patient p : patients) {
            System.out.println("Patient " + count++);
            p.displayPatient();
            System.out.println();
        }
    }

    public static void caretakerMenu() {
        int choice;

        do {
            System.out.println("\n--- CARETAKER MENU ---");
            System.out.println("1. Add Caretaker");
            System.out.println("2. View Caretakers");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: addCaretaker(); break;
                case 2: viewCaretakers(); break;
                case 3: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void addCaretaker() {
        System.out.print("Enter Caretaker Name: ");
        String name = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        System.out.print("Enter Patient Name Caretaker Looks After: ");
        String patientName = input.nextLine();

        caretakers.add(new Caretaker(name, phone, patientName));
        System.out.println("Caretaker added successfully.");
    }

    public static void viewCaretakers() {
        System.out.println("\n--- CARETAKER LIST ---");
        int count = 1;
        for (Caretaker c : caretakers) {
            System.out.println("Caretaker " + count++);
            c.displayCaretaker();
            System.out.println();
        }
    }

    public static void medicineMenu() {
        int choice;

        do {
            System.out.println("\n--- MEDICINE MENU ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: addMedicine();
                        break;
                case 2: viewMedicines();
                        break;
                case 3: System.out.println("Back to Main Menu");
                        break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void addMedicine() {
        System.out.print("Enter Medicine Name: ");
        String medicineName = input.nextLine();

        System.out.print("Enter Dosage (mg): ");
        int dosage = input.nextInt();
        input.nextLine();

        System.out.print("Enter Time: ");
        String time = input.nextLine();

        medicines.add(new Medicine(medicineName, dosage, time));
        System.out.println("Medicine added successfully.");
    }

    public static void viewMedicines() {
        System.out.println("\n--- MEDICINE LIST ---");
        int count = 1;
        for (Medicine m : medicines) {
            System.out.println("Medicine " + count++);
            m.displayMedicine();
            System.out.println();
        }
    }

    // ---- REMINDER ----

    public static void reminderMenu() {
        int choice;

        do {
            System.out.println("\n--- REMINDER MENU ---");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: addReminder(); break;
                case 2: viewReminders(); break;
                case 3: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void addReminder() {
        System.out.print("Enter Medicine Name: ");
        String medicineName = input.nextLine();

        System.out.print("Enter Reminder Time: ");
        String reminderTime = input.nextLine();

        System.out.print("Enter Note: ");
        String note = input.nextLine();

        reminders.add(new Reminder(medicineName, reminderTime, note));
        System.out.println("Reminder added successfully.");
    }

    public static void viewReminders() {
        System.out.println("\n--- REMINDER LIST ---");
        int count = 1;
        for (Reminder r : reminders) {
            System.out.println("Reminder " + count++);
            r.displayReminder();
            System.out.println();
        }
    }
}