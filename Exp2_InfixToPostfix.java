import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '^')
            return 3;
        return -1;
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Infix Expression: ");
        String infix = sc.nextLine();

        String postfix = convertToPostfix(infix);

        System.out.println("Postfix Expression: " + postfix);

        sc.close();
    }
}
        System.out.println(queue[front] + " removed from queue.");

        front++;

        
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

   
    void peek() {

        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    void display() {

        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QueueExample q = new QueueExample();

        int choice;

        do {

            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
