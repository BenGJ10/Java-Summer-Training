public class StringPool {
    public static void main(String args[]){
        String s1 = "Hello";
        String s2 = "Hello";

        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s1 == s2); // Java uses a string pool, s1 and s2 point to the same memory
        System.out.println(s3 == s1); // s3 is new object in the heap, s1 refers to the pooled literal
        System.out.println(s3 == s4); // two separate heap objects, even though the contents are the same

        System.out.println(s1.equals(s2)); // compares content, not memory
        System.out.println(s1.equals(s3)); // compares content, not memory
        System.out.println(s4.equals(s3)); // compares content, not memory
    }
}
