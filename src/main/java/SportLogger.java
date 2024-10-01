import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SportLogger {
    private static final Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Integer> activityMap = new HashMap<String, Integer>();
    private static boolean flag;

    private static void displayLoggedActivities() {
        for (Map.Entry<String, Integer> activity : activityMap.entrySet()) {
            System.out.println("Activity: " + activity.getKey() + "\n" + "Time spent: " + activity.getValue());
            System.out.println("═══════════════════════════════════════");
        }
    }

    private static void addActivity(String name, int timeSpent) {
        activityMap.put(name, timeSpent);
        System.out.println("Activity " + name + "added to logged.");
    }

    private static void checkTotalTime() {
        double totalTimeSpent = 0;
        for (Map.Entry<String, Integer> activity : activityMap.entrySet()) {
            totalTimeSpent += activity.getValue();
        }
        System.out.printf("\nTotal time spent on activities this week: %.2f hours.\n", totalTimeSpent / 60);
    }

    private static void start() {
        System.out.println("SportLogger-9000");
        flag = true;
        while (flag) {
            System.out.println("Choose your action:\n1 Add new activity and time.\n" +
                    "2 Display logged activities.\n" +
                    "3 Check total time spent in sports this week.\n" +
                    "0 Exit");
            int decision = Integer.parseInt(scanner.nextLine());

            switch (decision) {
                case 1 -> handleAddActivity();
                case 2 -> displayLoggedActivities();
                case 3 -> checkTotalTime();
                case 0 -> handleExit();
            }
        }
    }

    public static void handleAddActivity() {
        System.out.print("\nType name of your activity: ");
        String name = scanner.nextLine();
        System.out.print("\nType minutes you used in that activity: ");
        int time = Integer.parseInt(scanner.nextLine());
        addActivity(name, time);
    }

    public static void handleExit() {
        flag = false;
        System.out.println("Closing program, see you!");
    }


    public static void main(String[] args) {
        start();
    }
}
