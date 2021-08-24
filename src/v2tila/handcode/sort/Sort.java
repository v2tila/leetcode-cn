package v2tila.handcode.sort;

/**
 * @author v2tila on 22:05 2021/8/23
 */

public abstract class Sort {

    abstract int[] sort(int[] arr);

    public int[] swap(int[]arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        return arr;
    }

}
