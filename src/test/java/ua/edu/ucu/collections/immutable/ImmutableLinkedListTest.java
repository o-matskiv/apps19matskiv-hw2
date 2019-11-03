package ua.edu.ucu.collections.immutable;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList first_list;
    private ImmutableLinkedList second_list;
    private ImmutableLinkedList empty_list;


    @Before
    public void setUp() throws Exception {
        first_list = new ImmutableLinkedList(new Object[]{10,9,5,3,6,7});
        second_list = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5});
        empty_list = new ImmutableLinkedList();

    }

    @Test
    public void testAdd() {
        ImmutableList result = first_list.add(20);
        Object[] expected = new Object[]{10,9,5,3,6,7,20};
        assertArrayEquals(result.toArray(), expected);

    }

    @Test
    public void testAddIndex() {
        ImmutableList result = first_list.add(4, 8);
        Object[] expected = new Object[]{10,9,5,3,8,6,7};
        assertArrayEquals(result.toArray(), expected);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});

    }


    @Test
    public void testAddAll() {
        ImmutableList result = first_list.addAll(second_list.toArray());
        Object[] expected = new Object[]{10,9,5,3,6,7,1, 2, 3, 4, 5};
        assertArrayEquals(result.toArray(), expected);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testAddAllIndex() {
        ImmutableList result = first_list.addAll(0, second_list.toArray());
        Object[] expected = new Object[]{1, 2, 3, 4, 5,10,9,5,3,6,7};
        assertArrayEquals(result.toArray(), expected);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexOutOfRange() {
        ImmutableList actual = first_list.addAll(10, second_list.toArray());
    }

    @Test
    public void testGet() {
        assertEquals(first_list.get(3), 3);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        first_list.get(100);
    }

    @Test
    public void testRemove() {
        ImmutableList result = first_list.remove(2);
        assertArrayEquals(result.toArray(), new Object[]{10,9,3,6,7});
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableList actual = first_list.remove(-1);
    }

    @Test
    public void testSet() {
        ImmutableList result = first_list.set(2, 10);
        assertArrayEquals(result.toArray(), new Object[]{10,9,10,3,6,7});
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExpectation() {
        ImmutableList actual = first_list.set(-1, 1);
    }

    @Test
    public void testValidIndex() {
        int result = first_list.indexOf(9);
        assertEquals(result, 1);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testNonValidIndex() {
        int result = first_list.indexOf(100);
        assertEquals(result, -1);
    }

    @Test
    public void testSize() {
        assertEquals(first_list.size(), 6);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testEmptySize() {
        assertEquals(empty_list.size(), 0);
    }

    @Test
    public void testClear() {
        ImmutableList result = first_list.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testClearEmpty() {
        ImmutableList result = empty_list.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
    }

    @Test
    public void testEmpty() {
        assertFalse(first_list.isEmpty());
    }

    @Test
    public void testNonEmpty() {
        assertTrue(empty_list.isEmpty());
    }

    @Test
    public void testEmptyToString() {
        assertEquals(empty_list.toString(), "");
    }

    @Test
    public void testToString() {
        assertEquals(first_list.toString(), "10, 9, 5, 3, 6, 7");
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList result = first_list.addFirst(2);
        Object[] expected = new Object[]{2,10, 9, 5, 3, 6, 7};
        assertArrayEquals(result.toArray(), expected);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testAddFirstEmpty() {
        ImmutableLinkedList result = empty_list.addFirst(1);
        Object[] expected = new Object[]{1};
        assertArrayEquals(result.toArray(), expected);
        assertEquals(result.size(), 1);
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList result = first_list.addLast(0);
        Object[] expected = new Object[]{10, 9, 5, 3, 6, 7,0};
        assertArrayEquals(result.toArray(), expected);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList result = first_list.removeFirst();
        assertArrayEquals(result.toArray(), new Object[]{9,5,3,6,7});
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList actual = first_list.removeLast();
        assertArrayEquals(actual.toArray(), new Object[]{10,9,5,3,6});
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }


    @Test
    public void testGetFirst() {
        assertEquals(first_list.getFirst(), 10);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }

    @Test
    public void testGetLast() {
        assertEquals(first_list.getLast(), 7);
        assertArrayEquals(first_list.toArray(), new Object[]{10,9,5,3,6,7});
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastException() {
        empty_list.getLast();
    }

}