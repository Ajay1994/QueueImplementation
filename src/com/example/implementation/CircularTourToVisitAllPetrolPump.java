package com.example.implementation;
/*
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

	1. The amount of petrol that every petrol pump has.
	2. Distance from that petrol pump to the next petrol pump.
	
	Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each 
	petrol pump and it has infinite capacity). Expected time complexity is O(n). Assume for 1 litre petrol, the truck
	can go 1 unit of distance.
	
	For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as 
	{4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. 
	Output should be “start = 1″ (index of 2nd petrol pump).
	
	Solution :
	We can use a Queue to store the current tour. We first enqueue first petrol pump to the queue, we keep 
	enqueueing petrol pumps till we either complete the tour, or current amount of petrol becomes negative. 
	If the amount becomes negative, then we keep dequeueing petrol pumps till the current amount becomes positive 
	or queue becomes empty.
	
 */
import java.util.*;
class Pump{
	int petrol;
	int distance;
	Pump(int petrol, int distance){
		this.petrol = petrol;
		this.distance = distance;
	}
}
public class CircularTourToVisitAllPetrolPump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pump []pumps = new Pump[5];
		pumps[0] = new Pump(4,6);
		pumps[1] = new Pump(4,6);
		pumps[2] = new Pump(6,5);
		pumps[3] = new Pump(7,3);
		pumps[4] = new Pump(4,5);
		LinkedList<Pump> queue = new LinkedList<Pump>();
		int availablePetrol = 0;
		int start = 0;
		int i = 0;
		while(pumps[i % pumps.length].petrol < pumps[i % pumps.length].distance){
			i += 1;
			start += 1;
		}
		System.out.println(start+ " "+i);
		
		while(queue.size() < 5 && start < pumps.length){
			availablePetrol += pumps[i % pumps.length].petrol;
			if(availablePetrol >= pumps[i % pumps.length].distance){
				queue.add(pumps[i % pumps.length]);
				availablePetrol -= pumps[i % pumps.length].distance;
				System.out.println("Avail :"+ availablePetrol+ "Start :"+ start+ " i :"+(i % pumps.length));
				i++;
			}else{
				availablePetrol -= pumps[start].petrol;
				availablePetrol += pumps[start].distance;
				if(!queue.isEmpty()) queue.remove();
				start += 1;
				
			}
		}
		System.out.println();
		System.out.println(start);
	}

}
