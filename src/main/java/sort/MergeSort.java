package sort;

/**
 * Created by wuzhsh on 2019/3/19.
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = Utils.randomArray(10);
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void merge(int[] array, int left, int leftEnd, int right) {
        int tmp[] = new int[right - left + 1];
        int i = left;
        int j = leftEnd + 1;
        int index = 0;
        while (i <= leftEnd && j <= right) {
            if (array[i] <= array[j]) {
                tmp[index++] = array[i++];
            } else {
                tmp[index++] = array[j++];
            }
        }
        if (i > leftEnd) {
            while (j <= right) {
                tmp[index++] = array[j++];
            }
        }
        if (j > right) {
            while (i <= leftEnd) {
                tmp[index++] = array[i++];
            }
        }
        System.arraycopy(tmp, 0, array, left, tmp.length);
    }

    // 归并排序，思想为先将左边部分的数据排序，再排序右边部分，最后将两个有序的数组合并成一个有序的数组
    public static void mergeSort(int[] arr, int start, int end) {
        // 没有元素或者只有一个元素，直接返回即可
        if (arr == null || start >= end) return;
        int mid = (end + start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}
