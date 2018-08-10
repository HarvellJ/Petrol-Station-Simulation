package common.data_type;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListQueueTest {

	/**
	 * This method tests the enqueue method of the ArrayListQueue, ensuring that elements are added correctly
	 * Checks ordering and size when adding multiple elements
	 */
	@Test
	public void testEnqueue() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		String string1 = "test";
		String string2 = "test2";
		String string3 = "test3";

		// check queue is empty, add an item, and then check queue is not empty
		assertEquals(true, alq.isEmpty());
		alq.enqueue(string1);
		assertEquals(false, alq.isEmpty());
		assertEquals(1, alq.size());

		
		//test ordering		
		alq.enqueue(string2);
		assertEquals(string1, alq.getFirstElement());
		assertEquals(string2, alq.getLastElement());
		assertEquals(2, alq.size());

		alq.enqueue(string3);
		assertEquals(string1, alq.getFirstElement());
		assertEquals(string3, alq.getLastElement());
		assertEquals(3, alq.size());
	}

	/**
	 * This method tests the enqueue for larger amounts of data
	 * Checks ordering and size when adding multiple elements
	 */
	@Test
	public void testEnqueueLargeQueueSize() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		assertEquals(true, alq.isEmpty());
		
		// add one element that should remain at the start
		String string1 = "test";
		alq.enqueue(string1);
		assertEquals(string1, alq.getFirstElement());

		for (int i = 1; i < 10000; i++) {
			String string = "test" + i;
			alq.enqueue(string);
			assertEquals(string, alq.getLastElement());
			// string1 should still be first element
			assertEquals(string1, alq.getFirstElement());
			assertEquals(i+1, alq.size());
		}
	}
	
	/**
	 * This method tests dequeuing an element from the queue
	 * this method takes a standard path through dequeuing an element
	 */
	@Test
	public void testDequeueOneObject() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		assertEquals(true, alq.isEmpty());
		
		// add one element 
		String string1 = "test";
		alq.enqueue(string1);
		assertEquals(string1, alq.getFirstElement());
		assertEquals(1, alq.size());
		
		// the value returned from dequeueing should be equal to string1
		String retVal = alq.dequeue();
		assertEquals(string1, retVal);

		assertEquals(true, alq.isEmpty());
	}
	
	/**
	 * This method tests dequeuing a large number of elements from the queue
	 */
	@Test
	public void testDequeueMultipleObject() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		assertEquals(true, alq.isEmpty());		

		for (int i = 0; i < 10000; i++) {
			String string = "test" + i;
			alq.enqueue(string);
			assertEquals(string, alq.getLastElement());
			// string1 should still be first element
			assertEquals(i+1, alq.size());
		}
		
		for (int i = 0; i < 10000; i++) {
			String retVal = alq.dequeue();
			assertEquals("test" + i, retVal);
		}
		
		assertEquals(true, alq.isEmpty());		

	}

	/**
	 * Test the size method when sequentially adding a handful of elements
	 */
	@Test
	public void testSizeLarge() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		
		for (int i = 0; i < 10000; i++) {
			String string = "test" + i;
			alq.enqueue(string);
			// string1 should still be first element
			assertEquals(i+1, alq.size());
		}
				
	}
	
	/**
	 * Test the size method when sequentially adding a large number of elements
	 */
	@Test
	public void testSizeSmall() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		String string1 = "test";
		String string2 = "test2";
		String string3 = "test3";

		// check queue is empty, add an item, and then check queue is not empty
		assertEquals(true, alq.isEmpty());
		alq.enqueue(string1);
		assertEquals(1, alq.size());
		alq.enqueue(string2);
		assertEquals(2, alq.size());
		alq.enqueue(string3);
		assertEquals(3, alq.size());
		alq.dequeue();
		assertEquals(2, alq.size());

	}

	/**
	 * tests the isEmpty method of the queue
	 */
	@Test
	public void testIsEmpty() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		String string1 = "test";
		assertEquals(true, alq.isEmpty());
		alq.enqueue(string1);
		assertEquals(false, alq.isEmpty());
	}
	
	/**
	 * This method tests the getFirstElement method
	 */
	@Test
	public void testgetFirstElement() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		String string1 = "test";
		String string2 = "test2";
		String string3 = "test3";

		//test ordering when adding multiple elements		
		alq.enqueue(string1);
		assertEquals(string1, alq.getFirstElement());
		alq.enqueue(string2);
		assertEquals(string1, alq.getFirstElement());
		alq.enqueue(string3);
		assertEquals(string1, alq.getFirstElement());
	}
	

	/**
	 * This method tests the getLastElement method
	 */
	@Test
	public void testgetLastElement() {
		ArrayListQueue<String> alq = new ArrayListQueue<String>();
		String string1 = "test";
		String string2 = "test2";
		String string3 = "test3";

		//test ordering when adding multiple elements		
		alq.enqueue(string1);
		assertEquals(string1, alq.getLastElement());
		alq.enqueue(string2);
		assertEquals(string2, alq.getLastElement());
		alq.enqueue(string3);
		assertEquals(string3, alq.getLastElement());
	}



}
