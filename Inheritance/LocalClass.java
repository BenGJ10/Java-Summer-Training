class Local{
    void showLocalInnerClass(){

        class LocalInner{
            void display(){
                System.out.println("This is a local inner class!");
            }
        }
        // You need to instantiate the Local Class inside the method has been declared
        LocalInner localinner = new LocalInner();
        localinner.display();
    }
}

public class LocalClass {
    public static void main(String args[]){
        Local obj = new Local();
        obj.showLocalInnerClass();
    }
}
