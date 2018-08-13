package common.data_type;

/**
 *
 * @param <T> the type of object stored within the queue
 */
public interface Queue<T> {

	/**
	 * This method indicates whether the queue is empty or not.=
	 * @return A boolean indicating whether or not the queue contains contents
	 */
	boolean isEmpty();
	
	/**
	 * This method returns the size of the queue
	 * @return An integer representing the size of the queue
	 */
	int size();
	
	/**
	 * This methods adds an object to the back of the queue
	 * @param object The object to be added to the queue
	 */
	void enqueue(T object);
	
	/**
	 * This method removes the first element from the queue
	 * @return Returns the first object in the queue, of type T
	 */
	T dequeue();
	
	/**
	 * gets the object stored at the front of the queue
	 * @return An object of type T, representing the first object in the queue
	 */
	T getFirstElement();
	
	/**
	 * gets the object stored at the end of the queue
	 * @return An object of type T, representing the last object in the queue
	 */
	T getLastElement();
	
}
