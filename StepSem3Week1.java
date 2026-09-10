import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class StepSem3Week1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Rock-Paper-Scissors Game
        System.out.println("--- 1. Rock-Paper-Scissors Game ---");
        playRpsGame(5);

        // 2. Palindrome Checker (3 Approaches)
        System.out.println("\n--- 2. Palindrome Checker ---");
        String[] testWords = {"madam", "hello"};
        for (String word : testWords) {
            System.out.println("Input: \"" + word + "\"");
            System.out.println("Iterative: " + (isPalindromeIterative(word) ? "Palindrome" : "Not Palindrome") +
                    " | Recursive: " + (isPalindromeRecursive(word) ? "Palindrome" : "Not Palindrome") +
                    " | Array Reversal: " + (isPalindromeArrayReversal(word) ? "Palindrome" : "Not Palindrome"));
        }

        // 3. BMI Calculator for a Team
        System.out.println("\n--- 3. BMI Calculator for a Team ---");
        double[] heights = {1.75, 1.60, 1.80, 1.55, 1.68};
        double[] weights = {70.0, 90.0, 65.0, 50.0, 82.0};
        printWellnessReport(heights, weights);

        // 4. First Non-Repeating Character
        System.out.println("\n--- 4. First Non-Repeating Character ---");
        String[] nonRepTests = {"swiss", "aabbcc"};
        for (String text : nonRepTests) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
            }
        }

        // 5. Reverse Customer Name
        System.out.println("\n--- 5. Reverse Customer Name ---");
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);

        scanner.close();
    }

    // --- Problem 1: Rock-Paper-Scissors Game ---
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void playRpsGame(int nRounds) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 1; i <= nRounds; i++) {
            String playerMove = moves[random.nextInt(moves.length)];
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("Round %d | %s | %s | %s%n", i, playerMove, computerMove, result);
        }

        double winPercentage = ((double) wins / nRounds) * 100.0;
        System.out.printf("Final Summary -> Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                wins, losses, draws, winPercentage);
    }

    // --- Problem 2: Palindrome Checker ---
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null || text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] revArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArr[i] = arr[arr.length - 1 - i];
        }
        return text.equals(new String(revArr));
    }

    // --- Problem 3: BMI Calculator for a Team ---
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        else if (bmi >= 25 && bmi <= 29.9) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d | %.2f | %.1f | %.2f | %s%n", (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    // --- Problem 4: First Non-Repeating Character ---
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }
        return '\0'; // Null character if none found
    }

    // --- Problem 5: Reverse Customer Name ---
    public static String reverseCustomerName(String customerName) {
        char[] charArray = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed.append(charArray[i]);
        }
        return reversed.toString();
    }
}