package class02;

/**
 * @Auther: Yangkf
 * @Description: class02
 */
public class Code03_Comp {
    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 有问题的选择排序
     *
     * @param arr
     */
    public static void falseSelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) { //0~i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 交换数组中的值
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    /**
     * 长度和值随机的数组
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    //arr1 和arr2一定等长  比较两个数组是否等长
    public static boolean equalValues(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        int maxLen = 5; //数组的最大长度
        int maxValue = 1000;
        int testTime = 10000;
        /**
         * 证明选择排序是正确的
         */
    /*    for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen,maxValue);//arr1是一个长度随机，值也随机的数组
            int[] arr2 = copyArray(arr1);//克隆出来一个和arr1一样的数组arr2，但空间地址不同
            selectionSort(arr1);//使用选择排序排arr1
            insertionSort(arr2);//使用插入排序排arr2
            if(!isSorted(arr1)){
                System.out.println("选择排序错了！");
            }
        }*/

        /**
         * 如果选择排序错了，快速找到错误点
         */
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);//arr1是一个长度随机，值也随机的数组
            int[] tmp = copyArray(arr1);//备份arr1
            falseSelectionSort(arr1);//使用选择排序排arr1,但是这是一个错误的选择排序方法
            /**
             * 如果arr1不是有序的，打印这个数组
             */
            if (!isSorted(arr1)) {
                for (int j = 0; j < tmp.length; j++) {
                    System.out.print(tmp[j] + " ");
                }
                System.out.println();
                System.out.println("选择排序错了！");
                break;
            }
        }
    }
}
