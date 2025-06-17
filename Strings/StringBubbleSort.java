public class StringBubbleSort {
    public static void main(String args[]){
        String arr[] = {"mumbai", "jalandhar", "delhi", "kolkata"};
        
        System.out.print("Array before sorting: ");
        for (String city : arr) {
            System.out.print(city + " ");
        }

        System.out.println();

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }   
        System.out.print("Array after sorting: ");
        for (String city : arr) {
            System.out.print(city + " ");
        }
    }
}
