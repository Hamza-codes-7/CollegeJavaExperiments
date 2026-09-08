import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        int choice;

        do {
            System.out.println("\n===== Student Registration System =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    list.insert(id, name, course);
                    break;

                case 2:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    list.delete(deleteId);
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    list.search(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    list.update(updateId, newName, newCourse);
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
