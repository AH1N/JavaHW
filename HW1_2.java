public class HW1_2 {
    /*
     2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
            * public static int sum2d(String[][] arr){
    * int sum = 0;
    * for (int i = 0; i < arr.length; i++) {
    * for (int j = 0; j < 5; j++) {
    * int val = Integer.parseInt(arr[i][j]);
    * sum += val;
    * }
    * }
    * return sum;
    * }

    */
    public static void main(String[] args) {
//        sum2d();
    }
    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // тут может ArrayIndexOutOfBoundsException
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]); // тут может при преобразовании (например если не 10, а 1O - "тут буква О") NumberFormatException
                sum += val;
            }
        }
        return sum;
     }
}
