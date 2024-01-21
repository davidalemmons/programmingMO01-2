import java.util.Scanner;

public class CreditCardValidation {
    public static void main(String[] args) {
        long creditCardNumber = getCreditCardNumber();

        if (isValidLength(creditCardNumber) && isValid(creditCardNumber)) {
            System.out.println(creditCardNumber+ " is valid.");
        } else {
            System.out.println(creditCardNumber+ " is invalid.");
        }
    }

    public static long getCreditCardNumber() {
        Scanner scanner = new Scanner(System.in);
        long creditCardNumber = 0;

        while (true) {
            System.out.print("Enter a credit card number (13-16 digits): ");
            try {
                creditCardNumber = Long.parseLong(scanner.nextLine());
        
                if (isValidLength(creditCardNumber)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        

        scanner.close();
        return creditCardNumber;
    }

    public static boolean isValid(long number) {
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (sum % 10 == 0);
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numString = Long.toString(number);

        for (int i = numString.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(numString.substring(i, i + 1));
            sum += getDigit(digit * 2);
        }

        return sum;
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numString = Long.toString(number);

        for (int i = numString.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(numString.substring(i, i + 1));
        }

        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return (number / 10) + (number % 10);
        }
    }

    public static boolean isValidLength(long number) {
        int length = String.valueOf(number).length();
        return (length >= 13 && length <= 16);
    }
}
