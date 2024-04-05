package TP1;

public class MySimpleLinkedList<T> {
    private Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    public T extractFront() {
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        if(index<=this.size()){
            int i = 0;
            Node<T> aux = this.first;
            while ((i<index)&&(aux.getNext()!=null)){
                aux = aux.getNext();
                i++;
            }
            if(i==index){
                return aux.getInfo();
            }
        }
        return null;
    }

    public int size() {
        if(!this.isEmpty()){
            int size = 1;
            Node<T> aux = this.first;
            while ((aux!=null)&&(aux.getNext()!=null)){
                size++;
                aux = aux.getNext();
            }
            return size;
        }
        return 0;
    }

    //Ejercicio 3
    public int indexOf(T n){
        if(!this.isEmpty()){
            int i = 0;
            Node<T> tmp = this.first;
            //T info = tmp.getInfo();
            while ((tmp!=null)&&(tmp.getInfo()!=n)){
                tmp = tmp.getNext();
                System.out.println(i);
                i++;
            }
            if((tmp!=null)&&(tmp.getInfo()==n)) {
                System.out.println("hola");
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String info = "";
        if (!this.isEmpty()) {
            Node<T> tmp = this.first;
            info += tmp.getInfo();

            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                info += "--->" + tmp.getInfo();
            }
        }
        return "[" + info + "]";
    }
}
