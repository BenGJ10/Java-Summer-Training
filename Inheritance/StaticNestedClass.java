class OuterClass{
    static class InnerClass{
        void display(){
            System.out.println("This is the static inner class!");
        }
    }

    class NonStaticClass{
        void display(){
            System.out.println("This is the non static inner class!");
        }
    }
}

public class StaticNestedClass {
    public static void main(String args[]){
        OuterClass.InnerClass obj1 = new OuterClass.InnerClass();
        obj1.display();

        OuterClass obj = new OuterClass();
        OuterClass.NonStaticClass obj2 = obj.new NonStaticClass();
        obj2.display();
    }
}
