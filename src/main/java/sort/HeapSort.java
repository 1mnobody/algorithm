package sort;

/**
 * Created by wuzhsh on 9/4/2019.
 */
public class HeapSort {


    // left child: 2*i + 1; right child: 2*i + 2
    public void shiftDown(int[] array) {
        int lastParentIndex = (array.length - 1) / 2;
        for (int i = lastParentIndex; i >= 0; i--) {
            int tmp = array[i];
            for (int j = 2 * i + 1; j < array.length; j = 2 * j + 1) {
                if (j + 1 < array.length && array[i] < array[j + 1]) {
                    j++;
                }
                if (array[j] > tmp) {
                    array[i] = array[j];
                    i = j;
                }
            }
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        HeapSort hs = new HeapSort();
        hs.shiftDown(a);
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
