import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String text : tests) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
            }
        }
    }

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
        return '\0';
    }
}