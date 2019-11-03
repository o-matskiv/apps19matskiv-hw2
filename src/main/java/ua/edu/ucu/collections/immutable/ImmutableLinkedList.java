package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private int len;
    private Node head;

    private static class Node {
        private Object value;
        private Node next;

        private Node(Object value) {
            this.value = value;
            next = null;
        }

        private Node(Object value, Node next) {
            this(value);
            this.next = next;
        }
    }

    public ImmutableLinkedList(Object[] c) {
        if (c.length != 0) {
            this.head = new Node(c[0]);
            Node currentNode = this.head;
            for (int i = 1; i < c.length; i++) {
                currentNode.next = new Node(c[i]);
                currentNode = currentNode.next;

            }
        }
        this.len = c.length;
    }


    public ImmutableLinkedList() {
        this.head = null;
        this.len = 0;
    }

    private ImmutableLinkedList copyOf() {
        if (this.len == 0) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList new_list = new ImmutableLinkedList();
        new_list.len = this.len;
        new_list.head = new Node(head.value);
        Node currentNode = this.head.next;
        Node AddingNode = new_list.head;
        while (currentNode != null) {
            AddingNode.next = new Node(currentNode.value);
            AddingNode = AddingNode.next;
            currentNode = currentNode.next;
        }
        return new_list;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(this.len, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        ImmutableLinkedList new_list = this.copyOf();
        new_list.len = this.len + 1;
        if (index == 0) {
            new_list.head = new Node(e, new_list.head);
        } else {
            Node before = new_list.getNode(index - 1);
            before.next = new Node(e, before.next);
        }

        return new_list;
    }

    private Node getNode(int index) {
        if (index >= 0 || index <= this.len) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;}
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(len, c);
    }


    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index<0 || index>this.len){
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_list = copyOf();
        new_list.head = new Node(null, new_list.head);
        if (c.length > 0) {
            Node currentAdding = new_list.getNode(index);
            for (Object o : c) {
                currentAdding.next = new Node(o, currentAdding.next);
                currentAdding = currentAdding.next;
            }
        }
        new_list.head = new_list.head.next;
        new_list.len = this.len + c.length;
        return new_list;
    }

    @Override
    public Object get(int index) {
        if (index> len || index<0 ){
            throw new IndexOutOfBoundsException();
        }
        else {
           return getNode(index).value;
        }


    }

    @Override
    public ImmutableLinkedList remove(int index) {
        ImmutableLinkedList newList = copyOf();
        if (index < 0 || index >= this.len) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            newList.head = newList.head.next;
        } else {
            Node before = newList.getNode(index - 1);
            before.next = before.next.next;
        }
        newList.len--;
        return newList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index>-1 && index< this.len){
            ImmutableLinkedList new_list = copyOf();
            new_list.getNode(index).value = e;
            return new_list;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == e) {
                return i;
            }
            i++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] new_array = new Object[this.len];
        int i = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            new_array[i] = currentNode.value;
            currentNode = currentNode.next;
            i++;
        }
        return new_array;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "";
        }
        String res = Integer.toString((Integer) this.head.value);
        Node currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            res = res + ", "+ Integer.toString((Integer) currentNode.value);

        }
        return res.toString();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(this.len - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(this.len - 1);
    }


}