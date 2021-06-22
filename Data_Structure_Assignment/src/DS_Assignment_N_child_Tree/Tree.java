package DS_Assignment_N_child_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 *  n-child tree.
 *
 * @param <T> Any class type
 */
public class Tree<T> implements Iterable {

    private Node<T> root;

    /**
     * Initialize a tree with the specified root node.
     *
     * @param root The root node of the tree
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * Checks if the tree is empty (root node is null)
     *
     * @return true if the tree is empty,
     * false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Get the root node of the tree
     *
     * return the root node.
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Set the root node of the tree. Replaces existing root node.
     *
     * @param root The root node to replace the existing root node with.
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     *
     * Check if given data is present in the tree.
     *
     * @param key The data to search for
     * return trueif the given key was found in the tree,
     * false otherwise.
     */
    public boolean contains(T key) {
        return find(root, key);
    }

    /**
     * Get the number of nodes (size) in the tree.
     *
     * @return The number of nodes in the tree
     */
    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    /**
     *
     * Get the number of descendants a given node has.
     *
     * @param node The node whose number of descendants is needed.
     * return the number of descendants
     */
    public int getNumberOfDescendants(Node<T> node) {
        int n = node.getChildren().size();
        for (Node<T> child : node.getChildren())
            n += getNumberOfDescendants(child);

        return n;

    }
   
    //Important***
    public void  getElementsByValue(Node<T> node) {
    	//print all the children of that node
    	 int n = node.getChildren().size();
    	 for(Node<T> child : node.getChildren())
    	 {
          System.out.println(child);
    	 }
    }

    public boolean printKDistant(Node root, int klevel) 
    { 
        Queue<Node> q = new LinkedList<>(); 
        int level = 1; 
        boolean flag = false; 
        q.add(root); 
      
        // extra null is added to keep track 
        // of all the nodes to be added before 
        // level is incremented by 1 
        q.add(null); 
        while (q.size() > 0) 
        { 
            Node temp = q.peek(); 
      
            // print when level is equal to k 
            if (level == klevel && temp != null)
            { 
                flag = true; 
                System.out.print( temp.getData() + " "); 
            } 
            q.remove(); 
            if (temp == null)
            { 
                if (q.peek() != null) 
                    q.add(null); 
                level += 1; 
      
                // break the loop if level exceeds 
                // the given level number 
                if (level > klevel) 
                    break; 
            }
            else 
            { 
                if (temp.getChildren() != null) 
                    q.addAll(temp.children); 
      
            } 
        } 
        System.out.println();
        return flag; 
    } 
      public void getElementsByLevel() {
    	  
    System.out.print( "data at level 2 : "); 
    boolean ret = printKDistant(root, 2); 
    if (ret == false) 
        System.out.print( "Number exceeds total" +
                            "number of levels\n"); 
  
	
      }

 	
 	 public  int height(Node<T> node) {
 	    int h = -1;

 	    for (Node child : node.children) {
 	      int ch = height(child);
 	      h = Math.max(h, ch);
 	    }
 	    h += 1;

 	    return h;
 	  }
 	 

     
   
  public void print(Node<T> root) {
	  String s = root.getData() + " = ";
	  for(int i=0;i<root.children.size();i++)
	  {
		  s=s+root.children.get(i).getData()+",";
	  }
	  System.out.println(s);
	  for(int i=0;i<root.children.size();i++)
	  {
		  print(root.children.get(i));
	  }
  }

    public boolean find(Node<T> node, T keyNode) {
        boolean res = false;
        if (node.getData().equals(keyNode))
            return true;

        else {
            for (Node<T> child : node.getChildren())
                if (find(child, keyNode))
                    res = true;
        }

        return res;
    }
           //Remove Print and add children(Alogorithum)
	  public  void PrintBreadthFirst(Node<T> node) {
		  Queue<Node> q = new ArrayDeque<>();
		  q.add(node);
   	  	  while(q.size() > 0) {        		
   	  		  node = q.remove();
   	  	      System.out.print(node.getData()+ " ");
   		
	           for(Node child : node.children) {
	        	 q.add(child);
	        		  }
	        	  }
	        	  System.out.println(".");
               }
	
	  public Iterator<T> iterator1() {
		 return new InOrderIterator(root);
	    } 
		   
	    public  class InOrderIterator implements Iterator<T> {
	        private Queue<Node<T>> queue = new ArrayDeque<>();
	        Node<T> node;

	        public InOrderIterator(Node<T> node) {
	           queue.add(node);
	           this.node=node;
	        }

	        @Override
	        public boolean hasNext() {
	            return !queue.isEmpty();
	        }

	        @Override
	        public T next() {
	        	Node node =queue.remove();
	        	queue.addAll(node.children);
	        	return (T) node.getData();
	        }
	        	
	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    }

	
    public Node<T> findNode(Node<T> node, T keyNode) {
        if (node == null)
            return null;
        if (node.getData().equals(keyNode))
            return node;
        else {
            Node<T> cnode = null;
            for (Node<T> child : node.getChildren())
                if ((cnode = findNode(child, keyNode)) != null)
                    return cnode;
        }
        return null;
    }
    
	

    /**
     *
     * Get the list of nodes arranged by the pre-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the pre-order
     */
    public ArrayList<Node<T>> getPreOrderTraversal() {
        ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
        buildPreOrder(root, preOrder);
        return preOrder;
    }

    /**
     *
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<Node<T>> getPostOrderTraversal() {
        ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
        buildPostOrder(root, postOrder);
        return postOrder;
    }

    private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
        preOrder.add(node);
        for (Node<T> child : node.getChildren()) {
            buildPreOrder(child, preOrder);
        }
    }

    private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
        for (Node<T> child : node.getChildren()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
    }

   
	public Iterator iterator() {
		
		return new DepthFirstIterator(root);
	}
	
	public class DepthFirstIterator implements Iterator{
	
		 Integer nval;
		Stack<Pair> st;
		
		public DepthFirstIterator(Node<T> node) {
			st = new Stack<>();
			st.push(new Pair(node,-1));
			next();
			}
		 
	
	@Override
	public boolean hasNext() {
		if (nval ==null)
			return false;
		else 
			return true;
	}

	@Override
	public Object next() {
		Integer fr= nval;
        nval = null;
	    while(st.size() > 0){
	      Pair top = st.peek();
	      if(top.state == -1){
	    	  nval = (Integer) top.node.getData();
	        top.state++;
	        break;
	      } else if (top.state >= 0 && top.state < top.node.children.size()){
	        Pair cp = new Pair(top.node.children.get(top.state), -1);
	        st.push(cp);

	        top.state++;
	      } else {
	        st.pop();
	      }
	    }
		
		return fr;
	}


	}
	 class Pair {
	    Node node;
	    int state;

	    Pair(Object node, int state){
	      this.node = (Node) node;
	      this.state = state;
	    }
	  }}

