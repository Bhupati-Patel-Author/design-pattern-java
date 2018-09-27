package com.bhupati.dp.creational.singleton.lazy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

    private static Singleton instance = null; //lazy initialization

    private Singleton() {
        System.out.println("Creating");
    }

    public static  Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    static void useSingleton() {
        Singleton singleton = Singleton.getInstance();
        print("singleton", singleton);
    }

    static  void print(String name, Singleton obj) {
        System.out.println(String.format("Object : %s, Hashcode: %d ", name, obj.hashCode()));
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(Singleton::useSingleton);
        service.submit(Singleton::useSingleton);
        service.shutdown();
    }

}
