enum Mobile{
    SAMSUNG, IPHONE, REDMI, GOOGLE, ONEPLUS
}
public class Enum {

    public static void main(String args[]){
        System.out.println(Mobile.valueOf("GOOGLE"));
        System.out.println(Mobile.IPHONE.ordinal());
    }
}

enum Checker {

    EMPTY ("Empty"),
    RED ("Red"),
    YELLOW ("Yellow");

    private final String value;

    private Checker(final String value) {
        this.value = value;
    }

    public String getValue() { return value; }
}
