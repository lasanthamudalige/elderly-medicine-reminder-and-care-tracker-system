import java.time.LocalTime;
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
            startReminderChecker(); //  START BACKGROUND SYSTEM
            mainMenu();
        } else {
            System.out.println("Login Failed. Exiting...");
        }
    }

    public static void loadDefaultData() {
        // ---- PATIENTS ----
        patients.add(new Patient("Nilan Perera", 70));
        patients.add(new Patient("Kasun Silva", 68));
        patients.add(new Patient("Ravindu Fernando", 75));
        patients.add(new Patient("Thilak Jayawardena", 72));
        patients.add(new Patient("Suresh Kumara", 66));
        patients.add(new Patient("Ranjith Wijesinghe", 80));
        patients.add(new Patient("Anoma Perera", 65));
        patients.add(new Patient("Piyumi Silva", 74));
        patients.add(new Patient("Dinesh Bandara", 69));
        patients.add(new Patient("Sachini Fernando", 67));

        // ---- CARETAKERS ----
        caretakers.add(new Caretaker("Nadeera", "0771234567", "Nilan Perera"));
        caretakers.add(new Caretaker("Chathura", "0779876543", "Kasun Silva"));
        caretakers.add(new Caretaker("Ishara", "0714567890", "Ravindu Fernando"));
        caretakers.add(new Caretaker("Pasindu", "0751122334", "Thilak Jayawardena"));
        caretakers.add(new Caretaker("Tharindu", "0769988776", "Suresh Kumara"));
        caretakers.add(new Caretaker("Kavindi", "0774455667", "Ranjith Wijesinghe"));
        caretakers.add(new Caretaker("Sanduni", "0712233445", "Anoma Perera"));
        caretakers.add(new Caretaker("Ramesh", "0756677889", "Piyumi Silva"));
        caretakers.add(new Caretaker("Udesh", "0763344556", "Dinesh Bandara"));
        caretakers.add(new Caretaker("Nimashi", "0778899001", "Sachini Fernando"));

        // ---- MEDICINES ----
        medicines.add(new Medicine("Panadol", 500, "Morning"));
        medicines.add(new Medicine("Vitamin C", 250, "Night"));
        medicines.add(new Medicine("Aspirin", 100, "After Breakfast"));
        medicines.add(new Medicine("Metformin", 500, "After Meal"));
        medicines.add(new Medicine("Atorvastatin", 20, "Night"));
        medicines.add(new Medicine("Losartan", 50, "Morning"));
        medicines.add(new Medicine("Omeprazole", 20, "Before Breakfast"));
        medicines.add(new Medicine("Amoxicillin", 500, "Every 8 hours"));
        medicines.add(new Medicine("Calcium", 600, "After Lunch"));
        medicines.add(new Medicine("Ibuprofen", 200, "When Needed"));

        // ---- REMINDERS ----
        reminders.add(new Reminder("Nilan Perera", "Panadol", LocalTime.parse("08:00"), "Before breakfast"));
        reminders.add(new Reminder("Kasun Silva", "Vitamin C", LocalTime.parse("13:00"), "After lunch"));
        reminders.add(new Reminder("Ravindu Fernando", "Aspirin", LocalTime.parse("19:00"), "After dinner"));

        reminders.add(new Reminder("Thilak Jayawardena", "Metformin", LocalTime.parse("07:30"), "Before breakfast"));
        reminders.add(new Reminder("Suresh Kumara", "Losartan", LocalTime.parse("08:30"), "Morning dose"));
        reminders.add(new Reminder("Ranjith Wijesinghe", "Atorvastatin", LocalTime.parse("21:00"), "Before sleep"));
        reminders.add(new Reminder("Anoma Perera", "Calcium", LocalTime.parse("12:30"), "After lunch"));
        reminders.add(new Reminder("Piyumi Silva", "Omeprazole", LocalTime.parse("06:30"), "Empty stomach"));
        reminders.add(new Reminder("Dinesh Bandara", "Ibuprofen", LocalTime.parse("15:00"), "If needed"));
        reminders.add(new Reminder("Sachini Fernando", "Amoxicillin", LocalTime.parse("10:00"), "After meal"));
    }

    public static void mainMenu() {
        boolean run = true;

        while (run) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Patient");
            System.out.println("2. Caretaker");
            System.out.println("3. Medicine");
            System.out.println("4. Reminder");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            // Get the user input as a string
            String userInput = input.nextLine();

            try {
                if (userInput.trim().isEmpty()) { // Exeption handling to detect empty inputs
                    System.out.println("⚠️ Input cannot be empty!");
                    continue;
                }

                // Convert the userInput String to an integer
                int choice = Integer.parseInt(userInput);

                switch (choice) {
                    case 1:
                        patientMenu();
                        break;
                    case 2:
                        caretakerMenu();
                        break;
                    case 3:
                        medicineMenu();
                        break;
                    case 4:
                        reminderMenu();
                        break;
                    case 5:
                        System.out.println("Exiting system...");
                        run = false; // stop loop
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice.");
                }

            } catch (NumberFormatException e) { // Exeption handling to detect if the user entered anything other than a number
                System.out.println("⚠️ Please enter a valid number!");
            }
        }
    }

    // ---- PATIENT ----
    public static void patientMenu() {
        boolean run = true;

        while (run) {
            System.out.println("\n--- PATIENT MENU ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");


            // Get the user input as a string
            String userInput = input.nextLine();

            try {
                if (userInput.trim().isEmpty()) { // Exeption handling to detect empty inputs
                    System.out.println("⚠️ Input cannot be empty!");
                    continue;
                }

                // Convert the userInput String to an integer
                int choice = Integer.parseInt(userInput);

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        System.out.println("Going Back to Main Menu...");
                        run = false; // Stop loop
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice.");
                }

            } catch (NumberFormatException e) { // Exeption handling to detect if the user entered anything other than a number
                System.out.println("⚠️ Please enter a valid number!");
            }
        }
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
        for (Patient patient : patients) {
            System.out.println("Patient " + count++);
            patient.displayPatient();
            System.out.println();
        }
    }

    // ---- CARETAKER ----
    public static void caretakerMenu() {
        boolean run = true;

        while (run) {

            System.out.println("\n--- CARETAKER MENU ---");
            System.out.println("1. Add Caretaker");
            System.out.println("2. View Caretakers");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            // Get the user input as a string
            String userInput = input.nextLine();

            try {
                if (userInput.trim().isEmpty()) { // Exeption handling to detect empty inputs
                    System.out.println("⚠️ Input cannot be empty!");
                    continue;
                }

                // Convert the userInput String to an integer
                int choice = Integer.parseInt(userInput);

                switch (choice) {
                    case 1:
                        addCaretaker();
                        break;
                    case 2:
                        viewCaretakers();
                        break;
                    case 3:
                        System.out.println("Back to Main Menu");
                        run = false; // Stop loop
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice.");
                }

            } catch (NumberFormatException e) { // Exeption handling to detect if the user entered anything other than a number
                System.out.println("⚠️ Please enter a valid number!");
            }

        }

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
        for (Caretaker caretaker : caretakers) {
            System.out.println("Caretaker " + count++);
            caretaker.displayCaretaker();
            System.out.println();
        }
    }

    // ---- MEDICINE ----
    public static void medicineMenu() {
        boolean run = true;

        while (run) {

            System.out.println("\n--- MEDICINE MENU ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            // Get the user input as a string
            String userInput = input.nextLine();

            try {
                if (userInput.trim().isEmpty()) { // Exeption handling to detect empty inputs
                    System.out.println("⚠️ Input cannot be empty!");
                    continue;
                }

                // Convert the userInput String to an integer
                int choice = Integer.parseInt(userInput);

                switch (choice) {
                    case 1:
                        addMedicine();
                        break;
                    case 2:
                        viewMedicines();
                        break;
                    case 3:
                        System.out.println("Back to Main Menu");
                        run = false; // Stop loop
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice.");
                }

            } catch (NumberFormatException e) { // Exeption handling to detect if the user entered anything other than a number
                System.out.println("⚠️ Please enter a valid number!");
            }

        }

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
        for (Medicine medicine : medicines) {
            System.out.println("Medicine " + count++);
            medicine.displayMedicine();
            System.out.println();
        }
    }

    // ---- REMINDER ----
    public static void reminderMenu() {
        boolean run = true;

        while (run) {

            System.out.println("\n--- REMINDER MENU ---");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
            System.out.println("3. Mark as Taken");
            System.out.println("4. Back");
            
            // Get the user input as a string
            String userInput = input.nextLine();

            try {
                if (userInput.trim().isEmpty()) { // Exeption handling to detect empty inputs
                    System.out.println("⚠️ Input cannot be empty!");
                    continue;
                }

                // Convert the userInput String to an integer
                int choice = Integer.parseInt(userInput);

                switch (choice) {
                    case 1:
                        addReminder();
                        break;
                    case 2:
                        viewReminders();
                        break;
                    case 3:
                        markReminderTaken();
                    case 4:
                        run = false; // Stop loop
                        break;
                    default:
                        System.out.println("⚠️ Invalid choice.");
                }

            } catch (NumberFormatException e) { // Exeption handling to detect if the user entered anything other than a number
                System.out.println("⚠️ Please enter a valid number!");
            }

        }
    }

    public static void addReminder() {
        System.out.print("Enter Patient Name: ");
        String patientName = input.nextLine();

        System.out.print("Enter Medicine Name: ");
        String medicineName = input.nextLine();

        System.out.print("Enter Time (HH:mm): ");
        String timeInput = input.nextLine();

        try {
            LocalTime time = LocalTime.parse(timeInput); // e.g. 08:00

            System.out.print("Enter Note: ");
            String note = input.nextLine();

            reminders.add(new Reminder(patientName, medicineName, time, note));
            System.out.println("Reminder added successfully.");

        } catch (Exception e) {
            System.out.println("⚠️ Invalid time format! Use HH:mm (e.g. 08:00)");
        }
    }

    public static void viewReminders() {
        System.out.println("\n--- REMINDER LIST ---");
        int count = 1;
        for (Reminder reminder : reminders) {
            System.out.println("Reminder " + count++);
            reminder.displayReminder();
            System.out.println();
        }
    }

    public static void markReminderTaken() {
        viewReminders();

        System.out.print("Enter reminder number: ");
        String inputValue = input.nextLine();

        try {
            int index = Integer.parseInt(inputValue) - 1;

            if (index >= 0 && index < reminders.size()) {
                reminders.get(index).markAsTaken();
                System.out.println("✅ Marked as taken.");
            } else {
                System.out.println("⚠️ Invalid number.");
            }

        } catch (NumberFormatException e) {
            System.out.println("⚠️ Enter a valid number!");
        }
    }

    public static void startReminderChecker() {
        new Thread(() -> {
            while (true) {
                try {
                    LocalTime now = LocalTime.now();

                    for (Reminder reminder : reminders) {

                        // If time passed and not taken flag as a missed dose
                        if (!reminder.taken && now.isAfter(reminder.time)) {
                            notifyCaretaker(reminder);
                            reminder.taken = true; // Prevent repeat alerts by updateing the take status to take after sending the notification
                        }
                    }

                    Thread.sleep(60000); // Check every 1 minute

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void notifyCaretaker(Reminder reminder) {
        for (Caretaker caretaker : caretakers) {

            if (caretaker.patientName.equalsIgnoreCase(reminder.patientName)) {

                System.out.println("\n🚨 ALERT: MISSED MEDICINE!");
                System.out.println("Patient: " + reminder.patientName);
                System.out.println("Medicine: " + reminder.medicineName);
                System.out.println("Notify Caretaker: " + caretaker.name);
                System.out.println("Phone: " + caretaker.phone);
            }
        }
    }
}