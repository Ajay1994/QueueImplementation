package com.example.implementation;
/*
 * Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n. 
 * 1) Create an empty queue of strings
	2) Enqueue the first binary number “1” to queue.
	3) Now run a loop for generating and printing n binary numbers.
	……a) Dequeue and Print the front of queue.
	……b) Append “0” at the end of front item and enqueue it.
	……c) Append “1” at the end of front item and enqueue it.
 */
import java.util.*;
public class GenerateBinaryNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> queue = new LinkedList<String>();
		int n = 10;
		queue.add("1");
		for(int i = 0; i < n ; i++){
			String x = queue.remove();
			System.out.println(x);
			queue.add(x+"0");
			queue.add(x+"1");
		}
		
	}

}
