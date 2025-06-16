
public class VarArgs {
    
    public static int greatest(int... a){
        int i = 0, greater = Integer.MIN_VALUE;
        while(i < a.length){
            if(greater <= a[i]){
                greater = a[i];
            }
            i++;
        }
        return greater;
    }

    public static void main(String args[]){

        int[] inputNumbers = new int[args.length];

        for(int i = 0; i < args.length; i++) {
            inputNumbers[i] = Integer.parseInt(args[i]);
        }

        int result = greatest(inputNumbers);
        System.out.println("Greatest: " + result);
    }
}

