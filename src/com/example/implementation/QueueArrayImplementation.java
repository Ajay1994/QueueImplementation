package com.example.implementation;
/*
 * Like Stack, Queue is a linear structure which follows a particular order in which the operations are performed. 
 * The order is First In First Out (FIFO).  A good example of queue is any 
 * queue of consumers for a resource where the consumer that came first is served first.
The difference between stacks and queues is in removing. In a stack we remove the item the most recently added; 
in a queue, we remove the item the least recently added.

Operations on Queue:
Mainly the following four basic operations are performed on queue:

Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition.
Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If the 
queue is empty, then it is said to be an Underflow condition.
Front: Get the front item from queue.
Rear: Get the last item from queue.

Applications of Queue:
Queue is used when things don’t have to be processed immediatly, but have to be processed in First InFirst Out 
order like Breadth First Search. This property of Queue makes it also useful in following kind of scenarios.

1) When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
2) When data is transferred asynchronously (data not necessarily received at same rate as sent) between two 
processes. Examples include IO Buffers, pipes, file IO, etc.

See this for more detailed applications of Queue and Stack.


Time Complexity: Time complexity of all operations like enqueue(), dequeue(), isFull(), isEmpty(), front() and rear() is O(1). 
There is no loop in any of the operations.

 */
class Queue{
	//size keep track of the total number of elements in the list now
	int front, rear, size;
	int capacity;
	int list[];
	Queue(int capacity){
		this.capacity = capacity;
		this.list = new int[capacity];
		this.front = this.size = 0;
		this.rear = capacity - 1;
	}
	public boolean isFull(){
		if(this.size == this.capacity) return true;
		return false;
	}
	public boolean isEmpty(){
		if(this.size == 0) return true;
		return false;
	}
	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue is already full !!");
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;
		this.list[this.rear] = data;
		this.size = this.size + 1;
		System.out.println("Data Enqued : "+ data);
	}
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is already empty !!");
			return -1;
		}
		int data = this.list[front];
		this.front = (this.front + 1) % capacity;
		this.size -= 1;
		System.out.println("Data Dequed : "+ data);
		return data;
	}
	public void printQueue(){
		for(int i = this.front; i <= this.rear; i++){
			System.out.print(this.list[i] + " - ");
		}
	}
	public int getFront(){
		if(this.isEmpty()){
			System.out.println("Queue is already empty !!");
			return -1;
		}
		return this.list[this.front];
	}
	public int getRear(){
		if(this.isEmpty()){
			System.out.println("Queue is already empty !!");
			return -1;
		}
		return this.list[this.rear];
	}
}
public class QueueArrayImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(3);
		queue.enqueue(6);
		queue.enqueue(10);
		System.out.println("Current Front : "+queue.getFront());
		System.out.println("Current Rear : "+queue.getRear());
		queue.enqueue(25);
		queue.enqueue(35);
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
	}

}
