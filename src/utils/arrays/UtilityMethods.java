package utils.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UtilityMethods
{

    public static void main(String[] args)
    {
        int[][] input = {{11,12,13,14},{21,22,23,24},{31,32,33,34}};
        UtilityMethods.arrayTranspose(input);
        UtilityMethods.convertIntArrToListInteger();
    }
    
    public static void arrayTranspose(int[][] arr) {
        if (arr == null || arr.length ==0) {
            return;
        }
        int rows = arr.length;
        int cols = arr.length > 0 ? arr[0].length:0;
        int[][] tarr = new int[cols][rows];
        
        for(int r = 0; r< rows; r++) {
            for(int c = 0;c<cols; c++) {
                tarr[c][r] = arr[r][c];
            }
        }
        
        for(int r = 0; r< cols; r++) {
            for(int c = 0;c<rows; c++) {
                System.out.print(tarr[r][c] + ",");
            }
            System.out.println("");
        }
        
    }
    
    public static void convertIntArrToListInteger() {

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Input Array:"+arr);

        List<Integer> list = Arrays.stream(arr)
                                    .boxed()
                                    .collect(Collectors.toList());

        System.out.println(list);
    }

}
