package v2tila.handcode.execise;

import java.math.BigDecimal;
import java.util.*;

/**
 * []
 * @author v2tila on 10:33 2021/8/20
 */

public class FindMaxSubOrder {

    public static void main(String[] args) {

        //int[] arr = new int[]{-5,1,-1,2,3};
        int randomLength = 10000;

        int[] arrRandom = new int[randomLength];
        Random random = new Random();
        for (int i = 0; i < randomLength; i++) {
            arrRandom[i] = random.nextInt(randomLength)-(randomLength/2);
        }

        double upTime;

        long startTime = System.currentTimeMillis();

        List<Integer> order = new FindMaxSubOrder().MaxSubOrder(arrRandom);


        long endTime = System.currentTimeMillis();

        upTime = new BigDecimal(endTime - startTime)
                .divide(new BigDecimal(1000))
                .doubleValue();

        System.out.println("L:"+upTime);

        Collections.sort(order);

        System.out.println(order.stream().findFirst());
    }


    private Map<Integer, Integer> mapM = new HashMap<>();
    private Map<Integer, Integer> mapN = new HashMap<>();



    //连续子序列最大和
    private int M(int[] arr,int index){

        if (mapM.containsKey(index)) {
            return mapM.get(index);
        }

        if (index == arr.length - 1) {
            return arr[index];
        }

        int maxValue = arr[index];


        int tempValue =  M(arr, index+1) + arr[index];
        maxValue = Math.max(arr[index], tempValue);
        mapM.put(index, maxValue);


        return maxValue;
    }
    //非连续最大子序列值
    private int N(int[] arr, int index) {

        if (index == arr.length - 1) {
            return arr[index];
        }

        int tempValue =  N(arr, index+1);

        int maxValue = Math.max(tempValue + arr[index], tempValue);

        return maxValue;

    }

    private List<Integer> MaxSubOrder(int[]arr){
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            order.add(M(arr, i));
        }
        return order;
    }

    private int MaxSubOrderN(int[]arr){

        int order = N(arr,0);

        return order;
    }

}
