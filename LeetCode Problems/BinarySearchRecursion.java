import java.util.*;

class BinarySearchRecursion{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int num[] = new int[size];
        for(int i = 0; i < size; i++){
            num[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        
        System.out.println(target + " found at index: " + binarySearch(num, target));
        sc.close();
    }

    public static int binarySearch(int[] nums, int target){
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int left, int right, int target){
        if(left > right)    return -1;
        int mid = left + (right - left) / 2;
        if( nums[mid] == target)   return mid;
        else if(nums[mid] > target)   return search(nums, left, mid - 1, target);
        else return search(nums, mid + 1, right, target);
    }
}