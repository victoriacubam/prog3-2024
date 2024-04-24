package TP3;

public class Main {
    public static void main(String[]args){
        Tree a1 = new Tree();
        a1.insert(5);
        a1.insert(8);
        a1.insert(2);
        a1.insert(1);
        a1.insert(10);

        System.out.println(a1.getHeight());

    }
}
