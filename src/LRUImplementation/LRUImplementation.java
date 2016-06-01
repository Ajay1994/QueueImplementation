package LRUImplementation;

import java.util.*;
class Node{
	int data;
	Node next, prev;
	Node(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
class Queue{
	int capacity;
	int size;
	Node front, rear;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Queue(int capacity){
		this.capacity = capacity;
		this.size = 0;
		this.front = null;
		this.rear = null;
	}
	public void printQueue(){
		Node temp = front;
		while(temp != null){
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
		System.out.println();
	}
	public void enqueue(int data){
		//Check if data is present in the queue
		if(map.containsKey(data)){
			//move it in the front of the queue
			Node node = map.get(data);
			//Node is last node in queue
			if(node.next == null) return;
			//node is first in the queue
			if(node.prev == null){
				front = front.next;
				rear.next = node;
				node.next = null;
				rear = node;
				return;
			}else{
				//Node is middle in the queue
				node.prev.next = node.next;
				node.next.prev = node.prev;
				rear.next = node;
				node.next = null;
				rear = node;
				return;
			}
		}else{
			//Check if queue is full
			if(size == capacity){
				front = front.next;
				Node node = new Node(data);
				rear.next = node;
				node.prev = rear;
				rear = rear.next;
				map.put(data, node);
			}else{
				Node node = new Node(data);
				if(front == null){
					front = node;
					rear = node;
					size += 1;
					map.put(data, node);
					return;
				}
				rear.next = node;
				node.prev = rear;
				rear = rear.next;
				size += 1;
				map.put(data, node);
			}
		}
	}
}
public class LRUImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(4);
		queue.enqueue(1);
		queue.printQueue();
		queue.enqueue(2);
		queue.printQueue();
		queue.enqueue(3);
		queue.printQueue();
		queue.enqueue(1);
		queue.printQueue();
		queue.enqueue(4);
		queue.printQueue();
		queue.enqueue(5);
		queue.printQueue();
		
	}

}
