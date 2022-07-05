package Serialization;

import java.io.*;

class Test implements Serializable{

    int i=10, j = 20;
}



public class SerailizationDeserialization {

    public static void main (String[]args) throws IOException, ClassNotFoundException {

        Test t1 = new Test();

        //Serialization
        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(t1);


        //Desrialization
        FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Test t2 = (Test) ois.readObject();
        System.out.println(t2.i + "  " +t2.j);

    }


}
