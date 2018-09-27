package com.bhupati.dp.creational.singleton.eager;

public class SingletonCloneable implements Cloneable {

    private static SingletonCloneable instance = new SingletonCloneable();

    private SingletonCloneable() {
        System.out.println("Creating using Constructor...");
    }

    public static SingletonCloneable getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //if(instance != null)throw new CloneNotSupportedException();
        return super.clone();
    }

    static  void print(String name, SingletonCloneable obj) {
        System.out.println(String.format("Object : %s, Hashcode: %d ", name, obj.hashCode()));
    }

    public static void main(String[] args) throws Exception {
        SingletonCloneable s1 = SingletonCloneable.getInstance();
        SingletonCloneable s2 = SingletonCloneable.getInstance();

        print("s1", s1);
        print("s2", s2);

        SingletonCloneable s3 = (SingletonCloneable) s2.clone();

        print("s3", s3);
    }
}
