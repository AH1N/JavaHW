package java_project.HWJ;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Spring;
import java.lang.Math;


// C:\\GEEKBRAINS\\JV\\PR1\\123.txt
// C:\\GEEKBRAINS\\JV\\java_project\\HWJ\\input.txt


public class HW2 {
    public static void main(String[] args) throws IOException 
    {
        List<String> list = GetDataFromFile("C:\\GEEKBRAINS\\JV\\java_project\\HWJ\\input.txt");
        PushDataToFile("C:\\GEEKBRAINS\\JV\\java_project\\HWJ\\output.txt",POW(lookForA_B(list)));
    }
    // print("Что угодно можно сюда писать") для проверок
    public static void print(Object string) 
    {
        System.out.println(string);
    }
    // Упрощённый TypeOf для проверок
    public static String typeof(Object args)
    {
        return args.getClass().getName();
    }
    // Делает из файла список строк     
    public static List<String> GetDataFromFile(String file_name) throws IOException
    {
        Path path = Path.of(file_name);
        List<String> list = Files.readAllLines(path);
        return list;
    }
    // Запись в файл
    public static void PushDataToFile(String file_name, String data)
    {
        try(FileWriter writer = new FileWriter(file_name, false))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        } 
    }
    // Ищем цифры в строках списка
    public static Integer lookForDigit(String string)
    {
        int elem = 0;
        String tmp = "";
        if(string.indexOf("-") > 0)
        {   
            tmp = string.substring((string.indexOf("-")+1),string.length());
            elem = Integer.parseInt(tmp)*(-1);
        }
        else 
        {
            StringBuilder tmp1 = new StringBuilder(20);
            for (int i = 0; i < string.length(); i++) 
            { 
                if(Character.isDigit(string.charAt(i)))
                {   
                    tmp1.append(string.charAt(i));
                }
            }
            String tmp2 = tmp1.toString(); 
            elem = Integer.parseInt(tmp2);
        }
        return (Integer) elem;
    }
    //Ищем А и Б
    public static int[] lookForA_B(List<String> list)
    {   
        int[] a_b = new int[2];
        for (int i = 0; i < list.size(); i++) 
        {
            String p = list.get(i);
            if(p.charAt(0) == 'a')
            {
                a_b[0] = lookForDigit(p); 
                print(a_b[0] + " <<< это A");  
            }
            if(p.charAt(0) == 'b')
            {
                a_b[1] = lookForDigit(p); 
                print(a_b[1] + " <<< это B");  
            }
        }
        print("в файле можно менять А и Б местами, так же можно ипользовать не '=', а любой символ кроме '-', это *(-1)");
        return a_b; 
    }
    //Возведение в степень
    public static String POW(int[] a_b) 
    {
        String res = "1";
        int a = a_b[0];
        int b = a_b[1];
        Double tmp = (double) 1;
        if((a == 0) & (b == 0))
        {
            res = "неопределенность >>>> 0 в степени 0";
        }
        else
        {
            tmp = Math.pow(a, b);
            res = String.valueOf(tmp);
        }
        print(res);
        return res;
    }                
}
