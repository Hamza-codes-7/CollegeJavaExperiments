import java.util.Scanner;

class SinglyLinkedList {
    static class Node {
        int rollNo;
        String name;
        String course;
        Node next;

        Node(int rollNo, String name, String course) {
            this.rollNo = rollNo;
            this.name = name;
            this.course = course;
        }
    }

    Node head;

    void insert(int rollNo, String name, String course) {
        Node newNode = new Node(rollNo, name, course);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void delete(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    void search(int rollNo) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Course: " + temp.course);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    void update(int rollNo, String name, String course) {
        Node temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.name = name;
                temp.course = course;
                System.out.println("Student record updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Course: " + temp.course);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    list.insert(rollNo, name, course);
                    System.out.println("Student inserted.");
                    break;

                case 2:
                    System.out.print("Enter roll number to delete: ");
                    rollNo = sc.nextInt();
                    list.delete(rollNo);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    rollNo = sc.nextInt();
                    list.search(rollNo);
                    break;

                case 4:
                    System.out.print("Enter roll number to update: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    name = sc.nextLine();

                    System.out.print("Enter new course: ");
                    course = sc.nextLine();

                    list.update(rollNo, name, course);
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
