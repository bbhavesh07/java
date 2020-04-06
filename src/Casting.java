public class Casting {
    public static void main(String args[]){
        A1 a = new A2();
        ((A2) a).m(); //because java is statically typed. without casting it will not work.
        //please note here a is just a reference but it actually points to A2 so possible to cast and call m().
        //Casting c = (Casting) new A1(); //CTE: not allowed
        A1 a1 = new A1();
        //A2 a2 = (A2) a1; //RTE: ClassCastException: A1 cannot be cast to A2.
        //a2.m();
    }
}

class A1{

}

class A2 extends A1{
    public void m(){
        System.out.println("A2 m");
    }
}
