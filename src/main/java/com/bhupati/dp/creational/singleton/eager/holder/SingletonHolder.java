package com.bhupati.dp.creational.singleton.eager.holder;

public class SingletonHolder {

    private SingletonHolder() {
        System.out.println("Creating using Constructor...");
    }

    static class Holder {
        static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Holder.INSTANCE;
    }

    static void print(String name, SingletonHolder obj) {
        System.out.println(String.format("Object : %s, Hashcode: %d", name, obj.hashCode()));
    }

    public static void main(String[] args) {
        SingletonHolder s1 = SingletonHolder.getInstance();
        SingletonHolder s2 = SingletonHolder.getInstance();
        SingletonHolder s3 = SingletonHolder.getInstance();

        print("s1", s1);
        print("s2", s2);
        print("s3", s3);
    }

}
