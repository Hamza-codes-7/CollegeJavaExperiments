import java.util.Scanner;

class Patient {
    int id;
    String name;
    String problem;
    Patient next;

    Patient(int id, String name, String problem) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.next = null;
    }
}

class PatientStack {
    Patient top;

    void push(int id, String name, String problem) {
        Patient newPatient = new Patient(id, name, problem);
        newPatient.next = top;
        top = newPatient;
        System.out.println("Patient record added.");
    }

    void pop() {
        if (top == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("Removed patient: " + top.name);
        top = top.next;
    }

    void peek() {
        if (top == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nTop Patient Record");
        System.out.println("ID      : " + top.id);
        System.out.println("Name    : " + top.name);
        System.out.println("Problem : " + top.problem);
    }

    void display() {
        if (top == null) {
            System.out.println("No patient records available.");
            return;
        }

        Patient temp = top;

        System.out.println("\n--- Patient Records ---");

        while (temp != null) {
            System.out.println("ID      : " + temp.id);
            System.out.println("Name    : " + temp.name);
            System.out.println("Problem : " + temp.problem);
            System.out.println("-----------------------");
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientStack stack = new PatientStack();

        int choice;

        do {
            System.out.println("\n===== Hospital Patient Record System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. View Top Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Problem: ");
                    String problem = sc.nextLine();

                    stack.push(id, name, problem);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
