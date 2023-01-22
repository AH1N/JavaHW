package java_project.HWJ;

import java.util.Scanner;
import java.lang.Math;


public class HW1 {
    
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) 
    {

        int num = getNumberByUser("Введите N : ");
        int trn = ResearchTriangleNumber(num);
        System.out.println(trn);
        System.out.println("ПРОВЕРЯЕМ");
        System.out.println(CheckTriangleNumber(trn));// МОжно было не делать, по условию все данные валидны, тем более это не try/catch
        System.out.println(trn + " <--- Искомое число ");
    }

    // ВВОд ЧИСЛА n С КЛАВИАТУРЫ
    public static int getNumberByUser(String text)
    {
        System.out.print(text);
        return input.nextInt();
    }
    // ВЫЧИСЛЕНИЯ ТРЕУГОЛЬНОГО ЧИСЛА
    public static int ResearchTriangleNumber(int n)
    {
        int triangleNumber = (n * (n + 1))/2;
        return triangleNumber;
    }
    // ПРОВЕРКА НА ТРЕУГОЛЬНОСТЬ ЧИСЛА
    public static boolean CheckTriangleNumber(int triangleNumber) // МОжно было не делать, по условию все данные валидны, тем более это не try/catch
    {
        if((Math.sqrt(triangleNumber * 8 + 1) % 1) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }   
    }

}
