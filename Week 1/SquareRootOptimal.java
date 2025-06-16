import java.util.Scanner;

public class SquareRootOptimal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        SquareRootOptimal sqr = new SquareRootOptimal();
        System.out.println("Square root of " + num + " is " + sqr.sqrt(num));
        sc.close();
    }

        public int sqrt(int num){
        if(num == 0 || num == 1)    return num;

        int left = 0, right = num, ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid <= num / mid){   // Instead of mid * mid <= num
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

// Time Complexity of this code will be O(log n)
// When we are using Binary search on indices related problems, initialize right = num - 1, else right = num for searching in numeric range.