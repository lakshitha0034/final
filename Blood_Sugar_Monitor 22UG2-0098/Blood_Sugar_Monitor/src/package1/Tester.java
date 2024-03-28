package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

    private static int id;
    private static String name;
    private static String yob;
    private static int sugar_level;

    private static ArrayList<BloodSugar> users = new ArrayList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome To Blood Sugar Monitor ");

        int input;

        while (true) {
            displayMenu();
            input = scanner.nextInt();

            switch (input) {
                case 0:
                    exit();
                    break;
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.println("Please Enter User Id");
                    input = scanner.nextInt();
                    view(input);
                    break;
                case 4:
                    delete();
                    break;

            }
        }

    }

    public static void displayMenu() {
        System.out.println("Menu...");
        System.out.println("1 - Create a Record");
        System.out.println("2 - Show All Users");
        System.out.println("3 - View User");
        System.out.println("4 - Delete All Records");
        System.out.println("0 - Exit");
    }

    public static void index() {//show all records
        System.out.println("All Users");
        users.forEach(user -> user.display());
    }

    public static void view(int id) { // show onw record
        users.forEach(user -> {
            if (user.getId() == id) {
                user.display();
            }
        });
    }

    public static void create() {//create user
        System.out.println("Enter User Details");

        boolean isIdOk = false;
        boolean isNameOk = false;
        boolean isYobOk = false;
        boolean isSugarLevelOk = false;

        for (int i = 0; i < 3; i++) {

            if (!isIdOk) {
                System.out.println("Enter User Id");
                id = scanner.nextInt();
                scanner.nextLine();
            }
            if (!isNameOk) {
                System.out.println("Enter User Name");
                name = scanner.nextLine();
                isNameOk = true;
            }
            if (!isYobOk) {
                System.out.println("Enter Year Of Birth");
                yob = scanner.nextLine();
            }
            if (!isSugarLevelOk) {
                System.out.println("Enter Blood Sugar Level");
                sugar_level = scanner.nextInt();
                isSugarLevelOk = true;
            }

            if (id < 0 || id > 6) {
                System.out.println("Id must be greater than 0 and less than 6");
                i = 1;
            } else {
                isIdOk = true;
                i = 3;
            }

            if (Integer.parseInt(yob) >= 2025) {
                System.out.println("Year of birth must be less than 2025");
                i = 1;
            } else {
                isYobOk = true;
                if (i != 1) {//error on previous validation
                    i = 3;
                }
            }

        }

        BloodSugar user = new BloodSugar(id, name, yob, sugar_level);
        users.add(user);
    }

    public static void delete() {//delete user
        System.out.println("All Users Deleted");
        users.clear();
    }

    public static void exit() {
        System.out.println("Exit on Application");
        System.exit(0);
    }

}
