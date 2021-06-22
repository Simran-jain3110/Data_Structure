package DS_Assignment_PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestPriorityQueue {
	public static void main(String[] args) {
		try {
			CustomePriorityQueue<Integer> pqueue = new CustomePriorityQueue<>();
			System.out.println("Enqueing elements to the Priority Queue :");
			pqueue.add(101, 1);
			pqueue.add(103, 2);
			pqueue.add(104, 3);
			pqueue.add(105, 4);
			pqueue.add(1016, 5);
			System.out.println("Elements of Priority queue are : ");
			pqueue.print();
			System.out.println("Dequeue :" );
			pqueue.remove();
			System.out.println("Elements after dequeuing : ");
			pqueue.print();
			System.out.println("Peek is : "+pqueue.peek());
			boolean bol = pqueue.contains(100);
			System.out.println("Does queue contains 100 ? " +bol );
			System.out.println("Checking iterator :");

			Iterator<Integer> itr = pqueue.iterator();
			System.out.println(itr.hasNext());
			while(itr.hasNext()) {
				System.out.print(itr.next()+ " ");
			}
			System.out.println();
			System.out.println("Reversed ");
			pqueue.reversePQueue();
			pqueue.print();
			//System.out.println("Peek is : "+pqueue.peek());  -- checking for exception
			
		}
		catch(NoSuchElementException e)
		{
		System.out.println(e.getMessage());	
		}
		catch(IllegalStateException e1)
		{
			System.out.println(e1.getMessage());}
	
		}
}
