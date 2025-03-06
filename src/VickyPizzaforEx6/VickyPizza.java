package VickyPizzaforEx6;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class VickyPizza {
    Scanner scanner = new Scanner(System.in);

    public void takeOrder() {
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ing1 = scanner.next();
        String ing2 = scanner.next();
        String ing3 = scanner.next();

        System.out.println(ing1);
        System.out.println(ing2);
        System.out.println(ing3);


        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.next();
        System.out.println(pizzaSize);

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.next();
        System.out.println(extraCheese);

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.next();
        System.out.println(sideDish);

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = scanner.next();
        System.out.println(drinks);

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.next();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    public void isItYourBirthday() {
        System.out.println("Please enter your birthday (in the format yyyy-MM-dd):");
        String birthdateStr = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdateStr, formatter);

        LocalDate today = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthdate, today);

        if (age < 18 && birthdate.getMonth() == today.getMonth() && birthdate.getDayOfMonth() == today.getDayOfMonth()) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public void makeCardPayment() {
        System.out.println("Please enter your card number:");
        long cardNumber = scanner.nextLong();

        System.out.println("Please enter the card's expiry date (YYYY-MM):");
        String expiryDate = scanner.next();

        System.out.println("Please enter the card's cvv number (3 digits):");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() == 14) {
            long blacklistedNumber = 12345678901234L;
            if (cardNumber == blacklistedNumber) {
                System.out.println("Card is blacklisted. Please use another card");
                return;
            }

            char firstCardDigit = cardNumberStr.charAt(0);
            String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);

            StringBuilder cardNumberToDisplay = new StringBuilder();
            cardNumberToDisplay.append(firstCardDigit);
            for (int i = 1; i < cardNumberStr.length() - 4; i++) {
                cardNumberToDisplay.append('*');
            }
            cardNumberToDisplay.append(lastFourDigits);

            System.out.println("Card accepted");
            System.out.println("First digit of the card: " + firstCardDigit);
            System.out.println("Last four digits of the card: " + lastFourDigits);
            System.out.println("Card number to display: " + cardNumberToDisplay);
        } else {
            System.out.println("Invalid card");
        }
    }

    public void specialOfTheDay() {
        
    }

    public void printReceipt() {
     
        System.out.println("Receipt will be printed here with appropriate details.");
    }
}








