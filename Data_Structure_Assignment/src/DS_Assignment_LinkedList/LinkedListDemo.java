package DS_Assignment_LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDemo<T> implements Iterable<T>{
	private Node first;
	private Node last; 
	private int nodeCount;
	
   public LinkedListDemo(){
     	first = null;
    	last = null;
    	nodeCount = 0;
    }
   public int size()
   {
	   return nodeCount;
   }

   public void insert(T item) {
	   //Adding 1st node
	   if(first == null) {
		   first = new Node(item);
		   last = first  ; 
	   } // some elements are already present then grab the last node and update its value
	   else
	   {
		   Node newLastNode = new Node(item);
		   last.setNextNode(newLastNode);
		   last = newLastNode;
		   
	   }
	   nodeCount++;
   }
   
   public T delete()
   {
	  if(first == null) {
		  throw new IllegalStateException("List is empty,No more items to delete");
	  }
	  
	  T nodeItem=first.getNodeItem();
	  //update the firstnode and delete the old first
	  
	  first = first.getNextNode();
	  nodeCount--;
	  return nodeItem;
   }
   
   public void insertAtPosition(T item ,int position)
   {
	   if (size()<position){
		   throw  new IllegalStateException("The linked list is smaller than the specific postion");
	   }
	   
	  
	   Node currentNode = first;
	   for(int i=1; i< position && currentNode != null ; i++) {
		   currentNode = currentNode.getNextNode();
	   }
	   // create newnode and update the pointers
	   Node newNode = new Node(item);
	   Node nextNode = currentNode.getNextNode();
	   currentNode.setNextNode(newNode);
	   newNode.setNextNode(nextNode);
	   nodeCount++;
	   
   }
   public T deleteAtPosition(int position)
   {
	   if (first == null){
		   throw  new IllegalStateException("List is empty, No more items to be deleted");
	   }
	   
	   Node currentNode = first;
	   Node perviousNode = first;
	   
	   for(int i=1; i< position && currentNode != null ; i++) {
		   perviousNode = currentNode;
	       currentNode = currentNode.getNextNode();}
	       
	       //update the pointer and delete the specified node
	         T nodeItem = currentNode.getNodeItem();
	         perviousNode.setNextNode(currentNode.getNextNode());
	         nodeCount--;
	         return nodeItem;
	         
   }
 
   //Finder and getter methods
   
   //get method returns the item as you pass in the position
   
   public T get (int position)
   {
	   //check if the list is nor empty
	   if(first == null){
		   throw  new IllegalStateException("List is empty, No item to get");
		   }
	   Node currentNode = first;
	   for(int i=1; i< position && currentNode != null ; i++) {
		   if(i ==  position){
		   return currentNode.getNodeItem();}
		   
		   currentNode = currentNode.getNextNode();
	   }
	   
	   //if we didn't find it then return null 
	return null;
	   
	   
   }
   //find method returns the position as you pass in the item
   public int find(T item) {
	   if(first == null){
		   throw  new IllegalStateException("List is empty, No item to Find");
		   }
	   
	   Node currentNode = first;
	   for(int i=1; i< size() && currentNode != null ; i++) {
	   if(currentNode.getNodeItem().equals(item)) {
		  return i; 
	   }
	   currentNode = currentNode.getNextNode();
	   }
	   return -1;
   }
   //overriding toString() method
   
   /*
  public String toString() {
	   StringBuffer content = new StringBuffer();
	   Node currentNode =first;
		//System.out.println(currentNode);
	   
	   
	   while(currentNode != null)  {
		   content.append(currentNode.getNodeItem());
		   currentNode = currentNode.getNextNode();
	   
	   if(currentNode != null) {
		   content.append(",");
	     }
	   }
	   return content.toString();
   }
  */
  
   //print the Linked List
   public void printList()
   {
	   Node currentNode = first;
	   
	   while(currentNode !=  null)
	   {
		   System.out.print(currentNode.getNodeItem() + " ");
		   currentNode = currentNode.getNextNode();
	   }
   }
   
   public T  getMiddleElement()
   {
	  Node fast=first;
	  Node slow = first;
	  while(fast != null && fast.getNextNode() != null) {
		  slow = slow.getNextNode();
		  fast = fast.getNextNode().getNextNode();
	  }
	  return slow.getNodeItem();
   }
   
   public void reverseListList() {
	   Node prev = null;
	    Node currentNode = first;
	    Node nextNode = null;
	  
		while (currentNode != null) {
			nextNode = currentNode;
			currentNode = currentNode.nextNode;
			
			// Now reverse the Linked List ( changes arrow direction )
			nextNode.nextNode = prev;    
			prev = nextNode;
			first = nextNode;
		}
	}
 
	private class Node{
		private Node nextNode;
		private T nodeItem;
		
		public Node(T item){
			this.nextNode = null;
			this.nodeItem =item;	
		}
		
		public void setNextNode(Node nextNode)
		{
			this.nextNode = nextNode;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		public T getNodeItem() {
			return nodeItem;
		}
	
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator();
	}

private class MyLinkedListIterator implements Iterator<T>{
	 Node currentNode = null;
	
	
	@Override
	// It will check if node is available on iterator point. If node on iterator point is not null , return TRUE else returns FALSE.
	public boolean hasNext() {
		if(currentNode == null && first != null) {
			return true;
		}
		else if(currentNode != null) {	
			return currentNode.getNextNode() != null;
		}
		else {
		return false;}
		
	}

	@Override
	//Return the data on the iterator point.
	public T next() {
		if(currentNode == null && first != null) {
			currentNode	= first;
			return first.getNodeItem();
			}
		else if(currentNode != null) {
			currentNode = currentNode.getNextNode();
			return currentNode.getNodeItem();
		}
		throw new NoSuchElementException("No element to travese the list");
	}
	
}
		
		
	
}
  
