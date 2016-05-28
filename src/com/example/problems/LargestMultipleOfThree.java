package com.example.problems;

import java.util.*;
/*
 * Given an array of non-negative integers. 
 * Find the largest multiple of 3 that can be formed from array elements.

	For example, if the input array is {8, 1, 9}, the output should be “9 8 1″, 
	and if the input array is {8, 1, 7, 6, 0}, output should be “8 7 6 0″.
	
	Solution Approach :
	
	Following is a solution based on the above observation.

	1. Sort the array in non-decreasing order.
	
	2. Take three queues. One for storing elements which on dividing by 3 gives remainder as 0.The 
	second queue stores digits which on dividing by 3 gives remainder as 1. The third queue stores digits 
	which on dividing by 3 gives remainder as 2. Call them as queue0, queue1 and queue2
	
	3. Find the sum of all the digits.
	
	4. Three cases arise:
	……4.1 The sum of digits is divisible by 3. Dequeue all the digits from the three queues. Sort them in 
	non-increasing order. Output the array.
	
	……4.2 The sum of digits produces remainder 1 when divided by 3.
	Remove one item from queue1. If queue1 is empty, remove two items from queue2. If queue2 contains less 
	than two items, the number is not possible.
	
	……4.3 The sum of digits produces remainder 2 when divided by 3.
	Remove one item from queue2. If queue2 is empty, remove two items from queue1. If queue1 contains less 
	than two items, the number is not possible.
	
	5. Finally empty all the queues into an auxiliary array. Sort the auxiliary array in non-increasing order. 
	Output the auxiliary array.
 */

/*
 * Can be extended to number with range more than 0-9 by
 * 
 * // A comparison function which is used by sort() in printLargest()
	int myCompare(string X, string Y)
	{
	    // first append Y at the end of X
	    string XY = X.append(Y);
	 
	    // then append X at the end of Y
	    string YX = Y.append(X);
	 
	    // Now see which of the two formed numbers is greater
	    return XY.compare(YX) > 0 ? 1: 0;
	}
	
 */
public class LargestMultipleOfThree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue0 = new PriorityQueue<Integer>();
		Queue<Integer> queue1 = new PriorityQueue<Integer>();
		Queue<Integer> queue2 = new PriorityQueue<Integer>();
		
		Integer [] array = {8, 1, 7, 6, 0, 4, 1, 2};
		
		Arrays.sort(array);
		
		for(int i = 0 ; i < array.length; i++){
			switch(array[i] % 3){
				case 0:
					queue0.add(array[i]);
					break;
				case 1:
					queue1.add(array[i]);
					break;
				case 2:
					queue2.add(array[i]);
					break;
			}
		}
		int sum = 0;
		for(int i = 0 ; i < array.length; i++){
			sum += array[i];
		}
		switch(sum % 3){
			case 0:
				Arrays.sort(array);
				
				break;
			case 1:
				if(queue1.size() == 0){
					if(queue2.size() < 2){
						return;
					}
					queue2.remove();
					queue2.remove();
				}else{
					queue1.remove();
				}
				break;
			case 2:
				if(queue2.size() == 0){
					if(queue1.size() < 2){
						return;
					}
					queue1.remove();
					queue1.remove();
				}else{
					queue2.remove();
				}
				break;
		}
		List<Integer> list = new ArrayList<Integer>();
		while(queue0.size() != 0){
			list.add(queue0.remove());
		}
		while(queue1.size() != 0){
			list.add(queue1.remove());
		}
		while(queue2.size() != 0){
			list.add(queue2.remove());
		}
		Collections.sort(list, Collections.reverseOrder());
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
