import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Load resume
            String resumeText = ResumeParser.extractText("resume.pdf");

            // Load job description
            String jobText = new String(Files.readAllBytes(Paths.get("sample_job.txt")));

            // Process text
            List<String> resumeWords = TextProcessor.process(resumeText);
            List<String> jobWords = TextProcessor.process(jobText);

            // Calculate score
            double score = SimilarityCalculator.calculateScore(resumeWords, jobWords);

            // Missing keywords
            List<String> missing = SimilarityCalculator.missingKeywords(resumeWords, jobWords);

            System.out.println("Match Score: " + score + "%");

            if (score > 70) {
                System.out.println("Good match!");
            } else {
                System.out.println("Needs improvement!");
            }

            System.out.println("\nMissing Keywords:");
            for (String word : missing) {
                System.out.println("- " + word);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}