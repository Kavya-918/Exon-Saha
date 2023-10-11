import java.util.Scanner;

class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN; // Not-a-Number to represent an error
        }
        return (double) num1 / num2;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Calculator application exiting...");
                break;
            }

            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Result: " + calculator.add(num1, num2));
                    break;
                case 2:
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                    break;
                case 3:
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                    break;
                case 4:
                    System.out.println("Result: " + calculator.divide(num1, num2));
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid operation.");
            }
            System.out.println("------------------------");
            System.out.println("------------------------");

        }
        
        scanner.close();
    }
}
