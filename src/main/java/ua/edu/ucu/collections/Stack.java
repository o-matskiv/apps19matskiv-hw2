package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList s_list;

    public Stack() {
        s_list = new ImmutableLinkedList();
    }

    Object peek() {
        return s_list.getFirst();
    }

    Object pop() {
        Object first = s_list.getFirst();
        s_list = s_list.removeFirst();
        return first;
    }

    void push(Object e) {
        s_list = s_list.addFirst(e);
    }


}