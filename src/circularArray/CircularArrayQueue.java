package circularArray;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
	/** Index of the front of the queue. */
	private int front;

	/** Index of the rear of the queue. */
	private int rear;

	/** Current number of elements in the queue. */
	private int size;

	/** Current capacity of the queue. */
	private int capacity;

	/** Default capacity of the queue. */
	private static final int DEFAULT_CAPACITY = 10;

	/** Array to hold the data. */
	private E[] theData;

	// Constructors
	/** Construct a queue with the default initial capacity. */ 
	public CircularArrayQueue() { 
		this(DEFAULT_CAPACITY); 
	}

	@SuppressWarnings("unchecked") 
	/** Construct a queue with the specified initial capacity. 
	 * @param initCapacity The initial capacity */ 
	public CircularArrayQueue(int initCapacity) { 
		capacity = initCapacity; 
		theData = (E[]) new Object[capacity]; 
		front = 0; rear = capacity - 1; size = 0; 
	}

	// Public Methods
	/**
	 * Inserts an item at the rear of the queue.
	 * 
	 * @post item is added to the rear of the queue.
	 * @param item The element to add
	 * @return true (always successful)
	 */
	@Override
	public boolean offer(E item) {
		if (size == capacity) {
			reallocate();
		}
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;

	}

	/**
	 * Returns the item at the front of the queue without removing it.
	 * 
	 * @return The item at the front of the queue if successful; return null if
	 */
	@Override
	public E peek() {
		if (size == 0)
			return null;
		else
			return theData[front];
	}

	/** Removes the entry at the front of the queue and returns it if the queue is not empty.
	 *  @post front references item that was second in the queue. 
	 *  @return The item removed if successful or null if not */ 
	@Override public E poll() { 
		if (size == 0) { 
			return null; 
		} 
		E result = theData[front]; 
		front = (front + 1) % capacity; 
		size--; 
		return result; 
	}

	// Private Methods
	/** Double the capacity and reallocate the data. 
	 * @pre The array is filled to capacity. 
	 * @post The capacity is doubled and the first half of the expanded array is */ 
	@SuppressWarnings("unchecked") 
	private void reallocate() { 
		int newCapacity = 2 * capacity; 
		E[] newData = (E[]) new Object[newCapacity]; 
		int j = front; 
		for (int i = 0; i < size; i++) { 
			newData[i] = theData[j]; j = (j + 1) % capacity; 
		}
		front = 0;
		rear = size - 1; 
		capacity = newCapacity; 
		theData = newData; 
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
	@Override
	public String toString() {
		String str = "[";
		if(isEmpty()) {
			return "[]";
		}
		
		str += theData[front];
		
		for(int i = (front + 1) % capacity; i != rear; i = (i+1) % capacity) {
			str += " " + theData[i];
		}
		
		str += " " + theData[rear];
		
		return str + "]";
	}
	
//	Remove method
	public E remove() {
		if(this.size == 0) {
			throw new NoSuchElementException();
		}
		
		E dataRemoved = theData[front];
		theData[front] = null;
		
		front = (front + 1) % theData.length;
	
		size--;
		return dataRemoved;
		
	}
	

}
