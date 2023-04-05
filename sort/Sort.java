package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] arr = {5,3,6,8,1,7,9,4,3};
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        selectSort(arr);
        hillSort(arr2);
        System.out.print(Arrays.toString(arr));
        System.out.print(Arrays.toString(arr2));
    }

    /**
     * 选择排序 每次找最小的 交换到前面 时间复杂度O(n²)
     * @param arr
     */
    static void selectSort(int[] arr){
        for(int i=0; i<arr.length -1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }


     /**
     * 冒泡排序 一次次交换 最大的到最后 时间复杂度O(n²)
     * @param arr
     */
    static void bubbingSort(int[] arr){
        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr.length - i -1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

        /**
     * 插入排序 将无序的插入到有序中 时间复杂度O(n²)
     * @param arr
     */
    static void insertSort(int[] arr){
        //int[] arr = {2,5,1,8,7,9};
        for(int i=1; i<arr.length;i++){
            //在左边有序的集合里找
            for(int j=i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    /**
     * 希尔排序 改进的插入排序 间隔为3X+1
     * @param arr
     */
    static void hillSort(int[] arr){
        //int[] arr = {2,5,1,8,7,9};
        int h = 1;
        while(h<= arr.length/3){
            h = h*3+1;
        }
        for(int gap = h; gap > 0; gap = (gap-1)/3){
            for(int i=gap; i<arr.length;i++){
                //在左边有序的集合里找
                for(int j=i;j>gap-1;j=j-gap){
                    if(arr[j] < arr[j-gap]){
                        swap(arr, j, j-gap);
                    }
                }
            }

        }
    
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
