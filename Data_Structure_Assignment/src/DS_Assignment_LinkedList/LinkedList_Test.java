package DS_Assignment_LinkedList;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList_Test {

   public static void main(String[] args) {
	   try {
	   LinkedListDemo<Integer> list = new LinkedListDemo<>();
	   list.insert(10);
	   list.insert(30);
	  // System.out.println(list.size());
	    list.insert(900);
	    System.out.println("Size of the list is :"+list.size());
	    System.out.println("Printing elments of linked list :");
	    list.printList();
	    System.out.println();
	  System.out.println( list.getMiddleElement());
	   // System.out.println(list.find(10));
	  
	//  list.reverseListList();
	  //list.printList();
	  System.out.println("Testing itretor");
	  Iterator<Integer> itr = list.iterator();
	  while(itr.hasNext()) {
		  
		  System.out.print(itr.next() + "...... ");
	  }
	  
	  
	//  System.out.println(list); // printing using toString() method
}catch(IllegalStateException e)
		{
	System.out.println(e.getMessage());
	System.out.println("Try again..");
}
  catch(InputMismatchException e)
  {
	  System.out.println(e.getMessage());
  }
  catch(NoSuchElementException e)
  {
	  System.out.println(e.getMessage());
	  
  }
   }
}
