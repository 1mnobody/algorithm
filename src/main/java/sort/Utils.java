package sort;

import java.util.Random;

/**
 * Created by wuzhsh on 2019/3/19.
 */
public class Utils {

    public static int[] randomArray(int length) {
        Random r = new Random();
        int[] arr = new int[length];
        for(int i=0; i< length; i++) {
            arr[i] = r.nextInt(65535);
        }
        System.out.print("src array[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        return arr;
    }
}
