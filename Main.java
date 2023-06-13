import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        System.out.println("ВВЕДИТЕ ДАННЫЕ:  ");

        Person person = methods.createNote();

        System.out.println(person.PrintPerson());

        person.isConsist();

        methods.writeInFile("file.txt",person.PrintPerson());



    }

}