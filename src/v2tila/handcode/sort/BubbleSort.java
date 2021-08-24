package v2tila.handcode.sort;

/**
 * @author v2tila on 22:03 2021/8/23
 */

public class BubbleSort extends Sort{

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1,-1,0,19,21,15,-6};
        new BubbleSort().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }

    }

    public int[] sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1])
                    swap(arr, j, j + 1);
            }
        }
        return arr;
    }


}
