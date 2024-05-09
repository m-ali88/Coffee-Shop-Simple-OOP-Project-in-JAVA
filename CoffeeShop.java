import java.util.Scanner;

// Define Coffee class
class Coffee {
    private String name;
    private double price;

    // Constructor
    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Define Biscuit class
class Biscuit {
    private String name;
    private double price;

    // Constructor
    public Biscuit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Define Order class
class Order {
    private Coffee coffee;
    private Biscuit biscuit;
    private int coffeeQuantity;
    private int biscuitQuantity;

    // Constructor
    public Order(Coffee coffee, int coffeeQuantity, Biscuit biscuit, int biscuitQuantity) {
        this.coffee = coffee;
        this.coffeeQuantity = coffeeQuantity;
        this.biscuit = biscuit;
        this.biscuitQuantity = biscuitQuantity;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        double coffeeCost = coffee != null ? coffee.getPrice() * coffeeQuantity : 0;
        double biscuitCost = biscuit != null ? biscuit.getPrice() * biscuitQuantity : 0;
        return coffeeCost + biscuitCost;
    }

    // Method to print invoice
    public void printInvoice() {
        System.out.println("------ Invoice ------");
        if (coffee != null) {
            System.out.println("Coffee: " + coffee.getName() + " x" + coffeeQuantity + " - $" + coffee.getPrice() * coffeeQuantity);
        }
        if (biscuit != null) {
            System.out.println("Biscuit: " + biscuit.getName() + " x" + biscuitQuantity + " - $" + biscuit.getPrice() * biscuitQuantity);
        }
        System.out.println("Total: $" + calculateTotalCost());
        System.out.println("---------------------");
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        // Create coffee objects
        Coffee americano = new Coffee("Americano", 2.50);
        Coffee latte = new Coffee("Latte", 3.00);
        Coffee cappuccino = new Coffee("Cappuccino", 3.50);
        Coffee espresso = new Coffee("Espresso", 2.00);
        Coffee mocha = new Coffee("Mocha", 4.00);

        // Create biscuit objects
        Biscuit chocolateChip = new Biscuit("Chocolate Chip", 1.50);
        Biscuit oatmeal = new Biscuit("Oatmeal", 1.75);
        Biscuit shortbread = new Biscuit("Shortbread", 1.25);

        // Prompt user with main menu
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\033[H\033[2J");
            System.out.println("Welcome to the Coffee Shop!");
            System.out.println("Main Menu:");
            System.out.println("1. Coffee");
            System.out.println("2. Biscuit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Prompt user for coffee choice
                    System.out.println("\033[H\033[2J");
                    System.out.println("Coffee Menu:");
                    System.out.println("1. " + americano.getName() + " - $" + americano.getPrice());
                    System.out.println("2. " + latte.getName() + " - $" + latte.getPrice());
                    System.out.println("3. " + cappuccino.getName() + " - $" + cappuccino.getPrice());
                    System.out.println("4. " + espresso.getName() + " - $" + espresso.getPrice());
                    System.out.println("5. " + mocha.getName() + " - $" + mocha.getPrice());
                    System.out.print("Enter your choice (1-5): ");
                    int coffeeChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    // Prompt user for quantity
                    System.out.print("Enter quantity for coffee: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Coffee coffee = null;
                    switch (coffeeChoice) {
                        case 1:
                            coffee = americano;
                            break;
                        case 2:
                            coffee = latte;
                            break;
                        case 3:
                            coffee = cappuccino;
                            break;
                        case 4:
                            coffee = espresso;
                            break;
                        case 5:
                            coffee = mocha;
                            break;
                        default:
                            System.out.println("Invalid coffee choice!");
                            break;
                    }

                    // Prompt user if they want a biscuit with coffee
                    System.out.print("Do you want a biscuit with your coffee? (yes/no): ");
                    String wantBiscuit = scanner.nextLine();

                    Biscuit selectedBiscuit = null;
                    if (wantBiscuit.equalsIgnoreCase("yes")) {
                        // Prompt user for biscuit choice
                        System.out.println("\033[H\033[2J");
                        System.out.println("Biscuit Menu:");
                        System.out.println("1. " + chocolateChip.getName() + " - $" + chocolateChip.getPrice());
                        System.out.println("2. " + oatmeal.getName() + " - $" + oatmeal.getPrice());
                        System.out.println("3. " + shortbread.getName() + " - $" + shortbread.getPrice());
                        System.out.print("Enter your choice (1-3): ");
                        int biscuitChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        // Prompt user for quantity
                        System.out.print("Enter quantity for biscuit: ");
                        int biscuitQuantity = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (biscuitChoice) {
                            case 1:
                                selectedBiscuit = chocolateChip;
                                break;
                            case 2:
                                selectedBiscuit = oatmeal;
                                break;
                            case 3:
                                selectedBiscuit = shortbread;
                                break;
                            default:
                                System.out.println("Invalid biscuit choice!");
                                break;
                        }
                    }

                    // Create order object and print invoice
                    if (coffee != null) {
                        Order order = new Order(coffee, quantity, selectedBiscuit, selectedBiscuit != null ? 1 : 0);
                        order.printInvoice();
                    }
                    break;
                case 2:
                    // Biscuit section
                    System.out.println("\033[H\033[2J");
                    System.out.println("Biscuit Menu:");
                    System.out.println("1. " + chocolateChip.getName() + " - $" + chocolateChip.getPrice());
                    System.out.println("2. " + oatmeal.getName() + " - $" + oatmeal.getPrice());
                    System.out.println("3. " + shortbread.getName() + " - $" + shortbread.getPrice());
                    System.out.print("Enter your choice (1-3): ");
                    int biscuitChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    // Prompt user for quantity
                    System.out.print("Enter quantity for biscuit: ");
                    int biscuitQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Biscuit biscuit = null;
                    switch (biscuitChoice) {
                        case 1:
                            biscuit = chocolateChip;
                            break;
                        case 2:
                            biscuit = oatmeal;
                            break;
                        case 3:
                            biscuit = shortbread;
                            break;
                        default:
                            System.out.println("Invalid biscuit choice!");
                            break;
                    }

                    // Prompt user if they want coffee with biscuits
                    System.out.print("Do you want coffee with your biscuits? (yes/no): ");
                    String wantCoffee = scanner.nextLine();

                    Coffee selectedCoffee = null;
                    if (wantCoffee.equalsIgnoreCase("yes")) {
                        // Prompt user for coffee choice
                        System.out.println("\033[H\033[2J");
                        System.out.println("Coffee Menu:");
                        System.out.println("1. " + americano.getName() + " - $" + americano.getPrice());
                        System.out.println("2. " + latte.getName() + " - $" + latte.getPrice());
                        System.out.println("3. " + cappuccino.getName() + " - $" + cappuccino.getPrice());
                        System.out.println("4. " + espresso.getName() + " - $" + espresso.getPrice());
                        System.out.println("5. " + mocha.getName() + " - $" + mocha.getPrice());
                        System.out.print("Enter your choice (1-5): ");
                        int coffeeChoiceWithBiscuit = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        // Prompt user for quantity
                        System.out.print("Enter quantity for coffee: ");
                        int quantityForCoffee = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (coffeeChoiceWithBiscuit) {
                            case 1:
                                selectedCoffee = americano;
                                break;
                            case 2:
                                selectedCoffee = latte;
                                break;
                            case 3:
                                selectedCoffee = cappuccino;
                                break;
                            case 4:
                                selectedCoffee = espresso;
                                break;
                            case 5:
                                selectedCoffee = mocha;
                                break;
                            default:
                                System.out.println("Invalid coffee choice!");
                                break;
                        }
                    }

                    // Create order object and print invoice
                    if (biscuit != null || selectedCoffee != null) {
                        Order order = new Order(selectedCoffee, selectedCoffee != null ? 1 : 0, biscuit, biscuitQuantity);
                        order.printInvoice();
                    }
                    break;
                case 3:
                    System.out.println("Thank you for visiting! Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                    break;
            }
            if (choice != 3) {
                System.out.print("Press Enter to continue...");
                scanner.nextLine(); // consume newline
            }
        } while (choice != 3);

        scanner.close();
    }
}
