package sort;

/**
 * Created by wuzhsh on 2019/3/19.
 */
public class QuickSort {

    // 以下标为left的元素作为基准，partition之后，该元素处在array中正确的有序位置，在其左边的元素都比它小，右边的都比它大
    public static int partition(int[] array, int left, int right) {
        if (left >= right) return left;
        int key = array[left];
        int index = left + 1;
        int tmp;
        // [left+1, index) 之间的元素小于等于key
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= key) {
                if ( i != index ) {
                    tmp = array[index];
                    array[index] = array[i];
                    array[i] = tmp;
                }
                index++;
            }
        }
        tmp = array[index-1];
        array[index-1] = array[left];
        array[left] = tmp;
        return index-1;
    }

    // 快排的核心思想是把找一个分界点，分界点左边的元素全都小于其右边的元素
    public static void sort(int[] arr, int left, int right) {
        // 两个及以上的元素才有排序的必要
        if(right > left) {
            int partition = partition(arr, left, right);
            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = Utils.randomArray(50);
        long start = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("spend times: >> " + (end - start));
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
