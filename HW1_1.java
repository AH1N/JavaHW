import java.util.ArrayList;

public class HW1_1 {
/*
*
    1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

*/
    public static void main(String[] args) {
//        outOfBound();
//        ArrayList<String> List = new ArrayList<String>(10);
//        arithmeticExcept(List);
        NullPoint();

    }
    public static void outOfBound(){
        System.out.println("outOfBound");
        ArrayList<Integer> List = new ArrayList<Integer>(10);
        for (int elem:List) {
            elem ++;
            System.out.println(elem);
        }
        for (int i = 0; i < 19; i++) {
            List.get(i);
            System.out.println(List.get(i));
        }
    }
    public static void arithmeticExcept(ArrayList<String> List){
        System.out.println("arithmeticExcept");
        int result = List.size();
        result = result / 0;
    }

    public static void NullPoint(){

        String str = null;
        int length = str.length();
    }

}


