package lab1app.tasks;

public class PalindromeChecker {
    public boolean isPalindrome(String input) {
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        int len = cleanedInput.length();
        for (int i = 0; i < len / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}