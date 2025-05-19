package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapAndHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> charCountMap = countCharacters(inputString);

        // Display the occurrences of each character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println("Character: " + entry.getKey() + "  Occurrences: " + entry.getValue());
        
        }    
        charCountMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }   
    public static Map<Character, Integer> countCharacters(String input) {
        // Create a map to store character occurrences
        Map<Character, Integer> charCountMap = new HashMap<>();
        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            // Update the count in the map
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }
}