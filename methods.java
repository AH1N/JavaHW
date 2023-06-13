import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class methods {



    public static String inPut(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-->");
        return scan.nextLine();
    }

    public static long inPutLong(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Телефон-->");
        long phone;
        try {
            phone = scan.nextLong();
            return phone;
        }
        catch (InputMismatchException e){
            System.out.println("Ошибка ввода! Введите корректное целое число без форматирования.");
            inPutLong();
        }
        return 0;
    }

    public static String inPutPerson(String value, boolean flag){
        flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.println(value + "-->");
        if(!flag){
            scan.close();
        }
        return scan.nextLine();
    }

    public static Person createNote(){

          String name = inPutPerson("Имя: ",true);
          String fName = inPutPerson("Отчество: ",true);
          String lName = inPutPerson("Фамилия: ",true);
          String bDate = inPutPerson("Дата рождения в формате dd.mm.yyyy:  ",true);
          Long phNumber = inPutLong();
          String gender = inPutPerson("Пол 'm' (мужской) или 'f' (женский): ",false);


        return new Person(name,fName,lName,bDate, phNumber,gender);
    }

    private static void writeF(String fileName,String data) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.newLine();
        writer.write(data);
        writer.close();
        System.out.println("Данные успешно записаны в файл.");

    }

    public static void writeInFile(String fileName,String data)  {

        try {
            writeF(fileName, data);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            writeInFile(inPut(),data);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

    }
}

