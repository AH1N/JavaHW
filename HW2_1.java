import java.util.Scanner;

public class HW2_1 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения,
    вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */

    public static void main(String[] args) {
        float number = InOutFloat();
        System.out.println("Введенное число: " + number);
    }


// ТУТ ВОПРОС !!!!!
    public static Float InOutFloat() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        if (!scan.hasNextFloat()) {
            System.out.println("Введенное число не является типом float.");
            return InOutFloat();
        } else {
            System.out.println("теперь исполняется ELSE");
            float num = scan.nextFloat();
            return num;
        }
    }
}
