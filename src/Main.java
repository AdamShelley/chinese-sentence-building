import java.util.*;


public class Main {
    public static void main(String args[]) {

        HashMap<String, List<String>> scenarios = new HashMap<>();


        List<String> responses = Arrays.asList("这咖啡太凉了", "咖啡有点儿凉");
        scenarios.put("Complain about cold coffee", responses);

        scenarios.put("Complain about hot weather", Arrays.asList("今天太热了", "这天气热死了", "热得受不了"));

        scenarios.put("Ask for the bill at restaurant", Arrays.asList("买单", "结账", "请问可以买单吗"));

        scenarios.put("Say you're running late", Arrays.asList("我要迟到了", "我可能会晚一点", "不好意思我来晚了"));


        Random rand = new Random();
        String[] keys = scenarios.keySet().toArray(new String[0]);
        String randomKey = keys[rand.nextInt(keys.length)];

        System.out.println("Scenario: " + randomKey);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your response: ");
        String userInput = scanner.nextLine();

        List<String> answers = scenarios.get(randomKey);
        System.out.println("\nSample responses:");
        for (String answer : answers) {
            System.out.println("- " + answer);
        }
    }
}
