import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
public class MaxArray {
    static int[] memo = new int[5];

    public static void main(String[] args) {
        int[] list = {2, 1, 5, 8, 4};

        for (int i = 0; i < list.length; i++) {
            memo[i] = Integer.MIN_VALUE;
        }
        for (int n : list) {

            System.out.print("\t" + n);
        }
        System.out.println("\n");
        maxSubsetSum(list);

    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int max_sum = 0;

        ksum(0, arr);

        return max_sum;

    }

    static void ksum(int currentIndex, int[] arr) {
        System.out.println(currentIndex + "\t" + arr[currentIndex]);
        if (currentIndex > arr.length - 2)
            return;

        ksumOneAfter(currentIndex, arr, arr[currentIndex]);
        ksum(currentIndex + 1, arr);

    }

    private static int ksumOneAfter(int currentIndex, int[] arr, int sum) {
        System.out.println("\t" + currentIndex + "\t" + arr[currentIndex] + "\tsum :: " + sum);
       // displayMemo();
        if (currentIndex > arr.length - 2) {
            memo[currentIndex] = sum;
            return sum;
        }
        if (currentIndex + 2 < arr.length) {
            sum = sum  + arr[currentIndex + 2];
            int val = ksumOneAfter(currentIndex + 2, arr, sum);
            System.out.println("For "+currentIndex+" "+arr[currentIndex]+" :: "+val);
            return val;
        }
        return Integer.MIN_VALUE;
    }

    private static void displayMemo() {
        for( int e: memo){
            System.out.print(e+", ");
        }
        System.out.println("\n");
    }
}
