package DS_Assignment_Stack;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StackMain_UI {
	public static void main(String[] args) {
		 
		DemoStack<String> stack = new DemoStack<>(); 
		  Iterator<String> itr = stack.iterator();
	      Scanner scan = new Scanner(System.in);
	      System.out.println("\n\t\t\t\t\tStack Menu ");

	      
	      while (true) {
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
	    	  System.out.println("Select the option to perform the specfic operation on the given Data Stucture\n");
	    	  System.out.println("1. Push \t" +"\t2. Pop \t" +"\t3. Peek \t" +"4. Contains \t"+"5. Size \t"+"\n\n6. Traverse/Print\t"+"7. Iterator\t" +"8. Reverse\t"+"9. Exit\t");
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	    	  System.out.println("\nEnter your choice: \t ");
	    	  int choice = scan.nextInt();
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	    	  try {
				switch(choice)
				{
				case 1:
					System.out.println("Enter an element to add : ");
					stack.push(scan.next());
			         break;
			         
			     
			    	case 2:
					System.out.println("Popped :" + stack.pop());
					break;
			
				case 3:
					System.out.println("Element at the top is :" + stack.peek() );
					break;
					
				case 4:
					System.out.println("Entre a element to check weather the stack contains it or not :");
                    boolean contain = stack.contains(scan.next());
                    System.out.println(contain);
					break;
					
				case 5:
					int stackSize = stack.size();
					System.out.println("Size is : " +stackSize);
					break;
					
				case 6:
					System.out.println("Printing the list without iteratot :");
				    stack.printStack();
					break;
					
				case 7:
					System.out.println("Traversing through the list using iterator :");
					while(itr.hasNext()) {
					System.out.print(itr.next()+"  ");	}
					break;
					
				case 8:
					System.out.println("Reversed list:");
					stack.reverseStack(stack);
					stack.printStack();
					break;
					
				case 9:
					 System.out.println("Exiting ....  :)");
			           System.exit(0);
				
				default:
						System.out.println("\nWrong Choice!!");
						return;
				}
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
		  
}
