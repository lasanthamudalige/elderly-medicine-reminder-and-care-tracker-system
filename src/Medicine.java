public class Medicine {
    String medicineName;
    int dosage;
    String time;

    public Medicine(String medicineName, int dosage, String time) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.time = time;
    }
    public void displayMedicine() {
        System.out.println("Medicine Name: "+ medicineName);
        System.out.println("Dosage: " + dosage + " mg");
        System.out.println("Time: "+ time);
    }
}