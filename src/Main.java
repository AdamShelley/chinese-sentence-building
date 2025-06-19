import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> scenarios = loadScenarios();

        HashMap<String, String> userResponses = new HashMap<>();
        HashMap<String, List<String>> completedScenarios = new HashMap<>();

        runPracticeSession(scenarios, userResponses, completedScenarios, 5);
        displaySummary(userResponses, completedScenarios);
    }

    public static HashMap<String, List<String>> loadScenarios() {
        try {
            String jsonContent = Files.readString(Paths.get("src/scenarios.json"));
            // transform json content
            Gson gson = new Gson();
            TypeToken<HashMap<String, List<String>>> typeToken = new TypeToken<HashMap<String, List<String>>>() {
            };
            return gson.fromJson(jsonContent, typeToken.getType());

        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    public static void runPracticeSession(HashMap<String, List<String>> scenarios,
                                          HashMap<String, String> userResponses,
                                          HashMap<String, List<String>> completedScenarios,
                                          int rounds) {
        int counter = 0;
        HashMap<String, List<String>> copiedScenarios = new HashMap<>(scenarios);
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        while (counter < rounds && !copiedScenarios.isEmpty()) {

            String[] keys = copiedScenarios.keySet().toArray(new String[0]);
            String randomKey = keys[rand.nextInt(keys.length)];

            System.out.println("Scenario: " + randomKey);

            System.out.print("Your response: ");
            String userInput = scanner.nextLine();

            List<String> answers = copiedScenarios.get(randomKey);
            System.out.println("\nSample responses:");
            for (String answer : answers) {
                System.out.println("- " + answer);
            }

            userResponses.put(randomKey, userInput);
            completedScenarios.put(randomKey, answers);

            copiedScenarios.remove(randomKey);

            counter++;
        }
    }

    public static void displaySummary(HashMap<String, String> userResponses, HashMap<String, List<String>> completedScenarios){
        System.out.println("You have finished, Here is a summary: ");

        for (String key : completedScenarios.keySet()) {
            System.out.println("Scenario: " + key);
            System.out.println("You typed: " + userResponses.get(key));
            System.out.println("Correct answers: " + completedScenarios.get(key));
            System.out.println();
        }
    }
}
