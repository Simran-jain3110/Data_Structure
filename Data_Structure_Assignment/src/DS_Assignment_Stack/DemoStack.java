package DS_Assignment_Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DemoStack<T> implements Iterable<T>{
     
	private T []data;
	private int stackPointer;

	
	
		public DemoStack()   // to initialize the stack variables
		{
			data =(T[]) new Object[1000];
			stackPointer = 0;
		}
		
		   public void push(T newItem)
			{
			data[stackPointer++]=newItem;
			}
					
			public T pop() {
			if(stackPointer==0){
				throw new IllegalStateException("Stack is Empty,No more item to pop");
			}
			
			 return data[--stackPointer];			 
	 
		}

		  public T peek() {	
			  if(stackPointer==0) {
				  throw new IllegalStateException("Stack is Empty,No more item to pop");
				
			  }
			 // System.out.println(stackPointer); 
		    	return data[stackPointer - 1];
		  }
		  
		public boolean contains(T item) {	
		boolean flag=false;
		
		for(int i=0;i<stackPointer;i++) {
		if(data[i].equals(item)) {
			flag=true;
			break;
		}
		}
		  return flag;
		}
	
	  public int size(){
		  return stackPointer;
		    }
	  
	  public void printStack()
	  {
		  for(int i=0;i<stackPointer;i++)
		  {
			  System.out.print(data[i]+" "); 
		  }
	
	  }
	  public  void insertAtBottom(DemoStack<T> s, T item)
	    {
	        // base case: if the stack is empty, insert the given item at the bottom
	        if (stackPointer == 0)
	        {
	            s.push(item);
	            return;
	        }
	 
	        // Pop all items from the stack and hold them in the call stack
	        T top = s.pop();
	        insertAtBottom(s, item);
	 
	        // After the recursion unfolds, push each item in the call stack
	        // at the top of the stack
	        s.push(top);
	    }
	 
	    // Recursive function to reverse a given stack
	    public void reverseStack(DemoStack<T> s)
	    {
	        // base case: stack is empty
	    	 if (stackPointer == 0) {
	            return;
	        }
	 
	        // Pop all items from the stack and hold them in the call stack
	        T item = s.pop();
	        reverseStack(s);
	 
	        // After the recursion unfolds, insert each item in the call stack
	        // at the bottom of the stack
	        insertAtBottom(s, item);
	    }

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return new StackIterator();
		}
		
		
		private class StackIterator implements Iterator<T>{
         private int index = 0;
         private int last = -1;
         
			@Override
            public boolean hasNext() {
               return (index+1<=size());
         }
			//can also be implemented as  return (index+1<=stackPointer)

			@Override
		  public T next() {
              if (index>=size()) 
            	  throw new NoSuchElementException("No more elements to iterate.");
              last = index;
              return data[index++];
          }
		}
}





