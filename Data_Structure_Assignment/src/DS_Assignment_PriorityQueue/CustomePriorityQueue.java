package DS_Assignment_PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CustomePriorityQueue<K> implements Iterable<K>{
	private PQNode<K> head;
	
	public void add(K value,Integer priority)
	{
		PQNode newNode = new PQNode(value,priority);
		if(head == null) {
			head = newNode;
			return ;
		}
		Integer prevPriority = -1;
		PQNode temp = head;
		PQNode prevNode = null;
		while(temp != null)
		{
			if(priority > prevPriority && priority<temp.priority)
			{
				break;
			}
			prevPriority = temp.priority;
			prevNode =temp;
			temp = temp.next;
		}
		if(prevNode == null)
		{
			newNode.next = head;
			head = newNode;
		}
		else {
			prevNode.next = newNode;
			
		}	
	}
	public void remove() {
		if(head == null)
		{
			throw new NoSuchElementException("Queue is already empty,Nothing to remove");
		}
		System.out.println("Removing  "+head.data+" with priority"+head.priority);
		head = head.next;
	}
	
	public K peek()
	{
		if(head == null) {
			throw new NoSuchElementException("Exception Raised...Queue is empty !!");}
		return head.data;
	}
	
	 public boolean contains(K item) {
		   if(head == null){
			   throw  new IllegalStateException("List is empty, No item to Find");
			   }
		   
		   PQNode  currentNode = head;
		   for(int i=1; i< size() && currentNode != null ; i++) {
		   if(currentNode.data .equals(item)) {
			  return true; 
		   }
		   currentNode = currentNode.next;
		   }
		   return false;
	   }
	 
	 public void reversePQueue() {
		 PQNode prev = null;
		 PQNode currentNode = head;
		 PQNode nextNode = null;
		  
			while (currentNode != null) {
				nextNode = currentNode;
				currentNode = currentNode.next;
				
				// Now reverse the Linked List ( changes arrow direction )
				nextNode.next = prev;    
				prev = nextNode;
				head = nextNode;
			}
		}
	 
	public Integer size()
	{
		PQNode temp = head;
		int count =0;
		while(temp != null)
		{
			count++;
			temp=temp.next;
		}
		return count;
	}
		
	public void print()
	{
		PQNode temp = head;
		int count =0;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public Iterator<K> iterator() {
		return new MyPriorityQueueIterator();
	}
	class MyPriorityQueueIterator implements Iterator {

		@Override
		public boolean hasNext() { 
				if(head == null)
				 return false;
				     
				else 
					return true;}

		@Override
		public Object next() {
			 if (!hasNext()) throw new NoSuchElementException();
			    K item = head.data;
			    head = head.next; 
			    return item;
		}
		}

	}

class PQNode<K>
{
	K data;
	Integer priority;
	PQNode next;
	
	public PQNode(K data,Integer priority) {
		this.data= data;
		this.priority=priority;
	}
	
}	

	
