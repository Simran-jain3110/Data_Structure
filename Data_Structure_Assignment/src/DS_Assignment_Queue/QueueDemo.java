package DS_Assignment_Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueDemo<T> implements Iterable<T> {
	private T[] queue;
	private int front;
	private int rear;
	
	public QueueDemo()
	{
		this(1000);
	}
	
	public QueueDemo(int size)
	{
		queue = (T[])new Object[size];
		front = -1;
		rear = -1;
	}
	public int size()
	{     // If queue is empty then return zero
		if(front == -1 && rear == -1) {
			return 0;
		}
		else {
			return rear - front + 1 ;
		}
			
	}
	
	public void enQueue(T item)
	{
		//Check if the queue is full
		if(rear+1 % queue.length == front) {
			throw new IllegalStateException("Queue is full,cannot insert more elements");
		}
		//check if any item have been added to the queue yet,ie insert the first item(if needed)
		else if(size() == 0) {
			front++;
			rear++;
			queue[rear] = item;	
		}
		// if some elemets are already present,add the data at the end of the queue
		else {
			rear++;
			queue[rear] = item;
			
		}
	}
	
	public T deQueue()
	{
		T item = null;
		//if queue is empty,can't delete anything
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty, cannot deQueue Elements");

		}
		//if this is the last element of the queue, then we need to reset the pointers
		else if(front == rear) {
			item = queue[front];
			 queue[front] = null;   //to free the memory for gc
			front = -1;
			rear = -1;
			
		}
		//grab the front of the queue , return it and update the front pointer
		else {
			item = queue[front];
			queue[front] = null;
			front++;
		}
		
		return item;
	}
	
	public boolean contains(T item) {
		boolean flag = false;
		if(size() == 0) {
			return flag;

		}
		for(int i = front; i < rear; i++)
		{
			if(queue[i].equals(item)) {
				flag = true;
			    break;
			}
		}	
		return flag;
	}
	
	public T peek() {
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty, cannot deQueue Elements");

		}
		return queue[front];	
	}
	
	 // print queue elements 
    public void printQueue() 
    { 
        int i; 
        if(size() == 0) {
			throw new IllegalStateException("Queue is empty, Nothing to display");

		} 
   
        // traverse front to rear and print elements 
        for (i = front; i <= rear; i++) { 
            System.out.print( queue[i] + " "); 
        } 
        
    }
    
     public void reverseQueue(QueueDemo <T> queue) {
        // Base case
        // reverse of an empty queue is an empty queue
        if (size() == 0) {
            return;
        }
        // remove an element from queue and store it in a variable, say curr
        T temp = queue.deQueue();
        // recursively call the reverseQueue method on remaining queue
        reverseQueue(queue);
        // add the removed element to the end of the reversed queue
        queue.enQueue(temp);
    }
     
     @Override
 	public Iterator<T> iterator() {
 		// TODO Auto-generated method stub
 		return new QueueIterator<T>();
 	} 
     
     class QueueIterator<T> implements Iterator<T> {
 		
 		private int i;

 		@Override
 		public boolean hasNext() {
 			 return (i < size());
 		}
 		
 		
 		@Override
 		public T next() {
 			if (!hasNext())
 				throw new NoSuchElementException("No more elements to iterate");
             T item = (T) queue[(i + front) % queue.length];
             i++;
             return item;
 		}

 }
    
	
	
	}


