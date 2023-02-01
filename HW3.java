package java_project.HWJ;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args)
    {  
      
        int m = getNumberByUser("Введите M : ");
        int n = getNumberByUser("Введите N : ");
        int[][] pole = new int[m+1][n+1];
        System.out.println(Ways(CorrectPole(pole)));
        
    }    

    // ВВЕДЕНИЕ С КЛАВИАТУРЫ
    private static Scanner input = new Scanner(System.in);
    
    public static int getNumberByUser(String text)
        {
            System.out.print(text);
            return input.nextInt();
        }
    // ищем пути
    public static String Ways(int[][] pole) 
    {   
        Integer res = 0;
        String a = "";
        for (int i = 1; i < pole.length; i++) 
        {
            for (int j = 1; j < pole.length; j++) 
            {  
                pole[i][j] = pole[i-1][j] + pole[i][j-1];
                res = pole[i][j];
            }
        }
        res = res/2;
        a = String.valueOf(res);
        return a;
    } 
    // корректируем поле
    public static int[][] CorrectPole(int[][] pole) 
    {
        pole[0][0] = 1;
        pole[1][0] = 1;
        pole[0][1] = 1;
        pole[1][1] = 2;
        
        return pole;
    }
}
