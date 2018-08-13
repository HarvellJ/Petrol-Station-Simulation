package common.data_type;

import java.util.ArrayList;

/**
 * This class implements a queue ADT using an array list
 * @param <T> The type paramater representing the type held within this queue
 */
public class ArrayListQueue<T> implements Queue<T> {
	
	protected ArrayList<T> queue;
	private int endOfQueue;
	
	/**
	 * The constructor that instantiates the queue contents ArrayList
	 */
	public ArrayListQueue() {
		queue = new ArrayList<T>();
		endOfQueue = 0;
	}
	
	/* (non-Javadoc)
	 * @see common.data_type.Queue#enqueue(java.lang.Object)
	 */
	public void enqueue(T object) {
		queue.add(endOfQueue, object);
		endOfQueue++;
	}
	
	/* (non-Javadoc)
	 * @see common.data_type.Queue#dequeue()
	 */
	public T dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("Queue empty, cannot dequeue an empty queue");
		}
		// take the first element, shorten queue
		T result = queue.get(0);
		endOfQueue--;
		// shift remaining items
		if(endOfQueue>0) {
			for (int i = 0; i < endOfQueue; i++) {
				queue.set(i, queue.get(i+1));
			}
		}
		queue.remove(endOfQueue);

		return result;
	}
	
	/* (non-Javadoc)
	 * @see common.data_type.Queue#size()
	 */
	public int size() {
		return queue.size();
	}
	
	/* (non-Javadoc)
	 * @see common.data_type.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		return queue.size() == 0;
	}
	
	public T getFirstElement() {
		if(!this.isEmpty()) {
			return queue.get(0);
		}else {
			return null;
		}
	}
	
	public T getLastElement() {
		return queue.get(endOfQueue-1);
	}
}
