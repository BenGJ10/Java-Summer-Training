interface Area{
    public float computeArea(float x, float y);
    public final static float PI = 3.14f;
}

class Rectangle implements Area{
    public float computeArea(float x, float y){
        return (x * y);
    }
}

class Circle implements Area{
    public float computeArea(float x, float y){
        return (PI * x * x);
    }
}
public class SampleInterface {
    public static void main(String args[]){
        Rectangle obj1 = new Rectangle();
        System.out.printf("The area of rectangle is %.2f\n", obj1.computeArea(4.5f, 5.6f));
        
        Circle obj2 = new Circle();
        System.out.printf("The area of circle is %.2f\n", obj2.computeArea(4.5f, 5.6f));
    }
}
