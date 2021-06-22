package DS_Assignment_Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueMain_Test {
//Testing
	public static void main(String[] args) {
		try {
		QueueDemo<Integer> queue = new QueueDemo<>();
		System.out.println("Inserting elemnts :");
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.printQueue();
		System.out.println();
		
		System.out.println("Peek is : "+ queue.peek());
		
	    System.out.println("Deleted element is : " + queue.deQueue());		
		System.out.println();
		System.out.print("printing elments of queue :");
		queue.printQueue();
		
		System.out.println("\nSize of the queue is :" +queue.size());
		
	    boolean bol =queue.contains(20);
	    System.out.println("\nContaining element or not ="+bol);
	
	    
		
		System.out.println("Testing Iterator..");
		 Iterator<Integer> itr = queue.iterator();
			  while(itr.hasNext()) {
				  
				  System.out.print(itr.next() + "  ");
			  }
			  //checking for exceptions
			  System.out.println(itr.next());
				
		
		System.out.println("\nReversed queue : ");
		queue.reverseQueue(queue);
		queue.printQueue();
		}catch(IllegalStateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			System.out.println("\n"+e.getMessage());
		}
		
	
		
	}}
