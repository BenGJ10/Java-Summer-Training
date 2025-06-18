// Signature of a function: number of arguments, data type of arguments and order of arguments
// Function Overloading: Same name but different signature
// Function Overriding: Same name, same signature, it happens in inheritance and in the other class

class A{
    int a;
    A(){
        a = 10;
        System.out.println("Constructor A is working");
    }   
    A(int a){
        this.a = a;
    }
    void show(){
        System.out.println("a is: " + a);
    }
    float sum(int a,float b){
        return a+b;
    }
    float sum(float a,int b){
        return a+b;
    }
}

class B extends A{
    int b;
    B(){
        b = 20;
        System.out.println("Constructor B is working");
    }
    B(int b){
        this.b = b;
    }
    void show(){
        System.out.println("b is: " + b);
    }
}

class SampleInheritance{
    public static void main(String args[]){
        A obj = new B(); // List list = new ArrayLis() -> we can take 
        System.out.println(obj.sum(2.3f, 5));
        obj.show();
    }
}