
public class pyramid {
    
    public static void main(String[] args) {

        int[] arr = new int[10000];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] =i;
        }
        
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        System.out.println(end - start);

    }

    public static void pyramidSort(int[] arr, int heapSize, int rootInd){
        int largest = rootInd;
        int leftElem = 2 * rootInd + 1;
        int rightElem = 2 * rootInd + 2;

        if(leftElem < heapSize && arr[leftElem] > arr[largest]){
            largest = leftElem;
        }

        if(rightElem < heapSize && arr[rightElem] > arr[largest]){
            largest = rightElem;
        }

        if(largest != rootInd){
            int tmp = arr[rootInd];
            arr[rootInd] = arr[largest];
            arr[largest] = tmp;
            
            pyramidSort(arr,heapSize,largest);
        }

        
    }

    public static void sort(int[] arr){
        int n = arr.length;

        for (int i = n/2 -1; i >= 0; i--) {
            pyramidSort(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            pyramidSort(arr, i, 0);
        }
    }
}