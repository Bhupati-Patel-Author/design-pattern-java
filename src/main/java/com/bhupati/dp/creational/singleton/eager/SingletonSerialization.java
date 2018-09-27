package com.bhupati.dp.creational.singleton.eager;

import java.io.*;

public class SingletonSerialization implements Serializable{

    private static SingletonSerialization instance = new SingletonSerialization();

    public static SingletonSerialization getInstance() {
        return instance;
    }

    private SingletonSerialization() {
        System.out.println("Constructor..");
    }

    static  void print(String name, SingletonSerialization obj) {
        System.out.println(String.format("Object : %s, Hashcode: %d ", name, obj.hashCode()));
    }

//    private Object readResolve()  {
//        System.out.println("Applying read resolve");
//        return instance;
//    }

    public static void main(String[] args) throws Exception{
        SingletonSerialization s1 = SingletonSerialization.getInstance();
        SingletonSerialization s2 = SingletonSerialization.getInstance();

        print("s1", s1);
        print("s2", s2);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\s2.ser"));
        oos.writeObject(s2);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Desktop\\s2.ser"));
        SingletonSerialization s3 = (SingletonSerialization) ois.readObject();

        print("s3", s3);
    }

}
