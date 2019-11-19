package ua.edu.ucu.collections.immutable;
import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{
    private Object[] array;
    private int len;

    public ImmutableArrayList() {
        array = new Object[10];
        this.len = 0;
    }

    public ImmutableArrayList(int size) {
        array = new Object[size];
        this.len = 0;
    }

    public ImmutableArrayList(Object[] array) {
        this.array = new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.len = array.length;
    }


    @Override
    public ImmutableArrayList add(Object e) {
        return add(this.len, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > this.len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = new Object[1];
        array[0] = e;
        return this.addAll(index, array);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ImmutableArrayList new_array = new ImmutableArrayList(this.len + c.length);
        for (int i = 0; i < this.array.length; i++) {
            new_array.array[i] = this.array[i];
        }
        return new_array.addAll(this.len-1, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] new_array = new Object[array.length + c.length];
        System.arraycopy(array, 0, new_array, 0, index);
        System.arraycopy(c, 0, new_array, index, c.length);
        System.arraycopy(array, index, new_array, index + c.length,
                array.length - index);
        return new ImmutableArrayList(new_array);
    }


    @Override
    public Object get(int index) {
        if (index < this.len || index > 0) {
            return this.array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index < this.len  || index > 0) {
            Object[] new_array = new Object[array.length - 1];
            System.arraycopy(array, 0, new_array, 0, index);
            System.arraycopy(array, index + 1, new_array, index, array.length - index - 1);
            return new ImmutableArrayList(new_array);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < this.len) {
            Object[] new_array = array.clone();
            new_array[index] = e;
            return new ImmutableArrayList(new_array);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String toString() {
        if (this.isEmpty()){
            return "";
        }
        String res  = Integer.toString((Integer) this.array[0]);
        for (int i = 1; i < this.len; i++) {
            res =  res + ", "+ Integer.toString((Integer) this.array[i]);
        }
        return res;
    }
}
