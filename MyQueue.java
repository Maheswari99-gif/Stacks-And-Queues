package com.capgemini.stackandqueue;

public class MyQueue {
	private final MyLinkedList myLinkedList;

	public MyQueue() {
		this.myLinkedList = new MyLinkedList();

	}

	public int size() {
		return myLinkedList.size();
	}

	public boolean isEmpty() {
		return myLinkedList.isEmpty();
	}

	public void enqueue(INode myNode) {
		myLinkedList.append(myNode);
	}

	public void printQueue() {
		myLinkedList.printMyNodes();
	}
	public INode dequeue() {
		return myLinkedList.pop();
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		myQueue.enqueue(node1);
		myQueue.enqueue(node2);
		myQueue.enqueue(node3);
		System.out.println("Queue: ");
		myQueue.printQueue();
		System.out.println("First element in the queue is deleted: "+myQueue.dequeue().getKey()+"\n");
		System.out.println("Queue after dequeue operation: ");
		myQueue.printQueue();
	}

}
