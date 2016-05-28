package com.example.problems;

/*
 * Method 1 (By making enQueue operation costly)
	This method makes sure that oldest entered element is always at the top of stack 1, so that deQueue operation just pops from stack1. To put the element at top of stack1, stack2 is used.
	
	enQueue(q, x)
	  1) While stack1 is not empty, push everything from satck1 to stack2.
	  2) Push x to stack1 (assuming size of stacks is unlimited).
	  3) Push everything back to stack1.
	
	dnQueue(q)
	  1) If stack1 is empty then error
	  2) Pop an item from stack1 and return it
	
	Method 2 (By making deQueue operation costly)
	In this method, in en-queue operation, the new element is entered at the top of stack1. In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
	
	enQueue(q,  x)
	  1) Push x to stack1 (assuming size of stacks is unlimited).
	
	deQueue(q)
	  1) If both stacks are empty then error.
	  2) If stack2 is empty
	       While stack1 is not empty, push everything from satck1 to stack2.
	  3) Pop the element from stack2 and return it.

 */
public class QueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
