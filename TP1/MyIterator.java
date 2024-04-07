package TP1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> { //Siempre parametrizada igual q la lista
    private Node<T> cursor;
    public MyIterator (Node<T> cursor){
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor!=null;
    }

    @Override
    public T next() {
        T info = cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    public T value(){
        return cursor.getInfo();
    }
}
