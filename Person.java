import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


public class Person {
    private static final Set<String> GENDERS = Set.of("m", "f");
    public String name;
    public String fName;
    public String lName;
    public String bDate;
    public Long phNumber;
    public String gender;
    private final Integer consist = 6;
    private boolean consistFlag = false;
    private final Field[] filds;

    public Person(String name,String fName, String lName, String bDate, Long phNumber, String gender) {

        this.name = name;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
        this.phNumber = phNumber;
        this.gender = gender;
        this.filds = Person.class.getFields();

    }


    public void setName(String name) {
        this.name = name;
        chkName();
    }

    public void chkName(){
        System.out.println("проверяем имя");
        System.out.println("<"+ this.name+ ">"+ "---Это имя");
        if (this.name == null || this.name.isEmpty() || this.name.isBlank()){
            System.out.println("введите Имя ");
            setName(methods.inPut());
        }
    }

    public void setfName(String fName) {
        this.fName = fName;
        chkfName();
    }

    public void chkfName(){
        System.out.println("проверяем отчество");
        System.out.println("<"+this.fName+ ">"+ "---Это отчество");
        if (this.fName == null || this.fName.isEmpty() || this.fName.isBlank()){
            System.out.println("введите Отчество ");
            setfName(methods.inPut());
        }
    }

    public void setlName(String lName) {

        this.lName = lName;
        chklName();
    }

    public void chklName(){
        System.out.println("проверяем фамилию");
        System.out.println("<"+this.fName+ ">"+ "---Это Фамилия");
        if (this.lName == null || this.lName.isEmpty() || this.lName.isBlank()){
            System.out.println("введите Фамилию ");
            setlName(methods.inPut());
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
        chkGender();
    }

    public String getGender() {
        return gender;
    }

    public void chkGender(){

        System.out.println("проверяем геньдер");
        System.out.println("Это Геньдер --->"+ getGender());

        if (!GENDERS.contains(this.gender)) {
            System.out.println("введите Геньдер ");
            setGender(methods.inPut());
        } else {
            System.out.println("Геньдер впорядке");

        }

    }

    public void setDate(String bDate) {
        this.bDate = bDate;
        chkDate();

    }

    public void chkDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(this.bDate);
            System.out.println("Введенная дата является корректной: " + date);
        } catch (ParseException e) {
            System.out.println("Введите новую дату");
            setDate(methods.inPut());

        }
    }


    public void setPhNumber(Long phNumber) {
        this.phNumber = phNumber;
        chkPhNumber();
    }

    public void chkPhNumber(){
        System.out.println("проверяем Телефон");
        System.out.println("<"+this.phNumber+ ">"+ "---Это Телефон");
        if (this.phNumber == 0 ||
                this.phNumber == null ||
                this.phNumber.toString().isEmpty() ||
                this.phNumber.toString().isBlank())
        {
            System.out.println("введите Телефон ");
            setPhNumber(methods.inPutLong());
        }else {
            System.out.println("телефон на месте");
        }
    }


    public String PrintPerson() {

        return "<" + this.name + ">" +"\t"+
                "<" + this.fName + ">" +"\t"+
                "<" + this.lName + ">" +"\t"+
                "<" + this.bDate + ">" +"\t"+
                "<" + this.phNumber + ">" +"\t"+
                "<" + this.gender + ">";
    }

    public String getName() {
        return this.name;
    }

    public void isConsist() {

        ArrayList<String> List = new ArrayList<>();

        chkName();
        List.add(this.name);

        chkName();
        List.add(this.fName);

        chklName();
        List.add(this.lName);

        chkDate();
        List.add(this.bDate);

        chkPhNumber();
        List.add(this.phNumber.toString());

        chkGender();
        List.add(this.gender);



        if (List.size() == this.consist) {
            this.consistFlag = true;
            System.out.println("Данных для регистрации  достаточно");
        } else {
            System.out.println("Данных для регистрации не достаточно");
        }

    }

}




