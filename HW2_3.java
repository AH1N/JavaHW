import java.util.Scanner;

public class HW2_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean normInput = false;

        while (!normInput) {
            System.out.print("Введите строку: ");
            input = scanner.nextLine();

            try {
                if (input.isEmpty()) {
                    throw new Exception("Пустая строка");
                }
                normInput = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введенная строка: " + input);
    }
}
