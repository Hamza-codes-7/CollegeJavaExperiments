import java.util.Scanner;

class PlayerNode {
    String name;
    PlayerNode next;

    public PlayerNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class CircularLinkedList {
    private PlayerNode head = null;
    private PlayerNode tail = null;

    // 1. Add a player to the end of the circle
    public void addPlayer(String name) {
        PlayerNode newNode = new PlayerNode(name);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Points to itself to maintain circularity
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Last node points back to head
        }
        System.out.println("Player '" + name + "' added to the game.");
    }

    // 2. Remove a player by name
    public void removePlayer(String name) {
        if (head == null) {
            System.out.println("No players in the circle to remove!");
            return;
        }

        PlayerNode current = head;
        PlayerNode previous = tail;
        boolean found = false;

        // Traverse the circular list to find the player
        do {
            if (current.name.equalsIgnoreCase(name)) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Player '" + name + "' not found in the game.");
            return;
        }

        // Case 1: Only one player in the list
        if (head == tail && current == head) {
            head = null;
            tail = null;
        }
        // Case 2: Removing the head node
        else if (current == head) {
            head = head.next;
            tail.next = head;
        }
        // Case 3: Removing the tail node
        else if (current == tail) {
            tail = previous;
            tail.next = head;
        }
        // Case 4: Removing a node in between
        else {
            previous.next = current.next;
        }

        System.out.println("Player '" + name + "' removed from the game.");
    }

    // 3. Move turn to the next player (rotate circle)
    public void passTurn() {
        if (head == null) {
            System.out.println("No players available!");
            return;
        }

        System.out.println("Current turn was completed by: " + head.name);
        head = head.next;
        tail = tail.next;
        System.out.println("It is now " + head.name + "'s turn!");
    }

    // 4. Display all players in turn order starting from current turn
    public void displayPlayers() {
        if (head == null) {
            System.out.println("The player circle is empty.");
            return;
        }

        PlayerNode current = head;
        System.out.print("Player Turn Order: ");
        do {
            System.out.print("[" + current.name + "]");
            current = current.next;
            if (current != head) {
                System.out.print(" -> ");
            }
        } while (current != head);

        System.out.println(" -> (back to " + head.name + ")");
    }
}

public class GameTurnManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList gameCircle = new CircularLinkedList();

        while (true) {
            System.out.println("\n===== CIRCULAR TURN MANAGER MENU =====");
            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Pass Turn to Next Player");
            System.out.println("4. Display All Players");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String addName = scanner.nextLine().trim();
                    if (!addName.isEmpty()) {
                        gameCircle.addPlayer(addName);
                    } else {
                        System.out.println("Player name cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter player name to remove: ");
                    String removeName = scanner.nextLine().trim();
                    gameCircle.removePlayer(removeName);
                    break;

                case 3:
                    gameCircle.passTurn();
                    break;

                case 4:
                    gameCircle.displayPlayers();
                    break;

                case 5:
                    System.out.println("Exiting Turn Manager. Game Over!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
            }
        }
    }
}