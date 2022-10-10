package class01;

/**
 * @Auther: Yangkf
 * @Description: class01
 */
public class Code7_SelectionSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { //边界条件
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) { //i往后所有的位置都看一遍
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }
    //冒泡是两两交换，选择是第一个数的位置和后面所有的数做大小比较
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            //0 ~ end 做一件事
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 0; end < N; end++){
            int newNumberIndex = end;
            while(newNumberIndex - 1 >= 0 && arr[newNumberIndex-1] > arr[newNumberIndex]){
                swap(arr,newNumberIndex-1,newNumberIndex);
                newNumberIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int end = 1;end < N; end++){
            for (int pre = end -1; pre >= 0 && arr[pre] > arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        int[] arr = {8, 1, 7, 3, 2, 6, 4, 6, 8, 3, 9, 2};
        printArray(arr);
        insertSort2(arr);
        printArray(arr);
    }
}
