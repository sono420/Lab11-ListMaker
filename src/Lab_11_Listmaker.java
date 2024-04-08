import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean done = false;

        while (!done) {
            displayList();
            displayMenu();
            String command = SafeInput.getRegExString(scanner, "Enter your choice (A/D/P/Q): ", "[AaDdPpQq]");

            switch (command.toUpperCase()) {
                case "A":
                    addItemToList();
                    break;
                case "D":
                    deleteItemFromList();
                    break;
                case "P":
                    break;
                case "Q":
                    done = confirmQuit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayList() {
        SafeInput.prettyHeader("Current List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static void displayMenu() {
        SafeInput.prettyHeader("Menu");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItemToList() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter the item to add to the list");
        list.add(item);
    }

    private static void deleteItemFromList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. No items to delete.");
            return;
        }

        displayList();
        int indexToDelete = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete", 1, list.size());
        list.remove(indexToDelete - 1);
        System.out.println("Item deleted successfully.");
    }

    private static boolean confirmQuit() {
        boolean confirm = SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N)");
        if (confirm) {
            System.out.println("Exiting program. Goodbye!");
        }
        return confirm;
    }
}
