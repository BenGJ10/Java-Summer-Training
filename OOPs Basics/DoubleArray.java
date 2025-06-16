class DoubleArray{
    public static void main(String args[]){
        int arr[] = {2, 3, 4, 5, 6};

        for(int x : doubleTheArray(arr)){
            System.out.print(x + " ");
        }
        System.out.println();

        // Another way to call the same function:
        System.out.println(java.util.Arrays.toString(doubleTheArray(arr)));
    }

    static int[] doubleTheArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * 2;
        }
        return arr;
    }
}