package com.example.implementation;
/*
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

	Examples:
	
	Input :
	arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
	k = 3
	Output :
	3 3 4 5 5 5 6
	
	---------------------------------------------------------------------------------
	Method 2 (Use Self-Balancing BST)
	---------------------------------------------------------------------------------
	1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k.
	2) Run a loop for i = 0 to n – k
	…..a) Get the maximum element from the BST, and print it.
	…..b) Search for arr[i] in the BST and delete it from the BST.
	…..c) Insert arr[i+k] into the BST.

	Time Complexity: Time Complexity of step 1 is O(kLogk). Time Complexity of steps 2(a), 2(b) and 2(c) is O(Logk).
	Since steps 2(a), 2(b) and 2(c) are in a loop that runs n-k+1 times, time complexity of the complete algorithm 
	is O(kLogk + (n-k+1)*Logk) which can also be written as O(nLogk).
	
	
	---------------------------------------------------------------------------------
	Method 3 (A O(n) method: use Dequeue)
	---------------------------------------------------------------------------------
	We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements. 
	An element is useful if it is in current window and is greater than all other elements on left side of it in 
	current window. We process all array elements one by one and maintain Qi to contain useful elements of current 
	window and these useful elements are maintained in sorted order. The element at front of the Qi is the largest
	and element at rear of Qi is the smallest of current window
 */
import java.util.*;
import java.util.Queue;
public class MaximumAllSubArraySizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int [] array = {12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		
		for(int i = 0; i < k ; i++){
			//First remove all the elements which are older than current window size
			//Idea is to pop out all elements from top of queue till you get greater and then put element above it.
			//The queue will have only doez element, which are greater than current and within the window.
			while(!queue.isEmpty() && array[queue.getFirst()] <= array[i]){
				queue.removeFirst();
			}
			queue.addFirst(i);
		}
		System.out.println(array[queue.peekLast()]);
		int i = k;
		//remove older ones from the queue because they are now garbage.
		for(;i< array.length; i++){
			//older ones lie in the back of the queue becoz new ones are added in front
			while(!queue.isEmpty() && queue.getLast()<= i - k){
				queue.removeLast();
			}
			//now the queue have all the current window items only. remove the smaller ones from front
			while(!queue.isEmpty() && array[queue.getFirst()] <= array[i]){
				queue.removeFirst();
			}
			queue.addFirst(i);
			System.out.println(array[queue.peekLast()]);
		}
	}

}
