/**
 * STREAMS - Interview Questions and Solutions
 * 
 * This file contains:
 * - Important Stream methods
 * - Basic to Advanced Interview Questions
 * - High-level problems using Stream API
 */

package stringsOp;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamsQuestions {
    
    // ============================================================================
    // STREAM METHODS
    // ============================================================================
    
    public static void demonstrateStreamMethods() {
        System.out.println("=== STREAM METHODS ===\n");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        
        // filter() - Filter elements
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);
        
        // map() - Transform elements
        List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);
        
        // flatMap() - Flatten nested collections
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattened = nested.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened);
        
        // distinct() - Remove duplicates
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unique = withDuplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique: " + unique);
        
        // sorted() - Sort elements
        List<Integer> sorted = Arrays.asList(5, 2, 8, 1, 9).stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);
        
        // groupingBy() - Group elements
        List<String> fruits = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");
        Map<Character, List<String>> grouped = fruits.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Grouped by first letter: " + grouped);
        
        // partitioningBy() - Partition into two groups
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned (even/odd): " + partitioned);
    }
    
    // ============================================================================
    // BASIC STREAM QUESTIONS
    // ============================================================================
    
    public static void basicStreamQuestions() {
        System.out.println("\n=== BASIC STREAM QUESTIONS ===\n");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "apricot", "avocado", "blueberry");
        
        // Q1: Find sum of squares of even numbers
        System.out.println("Q1: Sum of squares of even numbers");
        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n * n)
            .sum();
        System.out.println("Numbers: " + numbers);
        System.out.println("Sum of squares of evens: " + sumOfSquares);
        
        // Q2: Group strings by length
        System.out.println("\nQ2: Group strings by length");
        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Words: " + words);
        System.out.println("Grouped by length: " + groupedByLength);
        
        // Q3: Find average of numbers greater than 5
        System.out.println("\nQ3: Average of numbers > 5");
        double avg = numbers.stream()
            .filter(n -> n > 5)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
        System.out.println("Numbers: " + numbers);
        System.out.println("Average of numbers > 5: " + avg);
        
        // Q4: Count occurrences of each word
        System.out.println("\nQ4: Count occurrences of each word");
        List<String> wordList = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> wordCount = wordList.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Words: " + wordList);
        System.out.println("Word count: " + wordCount);
        
        // Q5: Find longest string
        System.out.println("\nQ5: Find longest string");
        Optional<String> longest = words.stream()
            .max(Comparator.comparing(String::length));
        System.out.println("Words: " + words);
        System.out.println("Longest: " + longest.orElse(""));
    }
    
    // ============================================================================
    // HIGH-LEVEL STREAM QUESTIONS
    // ============================================================================
    
    public static void highLevelStreamQuestions() {
        System.out.println("\n=== HIGH-LEVEL STREAM QUESTIONS ===\n");
        
        // Q1: Group array elements with frequency count using Streams
        // Example: {a,b,c,d,c,e} -> {(a:1), (b:1), (c:2), (d:1), (e:1)}
        System.out.println("Q1: Group array elements with frequency count");
        Character[] arr1 = {'a', 'b', 'c', 'd', 'c', 'e'};
        Map<Character, Long> frequency = Arrays.stream(arr1)
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Frequency Map: " + frequency);
        // Format output as requested
        System.out.print("Formatted: {");
        frequency.entrySet().forEach(entry -> 
            System.out.print("(" + entry.getKey() + ":" + entry.getValue() + "), ")
        );
        System.out.println("\b\b}"); // Remove last comma and space
        
        // Q2: Find top N elements by frequency
        System.out.println("\nQ2: Find top N elements by frequency");
        List<Integer> list2 = Arrays.asList(1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5);
        int n = 3;
        Map<Integer, Long> freq2 = list2.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<Integer, Long>> topN = freq2.entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .limit(n)
            .collect(Collectors.toList());
        System.out.println("List: " + list2);
        System.out.println("Top " + n + " by frequency: " + topN);
        
        // Q3: Group by multiple criteria
        System.out.println("\nQ3: Group by multiple criteria");
        List<String> list3 = Arrays.asList("apple", "banana", "apricot", "avocado", "blueberry", "berry");
        Map<String, List<String>> grouped = list3.stream()
            .collect(Collectors.groupingBy(s -> 
                s.length() > 5 ? "Long" : "Short"
            ));
        System.out.println("Words: " + list3);
        System.out.println("Grouped by length category: " + grouped);
        
        // Q4: Find distinct characters from list of strings
        System.out.println("\nQ4: Find distinct characters from list of strings");
        List<String> list4 = Arrays.asList("apple", "banana", "cherry");
        Set<Character> distinctChars = list4.stream()
            .flatMapToInt(String::chars)
            .mapToObj(c -> (char) c)
            .collect(Collectors.toSet());
        System.out.println("Words: " + list4);
        System.out.println("Distinct chars: " + distinctChars);
        
        // Q5: Partition numbers into even and odd
        System.out.println("\nQ5: Partition numbers into even and odd");
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Map<Boolean, List<Integer>> partitioned = list5.stream()
//            .collect(Collectors.partitioningBy(n1 -> n1 % 2 == 0));
//        System.out.println("Numbers: " + list5);
//        System.out.println("Even: " + partitioned.get(true));
//        System.out.println("Odd: " + partitioned.get(false));
        
        // Q6: Find sum of all even numbers squared
     
        // Q7: Group strings by first character and count
        System.out.println("\nQ7: Group strings by first character and count");
        List<String> list7 = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");
        Map<Character, Long> groupedByFirst = list7.stream()
            .collect(Collectors.groupingBy(
                s -> s.charAt(0),
                Collectors.counting()
            ));
        System.out.println("Words: " + list7);
        System.out.println("Count by first letter: " + groupedByFirst);
        
        // Q8: Find average length of strings
        System.out.println("\nQ8: Find average length of strings");
        List<String> list8 = Arrays.asList("apple", "banana", "apricot", "avocado", "blueberry");
        double avgLength = list8.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
        System.out.println("Words: " + list8);
        System.out.println("Average length: " + avgLength);
        
        // Q9: Find strings with length greater than average
        System.out.println("\nQ9: Find strings with length greater than average");
        List<String> list9 = Arrays.asList("apple", "banana", "apricot", "avocado", "blueberry");
        double avgLen = list9.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);
        List<String> longerThanAvg = list9.stream()
            .filter(s -> s.length() > avgLen)
            .collect(Collectors.toList());
        System.out.println("Words: " + list9);
        System.out.println("Average length: " + avgLen);
        System.out.println("Longer than average: " + longerThanAvg);
        
//        // Q10: Group numbers by range
//        System.out.println("\nQ10: Group numbers by range");
//        List<Integer> list10 = Arrays.asList(1, 5, 12, 15, 25, 30, 45, 50);
//        Map<String, List<Integer>> groupedByRange = list10.stream()
//            .collect(Collectors.groupingBy(n -> {
//                if (n < 10) return "0-9";
//                else if (n < 20) return "10-19";
//                else if (n < 30) return "20-29";
//                else return "30+";
//            }));
//        System.out.println("Numbers: " + list10);
//        System.out.println("Grouped by range: " + groupedByRange);
        
       
        
        // Q12: Flatten nested list and find distinct elements
        System.out.println("\nQ12: Flatten nested list and find distinct elements");
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(2, 3, 4),
            Arrays.asList(3, 4, 5)
        );
        List<Integer> distinct = nested.stream()
            .flatMap(List::stream)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Nested: " + nested);
        System.out.println("Distinct flattened: " + distinct);
    }
    
    // ============================================================================
    // MAIN METHOD
    // ============================================================================
    
    public static void main(String[] args) {
        demonstrateStreamMethods();
        basicStreamQuestions();
        highLevelStreamQuestions();
        
        System.out.println("\n=== STREAMS QUESTIONS COMPLETE ===");
    }
}

