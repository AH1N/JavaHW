import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HW2_2 {
    /*
        Если необходимо, исправьте данный код
     */

//    public static void main(String[] args) {
//        try {
//            int d = 1;// деление на 0???
//            double intArray = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }
//
//    }


    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int num1 = scan.nextInt();
            System.out.print("Введите второе число: ");
            int num2 = scan.nextInt();
            printSum(num1,num2);

            printSum(23, 234);
            int[] abc = { 1, 2 };
            int[] newAbc = Arrays.copyOf(abc, abc.length + 2);
            // abc[3] = 9; нет члена с индексом 3
            newAbc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");

        }
    }
    public static void printSum(Integer a, Integer b)// throws FileNotFoundException тут нет работы с файлами,
    // может если придёт строка как то вместо одного слогаемого, от вроде как их сконкатенирует...
    {
        Scanner scan = new Scanner(System.in);
        if(a instanceof Integer && b instanceof Integer){
            System.out.println(a + b);
        }else if(a instanceof Integer && !(b instanceof Integer)){
            System.out.println("введите b");
            b = scan.nextInt();
            System.out.println(a + b);
        } else if (b instanceof Integer && !(a instanceof Integer)) {
            System.out.println("введите a");
            a = scan.nextInt();
            System.out.println(a + b);
        }
    }

}
