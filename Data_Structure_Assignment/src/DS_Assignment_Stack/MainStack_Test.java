package DS_Assignment_Stack;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MainStack_Test {
public static void main(String[] args) {
	try {
	DemoStack<Integer> stack = new DemoStack<>();
	System.out.println("Pushing elements : ");
	stack.push(20);
	stack.push(40);
	stack.push(60);
	stack.push(80);
	stack.push(100);
	stack.printStack();
	System.out.println("\nTotal Number of elements in the stack are : "+ stack.size());
	
	System.out.println("Stack Elements are : ");
	stack.printStack();
	System.out.println();
	System.out.println("Poped element of the Stack : " + stack.pop());
	System.out.println("Poped element of the Stack : " + stack.pop());
	stack.printStack();
	System.out.println("peek is : " + stack.peek());
	
	//stack.contains(40);
	
	System.out.println("after Reversal");
	stack.reverseStack(stack);
	stack.printStack();
	System.out.println();

	//System.out.println(stack.peek());
	
	System.out.println("Testing Iterator..........");
	
	 Iterator<Integer> itr = stack.iterator();
	  while(itr.hasNext()) {
		  
		  System.out.print(itr.next() + "...... ");
	  }
	/*try{
     boolean flag= itr.hasNext();
     System.out.println(flag);
     System.out.println(itr.next());
     
     boolean flag2= itr.hasNext();
     System.out.println(flag2);
     System.out.println(itr.next());
     
     boolean flag1= itr.hasNext();
     System.out.println(flag1);
     System.out.println(itr.next());

     boolean flage= itr.hasNext();
     System.out.println(flage);
     System.out.println(itr.next());
  }catch(Exception e)
   {
	System.out.println(e.getMessage());
    }
     */
     System.out.println("\nChecking contains..."+stack.contains(20));

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
