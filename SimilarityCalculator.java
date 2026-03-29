import java.util.*;

public class SimilarityCalculator {

    public static double calculateScore(List<String> resume, List<String> job) {
        Set<String> resumeSet = new HashSet<>(resume);
        Set<String> jobSet = new HashSet<>(job);

        int matchCount = 0;
        for (String word : jobSet) {
            if (resumeSet.contains(word)) {
                matchCount++;
            }
        }

        return (double) matchCount / jobSet.size() * 100;
    }

    public static List<String> missingKeywords(List<String> resume, List<String> job) {
        Set<String> resumeSet = new HashSet<>(resume);
        Set<String> jobSet = new HashSet<>(job);

        List<String> missing = new ArrayList<>();
        for (String word : jobSet) {
            if (!resumeSet.contains(word)) {
                missing.add(word);
            }
        }
        return missing;
    }
}