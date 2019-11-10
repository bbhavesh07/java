abstract class Shape{
    int x, y;
    Shape(){

    }
    void move(int x, int y){
        this.x = x;
        this.y  = y;
    }
    abstract double area();
}

class Circle extends Shape{
    int rad;
    protected Circle(int r){
        rad = r;
    }

    @Override
    public double area(){
        return Math.PI * rad * rad;
    }

}

interface Player{
    void sport();
}


public class InterfaceInnerClass implements Player{

    @Override
    public void sport() {
        class A{
            void print(){
                System.out.print("Playing ");
            }
        }
        new A().print();

        System.out.println("Table Tennis");
    }

    public static void main(String ar[]){
        Circle c = new Circle(5);
        System.out.println(c.area());
        new InterfaceInnerClass().sport();
        new Player(){
            public void sport(){
                System.out.println("Cricket");
            }
        }.sport();
    }
}
