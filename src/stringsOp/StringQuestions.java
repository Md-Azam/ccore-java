/**
 * STRINGS - Interview Questions and Solutions
 * 
 * This file contains:
 * - Important String methods
 * - Basic to Advanced Interview Questions
 * - High-level problems including Anagrams, Longest Substring, etc.
 */
package stringsOp;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StringQuestions {
    
    // ============================================================================
    // STRING METHODS
    // ============================================================================
    
    public static void demonstrateStringMethods() {
        System.out.println("=== STRING METHODS ===\n");
        
        String str = "  Hello World  ";
        String str1 = "Java";
        
        // Basic operations
        System.out.println("Length: " + str.length());
        System.out.println("Char at index 3: " + str.charAt(3));
        System.out.println("Substring(2,7): " + str.substring(2, 7));
        System.out.println("Contains 'World': " + str.contains("World"));
        
        // Case conversion
        System.out.println("To uppercase: " + str.toUpperCase());
        System.out.println("To lowercase: " + str.toLowerCase());
        
        // Trimming
        System.out.println("Trimmed: '" + str.trim() + "'");
        System.out.println("Is blank: " + str.isBlank());
        
        // Comparison
        System.out.println("Equals: " + str1.equals("Java"));
        System.out.println("Starts with: " + str.startsWith("Hello"));
        
        // Searching
        System.out.println("Index of 'World': " + str.indexOf("World"));
        
        // Replacement
        System.out.println("Replace: " + str.replace("World", "Java"));
        
        // Splitting and joining
        String[] words = str.trim().split(" ");
        System.out.println("Split: " + Arrays.toString(words));
        String joined = String.join("-", words);
        System.out.println("Joined: " + joined);
    }
    
    // ============================================================================
    // BASIC STRING QUESTIONS
    // ============================================================================
    
    public static void basicStringQuestions() {
        System.out.println("\n=== BASIC STRING QUESTIONS ===\n");
        
        // Q1: Check if string is palindrome
        System.out.println("Q1: Check if string is palindrome");
        String str1 = "racecar";
        boolean isPalindrome = IntStream.range(0, str1.length() / 2)
            .allMatch(i -> str1.charAt(i) == str1.charAt(str1.length() - 1 - i));
        System.out.println(str1 + " is palindrome: " + isPalindrome);
        
        // Q2: Reverse a string
        System.out.println("\nQ2: Reverse a string");
        String str2 = "Hello";
        String reversed = new StringBuilder(str2).reverse().toString();
        System.out.println("Original: " + str2);
        System.out.println("Reversed: " + reversed);
        
        // Q3: Count character frequency
        System.out.println("\nQ3: Count character frequency");
        String str3 = "hello";
        Map<Character, Long> charFreq = str3.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("String: " + str3);
        System.out.println("Frequency: " + charFreq);
        
        // Q4: Find first non-repeating character
        System.out.println("\nQ4: Find first non-repeating character");
        String str4 = "hello";
        Optional<Character> firstNonRepeat = str4.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst();
        System.out.println("String: " + str4);
        System.out.println("First non-repeating: " + firstNonRepeat.orElse(null));
        
        // Q5: Remove duplicates from string
        System.out.println("\nQ5: Remove duplicates from string");
        String str5 = "programming";
        String unique = str5.chars()
            .distinct()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
        System.out.println("Original: " + str5);
        System.out.println("Unique chars: " + unique);
    }
    
    // ============================================================================
    // HIGH-LEVEL STRING QUESTIONS
    // ============================================================================
    
    public static void highLevelStringQuestions() {
        System.out.println("\n=== HIGH-LEVEL STRING QUESTIONS ===\n");
        
        // Q1: Check if two strings are anagrams
        System.out.println("Q1: Check if two strings are anagrams");
        String str1a = "listen";
        String str1b = "silent";
        boolean areAnagrams = Arrays.equals(
            str1a.toLowerCase().chars().sorted().toArray(),
            str1b.toLowerCase().chars().sorted().toArray()
        );
        System.out.println("String1: " + str1a);
        System.out.println("String2: " + str1b);
        System.out.println("Are anagrams: " + areAnagrams);
        
        // Alternative approach using frequency map
        Map<Character, Long> freq1 = str1a.toLowerCase().chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freq1: "+ freq1);
        Map<Character, Long> freq2 = str1b.toLowerCase().chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean areAnagrams2 = freq1.equals(freq2);
        System.out.println("Are anagrams (method 2): " + areAnagrams2);
        System.out.println("freq2: "+ freq2);
        
        // Q2: Find longest substring without repeating characters
        System.out.println("\nQ2: Find longest substring without repeating characters");
        String str2 = "abcabcbb";
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        String longestSubstring = "";
        
        for (int end = 0; end < str2.length(); end++) {
            char c = str2.charAt(end);
            if (charMap.containsKey(c) && charMap.get(c) >= start) {
                start = charMap.get(c) + 1;
            }
            charMap.put(c, end);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestSubstring = str2.substring(start, end + 1);
            }
        }
        System.out.println("String: " + str2);
        System.out.println("Longest substring length: " + maxLength);
        System.out.println("Longest substring: " + longestSubstring);
        
        // Q3: Group anagrams together
        System.out.println("\nQ3: Group anagrams together");
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> anagramGroups = Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }));
        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Grouped anagrams: " + anagramGroups.values());
        
        // Q4: Longest common prefix
        System.out.println("\nQ4: Find longest common prefix");
        String[] strs = {"flower", "flow", "flight"};
        if (strs.length == 0) {
            System.out.println("No common prefix");
        } else {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) break;
                }
            }
            System.out.println("Strings: " + Arrays.toString(strs));
            System.out.println("Longest common prefix: " + prefix);
        }
        
        // Q5: Valid parentheses
        System.out.println("\nQ5: Check if parentheses are valid");
        String str5 = "()[]{}";
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        
        boolean isValid = true;
        for (char c : str5.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    isValid = false;
                    break;
                }
            }
        }
        System.out.println("String: " + str5);
        System.out.println("Is valid: " + (isValid && stack.isEmpty()));
        
        // Q6: Count words in a string
        System.out.println("\nQ6: Count words in a string");
        String str6 = "Hello World Java Programming";
        long wordCount = Arrays.stream(str6.split("\\s+"))
            .filter(s -> !s.isEmpty())
            .count();
        System.out.println("String: " + str6);
        System.out.println("Word count: " + wordCount);
        
        // Q7: Reverse words in a string
        System.out.println("\nQ7: Reverse words in a string");
        String str7 = "Hello World Java";
        String reversedWords = Arrays.stream(str7.split("\\s+"))
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    Collections.reverse(list);
                    return String.join(" ", list);
                }
            ));
        System.out.println("Original: " + str7);
        System.out.println("Reversed words: " + reversedWords);
        
        // Q8: Check if string contains only digits
        System.out.println("\nQ8: Check if string contains only digits");
        String str8 = "12345";
        boolean onlyDigits = str8.chars().allMatch(Character::isDigit);
        System.out.println("String: " + str8);
        System.out.println("Only digits: " + onlyDigits);
        
        // Q9: Find all anagrams of a pattern in a string
        System.out.println("\nQ9: Find all anagrams of a pattern in a string");
        String str9 = "cbaebabacd";
        String pattern = "abc";
        List<Integer> indices = new ArrayList<>();
        
        // Frequency map of pattern
        Map<Character, Integer> patternFreq = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }
        
        // Sliding window
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0;
        for (int right = 0; right < str9.length(); right++) {
            char c = str9.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (right - left + 1 == pattern.length()) {
                if (windowFreq.equals(patternFreq)) {
                    indices.add(left);
                }
                char leftChar = str9.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (windowFreq.get(leftChar) == 0) {
                    windowFreq.remove(leftChar);
                }
                left++;
            }
        }
        System.out.println("String: " + str9);
        System.out.println("Pattern: " + pattern);
        System.out.println("Anagram indices: " + indices);
        
        // Q10: Minimum window substring
        System.out.println("\nQ10: Minimum window substring");
        String str10 = "ADOBECODEBANC";
        String target = "ABC";
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> windowFreq2 = new HashMap<>();
        int left2 = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int required = targetFreq.size(), formed = 0;
        
        for (int right = 0; right < str10.length(); right++) {
            char c = str10.charAt(right);
            windowFreq2.put(c, windowFreq2.getOrDefault(c, 0) + 1);
            
            if (targetFreq.containsKey(c) && 
                windowFreq2.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }
            
            while (left2 <= right && formed == required) {
                if (right - left2 + 1 < minLen) {
                    minLen = right - left2 + 1;
                    minStart = left2;
                }
                char leftChar = str10.charAt(left2);
                windowFreq2.put(leftChar, windowFreq2.get(leftChar) - 1);
                if (targetFreq.containsKey(leftChar) && 
                    windowFreq2.get(leftChar) < targetFreq.get(leftChar)) {
                    formed--;
                }
                left2++;
            }
        }
        System.out.println("String: " + str10);
        System.out.println("Target: " + target);
        System.out.println("Minimum window: " + 
            (minLen == Integer.MAX_VALUE ? "" : str10.substring(minStart, minStart + minLen)));
    }
    
    // ============================================================================
    // MAIN METHOD
    // ============================================================================
    
    public static void main(String[] args) {
        demonstrateStringMethods();
        basicStringQuestions();
        highLevelStringQuestions();
        
        System.out.println("\n=== STRING QUESTIONS COMPLETE ===");
    }
}

