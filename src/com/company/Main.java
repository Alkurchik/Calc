package com.company;
import java.util.Scanner;

public class Main {
    public static int memory;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter value_1:");
            int num_1 = getInt();
            System.out.println("Please enter value_2:");
            int num_2 = getInt();
            char operation = getOperation();
            int result = calculator(num_1, num_2, operation);
            System.out.println("Operation result: " + result);
            System.out.println("Do you want to store the value in memory? M/N:");
            char text_1 = scanner.next().charAt(0);
            if (text_1 == 'M') {
                memory = result;
                System.out.println("You saved the value: " + memory);
            } else {
                memory = 0;
            }
            System.out.println("Хотите продолжить? Y/N:");
            char trigger = scanner.next().charAt(0);
            if (trigger == 'N'){
                break;
            }


        }
    }

    public static int getInt() {
        int num;
        char text = ' ';

        if (memory > 0) {
            System.out.println("Do you want to set a value from memory? M/N:");
            text = scanner.next().charAt(0);
        }
        if (text == 'M') {
            num = memory;
            System.out.println("You set a number from memory: " + num);
        } else if (scanner.hasNextInt() || text == 'N') {
            num = scanner.nextInt();
        } else {
            System.out.println("You made a mistake entering the number. Try again.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Select operation: '+', '-', '*', '/' :");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("You made a mistake entering the operation. Try again.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calculator(int num_1, int num_2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num_1 + num_2;
                break;
            case '-':
                result = num_1 - num_2;
                break;
            case '*':
                result = num_1 * num_2;
                break;
            case '/':
                result = num_1 / num_2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculator(num_1, num_2, getOperation());
        }
        return result;
    }
}
