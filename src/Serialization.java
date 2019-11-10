import java.io.*;

public class Serialization implements Serializable {
    int a;
    Serialization(int a){
        this.a = a;
    }
    @Override
    public String toString(){
        return "" + this.a;
    }

}
class Main{
    public static void main(String a[]) throws Exception{
        Serialization s = new Serialization(10);
        FileOutputStream fs = new FileOutputStream("Serialization.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fs);

        oos.writeObject(s);

        FileInputStream fis = new FileInputStream("Serialization.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s = (Serialization)ois.readObject();

        System.out.println(s);


    }
}
