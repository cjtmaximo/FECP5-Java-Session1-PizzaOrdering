package org.example;

import java.util.*;

public class Main {
    public static boolean addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return false;
        }

        System.out.print("\n");
        pizzas.add(pizzaType);
        quantities.add(quantity);
        return true;
    }

    public static boolean updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (newQuantity <= 0) {
            System.out.println("Quantity must be positive.");
            return false;
        }

        if (quantities.isEmpty()) {
            System.out.println("Empty array.");
            return false;
        }

        System.out.print("\n");
        quantities.set(index, newQuantity);
        return true;
    }

    public static boolean removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Index out of bounds.");
            return false;
        }

        System.out.print("\n");
        pizzas.remove(index);
        quantities.remove(index);

        return true;
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.print("\n");
        System.out.println("--- Current Orders---");

        for (int i = 0; i < pizzas.toArray().length; i++) {
            System.out.printf("%d. %s x %d\n", i + 1, pizzas.get(i), quantities.get(i));
        }

        System.out.print("\n");
    }


    public static void main(String[] args) {
        // Initialize ArrayLists for pizzas and their quantities
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        // Initialize Scanner for user input
        Scanner userInput = new Scanner(System.in);
        int userChoice;

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        do {
            System.out.print("Choose option: ");
            userChoice = userInput.nextInt();
            userInput.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = userInput.nextLine();

                    boolean validAddOrder = false;
                    do {
                        System.out.print("Quantity: ");
                        int quantity = userInput.nextInt();
                        userInput.nextLine();

                        validAddOrder = addOrder(pizzas, quantities, pizzaType, quantity);
                    } while (!validAddOrder);

                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int orderNumberToUpdate = userInput.nextInt();
                    userInput.nextLine();

                    boolean validUpdateOrder = false;

                    do {
                        System.out.print("New quantity: ");
                        int newQuantity = userInput.nextInt();

                        validUpdateOrder = updateOrder(quantities, orderNumberToUpdate - 1, newQuantity);
                    } while(!validUpdateOrder);

                    break;
                case 3:
                    boolean validRemoveOrder = false;

                    do {
                        System.out.print("Order number to remove: ");
                        int orderNumberToRemove = userInput.nextInt();

                        validRemoveOrder = removeOrder(pizzas, quantities, orderNumberToRemove - 1);
                    } while (!validRemoveOrder);

                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
            }

        } while (userChoice != 5);

        System.out.println("---Thank you!---");
    }
}