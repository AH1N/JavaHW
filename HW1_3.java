import java.util.ArrayList;

public class HW1_3 {
     /*

    3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    * и возвращающий новый массив, каждый элемент которого равен частному элементов
    * двух входящих массивов в той же ячейке.
    * Если длины массивов не равны, необходимо как-то оповестить пользователя.
    * Важно: При выполнении метода единственное исключение,
            * которое пользователь может увидеть - RuntimeException, т.е. ваше
    */

    public static void main(String[] args) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        fillArr(arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        fillArr(arr2);

        twoArrtoOneArr(arr1, arr2);
    }

    public static ArrayList<Integer> twoArrtoOneArr(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> arr3 = new ArrayList<Integer>(5);
        if(arr1.size() != arr2.size()){
            System.out.println("размеры массивов не совпадают, необходимы одинаковые массивы");
            return null;
        }
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i)+ "X" + arr2.get(i)+" = "+ arr1.get(i)*arr2.get(i));

            arr3.add(arr1.get(i) * arr2.get(i));
        }
        return arr3;
    }

    public static void fillArr(ArrayList<Integer> arr){
        for (int i = 1; i <= 5; i++) {
            arr.add(i);
        }
    }
}
