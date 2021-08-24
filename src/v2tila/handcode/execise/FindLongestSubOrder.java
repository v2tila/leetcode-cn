package v2tila.handcode.execise;

import org.omg.CORBA.INTERNAL;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author v2tila on 21:21 2021/8/19
 */

public class FindLongestSubOrder {

    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] arg) {

        int randomLength = 110;

        int[] arrRandom = new int[randomLength];
        Random random = new Random(randomLength);
        for (int i = 0; i < randomLength; i++) {
            arrRandom[i] = random.nextInt(randomLength)+100;
            //System.out.print(arrRandom[i]+",");
        }

        double upTime;

        long startTime = System.currentTimeMillis();

        List<Integer> SubOrderLenthList = new FindLongestSubOrder().maxToL(arrRandom);

        long endTime = System.currentTimeMillis();

        upTime = new BigDecimal(endTime - startTime)
                .divide(new BigDecimal(1000))
                .doubleValue();

        System.out.println("L:"+upTime);


        startTime = System.currentTimeMillis();

        new FindLongestSubOrder().maxToLWithMap(arrRandom);

        endTime = System.currentTimeMillis();

        upTime = new BigDecimal(endTime - startTime)
                .divide(new BigDecimal(1000))
                .doubleValue();


        System.out.println("LWithMap:"+upTime);

        //System.out.println(SubOrderLenthList);

    }

    private int LWithMap(int[] arr, int index,List<Integer> path) {

        //path 是为了输出路径用
        if(map.containsKey(index)){

            //System.out.println("key:"+ index +" val:" +map.get(index));
            return map.get(index);
        }


        if(index == arr.length-1){
            path.add(-1);
            return 1;

        }

        int maxlenth = 1;

        for (int i = index + 1; i < arr.length; i++) {
            if(arr[index]<arr[i]){

                path.add(arr[i]);
                //System.out.println("IN :: index:"+index+" i:"+i);
                int currentInt = L(arr,i,path)+1;
                maxlenth = Math.max(maxlenth,currentInt);

//                System.out.println("---");
//                System.out.println("MAP:"+index+" : "+maxlenth);
//                System.out.println("OT :: index:"+index+" i:"+i+" CURNT:"+currentInt);
//                System.out.println("---");

            }
        }
        if(map.containsKey(index))
            map.replace(index, maxlenth);
        else
            map.put(index, maxlenth);
        return maxlenth;
    }

    private int L(int[] arr, int index,List<Integer> path) {

        //path 是为了输出路径用

        if(index == arr.length-1){
            path.add(-1);
            return 1;

        }

        int maxlenth = 1;

        for (int i = index + 1; i < arr.length; i++) {
            if(arr[index]<arr[i]){

                path.add(arr[i]);
                //System.out.println("IN :: index:"+index+" i:"+i);
                int currentInt = L(arr,i,path)+1;
                maxlenth = Math.max(maxlenth,currentInt);

            }
        }

        return maxlenth;
    }

    private List<Integer> maxToL(int[] arr){

        List<Integer> LList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(arr[i]);
            LList.add(L(arr, i ,path));
            //printPath(path);
        }
        return LList;
    }

    private List<Integer> maxToLWithMap(int[] arr){

        List<Integer> LList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(arr[i]);
            LWithMap(arr, i ,path);
            //LList.add(LWithMap(arr, i ,path));
            //printPath(path);
        }
        return LList;
    }

    private void printPath(List<Integer> pathList){
        StringBuffer pathStr = new StringBuffer();
        for (Integer value:pathList
        ) {
            if(value == -1)
                pathStr.append(";");
            else{
                pathStr.append("→");
                pathStr.append(value);
            }
        }
        System.out.println(pathStr);
    }
}
