package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList first_array;
    private ImmutableArrayList second_array;
    private ImmutableArrayList empty_array;


    @Before
    public void setUp() throws Exception {
        first_array = new ImmutableArrayList(new Object[]{10,9,5,3,6,7});
        second_array = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        empty_array = new ImmutableArrayList();

    }

    @Test
    public void testArrayAdd() {
        ImmutableList result = first_array.add(20);
        Object[] expected = new Object[]{10,9,5,3,6,7,20};
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testArrayAddIndex() {
        ImmutableList result = first_array.add(4, 8);
        Object[] expected = new Object[]{10,9,5,3,8,6,7};
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});
        assertArrayEquals(result.toArray(), expected);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayAddException() {
        ImmutableList result = first_array.add(10, 10);
    }



    @Test
    public void testArrayAddAllIndex() {
        ImmutableList actual = first_array.addAll(1, second_array.toArray());
        Object[] expected = new Object[]{10,1, 2, 3, 4, 5,9,5,3,6,7};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayAddAllIndexOutOfRange() {
        ImmutableList actual = first_array.addAll(10, new Object[] {1,2,3,4});
    }

    @Test
    public void testArrayGet() {
        assertEquals(first_array.get(3), 3);
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayGetException() {
        first_array.get(10);
    }

    @Test
    public void testArrayRemove() {
        ImmutableList actual = first_array.remove(2);
        assertArrayEquals(actual.toArray(), new Object[]{10,9,3,6,7});
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayRemoveException() {
        ImmutableList actual = first_array.remove(-1);
    }

    @Test
    public void testArraySet() {
        ImmutableList actual = first_array.set(2, 10);
        assertArrayEquals(actual.toArray(), new Object[]{10,9,10,3,6,7});
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArraySetException() {
        ImmutableList actual = first_array.set(-1, 1);
    }

    @Test
    public void testArrayIndexOfExists() {
        int result = first_array.indexOf(5);
        assertEquals(result, 2);
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test
    public void testArrayIndexOfNotExist() {
        int result = first_array.indexOf(100);
        assertEquals(result, -1);
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test
    public void testArraySize() {
        assertEquals(first_array.size(), 6);
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test
    public void testArraySizeEmpty() {
        assertEquals(empty_array.size(), 0);
    }

    @Test
    public void testArrayClear() {
        ImmutableList result = first_array.clear();
        assertArrayEquals(result.toArray(), new ImmutableArrayList().toArray());
        assertArrayEquals(first_array.toArray(), new Object[]{10,9,5,3,6,7});    }

    @Test
    public void testArrayClearEmpty() {
        ImmutableList result = empty_array.clear();
        assertArrayEquals(result.toArray(), new ImmutableArrayList().toArray());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(first_array.isEmpty());
    }

    @Test
    public void testIsNonEmpty() {
        assertTrue(empty_array.isEmpty());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(empty_array.toString(), "");
    }

    @Test
    public void testToString() {
        assertEquals(first_array.toString(), "10, 9, 5, 3, 6, 7");
    }


}
