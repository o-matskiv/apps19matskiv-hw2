package ua.edu.ucu.collections;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue q;
    private Queue empty_q;


    @Before
    public void setUp() {
        this.q = new Queue();
        this.empty_q = new Queue();
        for (int i = 1; i <=5 ; i++) {
            this.q.enqueue(i);
        }

    }
    @Test
    public void testEnqueue() {
        this.q.enqueue(6);
        Object[] expected = {1,2,3,4,5,6};
        Object[] actual = this.q.GetLst().toArray();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testPeek() {
        for (int i = 1; i <=5 ; i++) {
            assertEquals(q.peek(), 1);
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() {
        Object i = empty_q.peek();
    }


    @Test
    public void testDequeue() {
        for (int i = 1; i <=5 ; i++) {
            assertEquals(q.dequeue(), i);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueException() {
        Object i = empty_q.dequeue();
    }

}