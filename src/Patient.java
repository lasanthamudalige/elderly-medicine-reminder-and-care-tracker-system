public class Patient {
    String name;
    int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayPatient() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
    }
}