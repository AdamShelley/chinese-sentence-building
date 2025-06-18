import java.util.*;


public class Main {
    public static void main(String args[]) {

        HashMap<String, List<String>> scenarios = new HashMap<>();

        List<String> responses = Arrays.asList("这咖啡太凉了", "咖啡有点儿凉");
        scenarios.put("Complain about cold coffee", responses);

        scenarios.put("Complain about hot weather", Arrays.asList("今天太热了", "这天气热死了", "热得受不了"));

        scenarios.put("Ask for the bill at restaurant", Arrays.asList("买单", "结账", "请问可以买单吗"));

        scenarios.put("Say you're running late", Arrays.asList("我要迟到了", "我可能会晚一点", "不好意思我来晚了"));

        HashMap<String, List<String>> copiedScenarios = new HashMap<>(scenarios);

        HashMap<String, String> userResponses = new HashMap<>();
        HashMap<String, List<String>> completedScenarios = new HashMap<>();

        int counter = 0;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        while (counter < 5 && !copiedScenarios.isEmpty()) {

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

        System.out.println("You have finished: Here is a summary: " );

        for (String key : completedScenarios.keySet()) {
            System.out.println("Scenario: " + key);
            System.out.println("You typed: " + userResponses.get(key));
            System.out.println("Correct answers: " + completedScenarios.get(key));
            System.out.println();
        }

    }
}
