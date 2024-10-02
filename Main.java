import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Main m = new Main();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        m.Question1();
        m.Question2();
        m.Question3();
        m.Question4();
        m.Question5();
        m.Question6();
        m.Question7();
        m.Question8();
        m.Question9();
        m.Question10();

        m.sc.close();
    }

    void Question1() {
        System.out.print("Enter an even number: ");
        int num = sc.nextInt();

        if (num % 2 != 0) {
            System.out.print("The number " + num + " is not an even number.");
            return;
        }

        Question1Part1(num);
        Question1Part2(num);
    }

    void Question1Part1(int num1) {
        long startTime = System.nanoTime();

        int num2 = 0;
        int num3 = 0;

        while (num2 != num1) {
            num2 += 2;
            if (num2 == num1) {
                System.out.print(num2);
            }
            else {
                System.out.print(num2 + ", ");
            }
            num3 += num2;
        }

        System.out.println("\nThe sum of all even components of the number " + num1 + " is " + num3 + ".");

        long endTime = System.nanoTime();

        System.out.println("The program took " + (endTime - startTime) + " nanoseconds to complete!");
    }

    void Question1Part2(int num1) {
        long startTime = System.nanoTime();

        int num2 = 0;
        int num3 = 0;

        while (num2 != num1) {
            num2++;
            if (num2 % 2 == 0) {
                num3 += num2;
            }

            if (num2 == num1) {
                System.out.print(num2);
            }
            else {
                System.out.print(num2 + ", ");
            }
        }

        System.out.println("\nThe sum of all even components of the number " + num1 + " is " + num3 + ".");

        long endTime = System.nanoTime();

        System.out.println("The program took " + (endTime - startTime) + " nanoseconds to complete!");
    }

    void Question2() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Your number cannot be a negative.");
            return;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println("The num " + num + " is not a prime number.");
                return;
            }
        }

        System.out.println("The num " + num + " is a prime number.");
    }

    void Question3() {
        System.out.print("Specify the amount of numbers for an int array: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        int curr;

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number [" + (i + 1) + "]: ");
            curr = sc.nextInt();
            arr[i] = curr;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }

        System.out.print("\nMin: " + MinNum(arr) + ",\nMax: " + MaxNum(arr));
    }

    int MinNum(int[] arr) {
        int min = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    int MaxNum(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (max < num) {
                max = num;
            }
        }

        return max;
    }

    void Question4() {
        System.out.print("\nTemperature converter:\nCelsius to Fahrenheit: C\nFahrenheit to Celsius: F\n");
        String option = sc.next();

        double cel = 0;
        double fah = 0;

        switch (option.toLowerCase()) {
            case "c":
                System.out.print("Enter a temperature in Celsius: ");
                cel = sc.nextDouble();
                fah = CelToFah(cel);
                System.out.printf("%.2f Celsius is %.2f Fahrenheit%n", cel, fah);
                break;
            case "f":
                System.out.print("Enter a temperature in Fahrenheit: ");
                fah = sc.nextDouble();
                cel = FahToCel(fah);
                System.out.printf("%.2f Fahrenheit is %.2f Celsius%n", fah , cel);
                break;
            default:
                System.out.println("Invalid option. Type either c or f.");
                break;
        }
    }

    double CelToFah(double cel) {
        return (cel * 9/5) + 32;
    }

    double FahToCel(double fah) {
        return (fah - 32) * 5/9;
    }

    void Question5() {
        System.out.print("Enter a word: ");
        String word = sc.next();
        StringBuilder rev = new StringBuilder(word).reverse();
        System.out.print("Word: " + word + ",\nReverse: " + rev);
        String revToLower = String.valueOf(rev).toLowerCase();

        if (word.toLowerCase().equals(revToLower)) {
            System.out.println("\nThe word " + word + " is a palindrome!");
        }
        else {
            System.out.println("\nThe word " + word + " is not a palindrome.");
        }
    }

    void Question6() {
        System.out.print("Choose between a (s)phere or a (c)ylinder: ");
        String option = sc.next();

        double r = 0;
        double v = 0;

        DecimalFormat df = new DecimalFormat("#.00");

        switch (option.toLowerCase()) {
            case "s":
                System.out.print("Type the radius: ");
                r = sc.nextDouble();
                System.out.print("The volume for the sphere is " + df.format(VolumeSphere(r)) + "!");
                break;
            case "c":
                System.out.print("Type the radius: ");
                r = sc.nextDouble();
                System.out.print("Type the height: ");
                double h = sc.nextDouble();
                System.out.print("The volume for the cylinder is " + df.format(VolumeCylinder(r, h)) + "!");
                break;
            default:
                System.out.print("Invalid option. Type either s or c.");
                break;
        }
    }

    double VolumeSphere(double r) {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    double VolumeCylinder(double r, double h) {
        return Math.PI * Math.pow(r, 2) * h;
    }

    void Question7() {
        System.out.print("\nEnter a shape (square, triangle, pyramid): ");
        String option = sc.next();

        int s = 0, r = 0;

        switch (option.toLowerCase()) {
            case "square":
                s = 5;

                for (int i = 1; i <= s; i++) {
                    for (int j = 1; j <= s; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case "triangle":
                r = 5;

                for (int i = 1; i <= r; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case "pyramid":
                r = 5;

                for (int i = 1; i <= r; i++) {
                    for (int j = i; j < r; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= (2 * i - 1); j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Invalid option. Type either square, triangle or pyramid.");
                break;
        }
    }

    void Question8() {
        System.out.print("Type a number between 1 and 3999: ");
        int num = sc.nextInt();

        if (num < 1 || num > 3999) {
            System.out.println("The number " + num + " is out of range.");
            return;
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String romanNumeral = thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];

        System.out.println("The Roman numeral representation of " + num + " is: " + romanNumeral);
    }

    void Question9() {
        System.out.print("Enter a word: ");
        String word = sc.next();

        String lowerWord = word.toLowerCase();
        String suffix = "ay";
        String pigLatin;

        if (isVowel(lowerWord.charAt(0))) {
            pigLatin = lowerWord + "ay";
        } else {
            pigLatin = lowerWord.substring(1) + lowerWord.charAt(0) + suffix;
        }

        System.out.println("Pig Latin: " + pigLatin);
    }

    boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    void Question10() {
        System.out.print("Enter a hexadecimal number: ");
        String hexInput = sc.next();

        try {
            int decimalValue = Integer.parseInt(hexInput, 16);
            System.out.println("Decimal value: " + decimalValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid hexadecimal number.");
        }
    }
}
