enum Mobile{
    SAMSUNG, IPHONE, REDMI, GOOGLE, ONEPLUS
}
public class Enum {

    public static void main(String args[]){
        System.out.println(Mobile.valueOf("GOOGLE"));
        Mobile.IPHONE.ordinal();
    }
}


