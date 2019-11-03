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
    public ImmutableList add(Object e) {
        Object[] array = new Object[1];
        array[0] = e;
        return this.addAll(array);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index > this.len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = new Object[1];
        array[0] = e;
        return this.addAll(index, array);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList new_array = new ImmutableArrayList(this.len + c.length);
        return new_array.addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > this.len) {
            throw new IndexOutOfBoundsException();
        }
        Object[] new_array = new Object[this.len + c.length];
        System.arraycopy(this.array, 0, new_array, 0, index);
        System.arraycopy(c, 0, new_array, index, c.length);
        System.arraycopy(this.array, index, new_array, index + c.length,
                this.array.length - index);
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
    public ImmutableList remove(int index) {
        if (index < this.len  || index > 0) {
            Object[] new_array = new Object[array.length - 1];
            System.arraycopy(array, 0, new_array, 0, index);
            System.arraycopy(array, index + 1, new_array, index, array.length - index - 1);
            return new ImmutableArrayList(new_array);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableList set(int index, Object e) {
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
            if (this.array[i] == e) {
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
    public ImmutableList clear() {
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
        String str = Arrays.toString(toArray());
        return str.substring(1, str.length() - 1);
    }
}
