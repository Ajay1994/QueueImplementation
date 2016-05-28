package com.example.implementation;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class LQueue{
	Node rear, front;
	LQueue(){
		rear = null;
		front = null;
	}
	public Node newNode(int data){
		Node node = new Node(data);
		return node;
	}
	public void enqueue(int data){
		Node node = new Node(data);
		// If queue is empty, then new node is front and rear both
		if(this.rear == null){
			this.rear = node;
			this.front = node;
			System.out.println("enqued : " +this.rear.data);
			return;
		}
		this.rear.next = node;
		this.rear = node;
		System.out.println("enquedd : " +this.rear.data);
		return;
	}
	public Node dequeue(){
		//Queue is empty, then return null
		if(this.front == null){
			return null;
		}
		Node node = this.front;
		this.front = this.front.next;
		
		//if after dequeue, queue becomes empty, then set rear to null also.
		if(this.front == null) this.rear = null; 
		return node;
	}
	public int getRear(){
		if(this.rear == null) return Integer.MIN_VALUE;
		return this.rear.data;
	}
	public int getFront(){
		if(this.front == null) return Integer.MIN_VALUE;
		return this.front.data;
	}
	public void printQueue(){
		if(this.front == null) return;
		Node temp = this.front;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
}

public class QueueLinkedListImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LQueue queue = new LQueue();
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		
		System.out.println("Front : "+ queue.getFront());
		System.out.println("Rear : "+ queue.getRear());
		
		queue.dequeue();
		System.out.println("Front : "+ queue.getFront());
		System.out.println("Rear : "+ queue.getRear());
		
		queue.enqueue(10);
		System.out.println("Front : "+ queue.getFront());
		System.out.println("Rear : "+ queue.getRear());
		
		queue.printQueue();
	}

}
