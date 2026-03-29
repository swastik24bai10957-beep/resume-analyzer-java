import java.util.*;

public class TextProcessor {

    public static List<String> process(String text) {

        // Convert to lowercase and remove special characters
        text = text.toLowerCase().replaceAll("[^a-z ]", "");

        // Split into words
        String[] words = text.split("\\s+");

        // Stopwords list (common useless words)
        List<String> stopwords = Arrays.asList(
            "the","is","and","with","for","a","an","to","of","in","on",
            "looking","candidate","required","job","skills","experience",
            "this","that","are","as","be","by","or","from"
        );

        // Store meaningful words
        List<String> filtered = new ArrayList<>();

        for (String word : words) {
            if (word.length() > 2 && !stopwords.contains(word)) {
                filtered.add(word);
            }
        }

        return filtered;
    }
}