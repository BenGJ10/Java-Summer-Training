public class ShortCircuit {
    public static void main(String args[]){
        int a = 45;
        int b = 60;

        if(++a > 50 && ++b > 70)
        // As the first condition is wrong, it won't go to the second operation.
            System.out.println("if is working: " + a + " " + b);
        else
            System.out.println("else is working: " + a + " " + b);

        // if (++a > 50 | ++b > 50) -> no short circuit, | is overloaded.
    }
}
