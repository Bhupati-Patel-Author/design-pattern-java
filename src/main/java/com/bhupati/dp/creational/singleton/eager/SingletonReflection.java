package com.bhupati.dp.creational.singleton.eager;

import java.lang.reflect.Constructor;

public class SingletonReflection {

    private static SingletonReflection instance = new SingletonReflection();

    private SingletonReflection() {
        System.out.println("Creating using Constructor...");
//        if(instance != null) {
//            throw new RuntimeException("Can't cresating instance using constructor, use getInstance ");
//        }
    }

    public static SingletonReflection getInstance() {
        return instance;
    }

    static  void print(String name, SingletonReflection obj) {
        System.out.println(String.format("Object : %s, Hashcode: %d ", name, obj.hashCode()));
    }

    public static void main(String[] args) throws Exception {
        SingletonReflection s1 = SingletonReflection.getInstance();
        SingletonReflection s2 = SingletonReflection.getInstance();

        print("s1", s1);
        print("s2", s2);

        Class clazz = Class.forName("com.bhupati.dp.creational.singleton.eager.SingletonReflection");
        Constructor<SingletonReflection> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        SingletonReflection s3 = constructor.newInstance();

        print("s3", s3);
    }
}
