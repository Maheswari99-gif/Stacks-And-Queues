package com.capgemini.stackandqueue;

public class MyStack {
	private final MyLinkedList myLinkedList;

	public MyStack() {
		this.myLinkedList=new MyLinkedList();
		
	}
	public int size() {
		return myLinkedList.size();
	}
	
	public boolean isEmpty() {
		return myLinkedList.isEmpty();
	}
	public void push(INode myNode) {
		myLinkedList.add(myNode);
	}
	public void printStack() {
		myLinkedList.printMyNodes();
	}
	public INode peak() {
		return myLinkedList.head;
	}
	public INode pop(){
		return myLinkedList.pop();
	}
	public void popTillEmpty() {
		while(!isEmpty()) {
			System.out.println("Peaked Element: "+peak().getKey()+"\n");
			System.out.println("Popped Element: "+pop().getKey()+"\n");
			System.out.println("\n");
		}
		System.out.println("Stack is empty.");
	}
	

}
