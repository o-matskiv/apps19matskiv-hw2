package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    public ImmutableLinkedList q_lst;

    public Queue() {
        this.q_lst = new ImmutableLinkedList();
    }
    public ImmutableLinkedList GetLst(){
        return this.q_lst;
    }


    public Object peek() {
        if (this.q_lst.size() > 0) {
            return this.q_lst.getFirst();
        }
        throw new IndexOutOfBoundsException();

    }

    public Object dequeue() {
        if (this.q_lst.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        Object first = q_lst.getFirst();
        q_lst = q_lst.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        q_lst = q_lst.addLast(e);
    }
}