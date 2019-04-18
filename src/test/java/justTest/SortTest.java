package justTest;

import java.util.Random;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/4/18 13:43
 * @Description version 1.0
 */
public class SortTest {

    int[] numbers;
    {
        int size = 20;
        numbers = new int[size];
        for (int i = 0;i<size;i++){
            int r = new Random().nextInt(100);
            numbers[i] = r;
        }
    }


    /**
     * bubble sort
     * @param numbers
     */
    public static void bubbleSort(int[] numbers){
        for (int i = 0; i<numbers.length;i++){
            for (int j = i+1; j<numbers.length; j++){
                if (numbers[i] > numbers[j]){
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }

    /**
     * quick sort
     * @param numbers
     * @param start
     * @param end
     */
    public static void quickSort(int[] numbers,int start,int end){
        if (start < end){
            int base = numbers[start];  // 基准值
            int temp ;
            int i = start,j = end;
            do {
                while (numbers[i] < base && i < end)
                    i ++;
                while (numbers[j] > base && j > start)
                    j --;
                if (i <= j){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i ++;
                    j --;
                }
                System.out.println("\ni:"+i + "  j:"+j);
            } while (i <= j);
            if (i < end)
                quickSort(numbers,i,end);
            if (j > start)
                quickSort(numbers,start,j);
        }
    }



    /**
     * select sort
     * @param numbers
     */
    public static void selectSort(int[] numbers){
        int temp ;
        for (int i = 0; i < numbers.length; i++){
            int k = i;
            for (int j = k+1; j < numbers.length ; j++){
                if (numbers[j] < numbers[k]){
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }



    /**
     * insertSort
     * @param numbers
     */
    public static void insertSort(int[] numbers){
        int size = numbers.length, temp, j;
        for (int i = 1; i<size; i++){
            temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
            numbers[j] = temp;
        }
    }




}
