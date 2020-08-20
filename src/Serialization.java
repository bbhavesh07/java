import java.io.*;

//transient keyword is used to skip serialization, statics are never part of serialization
//transients are initialized to default in deserialization. while static are taken from current state of class.
class InhTest{
    int x = 11;
}
public class Serialization extends InhTest implements Serializable {
    private static final long serialVersionUID = 1L; //This is the class identifier to verify same version of class
    //for both serialization and deserialization. Optional to declare. Can throw InvalidClassException if version at source
    // and destination doesn't match. Also can fail when new field added to this class(at every change in class modify the uid).
    private int a;
    Serialization(int a){
        this.a = a;
    }
    @Override
    public String toString(){
        return "" + this.a + " super.x " + super.x;
    }

    //If you want to control serialization/deserialization override the logic of read/writeObject and control it.
    // Please note this is not overriding of methods

    private void readObject(ObjectInputStream in) throws Exception{
        this.a = in.readInt(); //I can leave this method blank to skip deserialization or I can skip some of the fields
        // or I can Also modify the fields after deserialization.
    }

    private void writeObject(ObjectOutputStream out) throws Exception{  //please note the signature of method(private)
        out.writeInt(this.a);
        out.writeInt(15); //not used in read. Ignored
        //The read and write should be in sync otherwise you will miss something. Though there is no checked exception.
    }

}
class Main{
    public static void main(String a[]) throws Exception{
        Serialization s = new Serialization(10);
        FileOutputStream fs = new FileOutputStream("Serialization.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fs);
        s.x = 100;
        oos.writeObject(s);

        FileInputStream fis = new FileInputStream("Serialization.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s = (Serialization)ois.readObject();

        System.out.println(s);



    }
}

//how readObject() and writeObject() internally works
//Ans: Internally ObjectInputStream.readObject()/writeObject() has a reflection which will find whether the
// object(to be serialized) has a method readObject() or writeObject() if exist it will call it other wise
// it will continue in same method. It will use reflection to read the properties of class and then serialize and deserialize.
//each type has predefined length of stream so this way while deserialization it understands how many bytes to be read.

// How multiple objects can be stored and read from one file
//Ans: It is not allowed. One file can store only one serialized object.
// If you really want to store multiple objects use List of objects. So now the list is one object and can be stored.
// Then deserialize the list object and then iterate over list and use all the objects.

//Two benefits why someone will write custom serialization
//1. if there are 100 fields in class and only few fields needs to be added in ser. Instead adding transient to all
//fields, it is better to write writeObject/readObject with only required fields.
//2. If parent class implements Serializable. This is the way we can avoid child class from providing serialization.
// write readObject() and writeObject() in child class and throw NotSerializableException.


//Steps - How serialization works
/*
It writes out the metadata of the class associated with an instance.
It recursively writes out the description of the superclass until it finds java.lang.object.
Once it finishes writing the metadata information, it then starts with the actual data associated with the instance. But this time, it starts from the topmost superclass.
It recursively writes the data associated with the instance, starting from the least superclass to the most-derived class.
 */


//What is readResolve()
//the readResolve method, which is called when preparing the deserialized object before returning it to the caller.
//SO if you want to just block the original deserialization logic and do something special override this method.
// readObject() is used to read serialized object in your own way but after reading Object this method is called to return
// read object to the caller.
// so this is the easiest way to block de serialization.