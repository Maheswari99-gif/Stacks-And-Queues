package com.capgemini.stackandqueue;

public class MyLinkedList<k> {
	public INode<k> head;
	public INode<k> tail;
	private int size;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(INode<k> myNode, INode<k> newNode) {
		INode<k> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
		this.size++;
	}

	public void append(INode<k> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;

		}
		size++;

	}

	public void add(INode<k> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			INode<k> temp = this.head;
			this.head = newNode;
			this.head.setNext(temp);
		}
		this.size++;
	}

	public INode<k> pop() {
		INode<k> tempNode = this.head;
		this.head = head.getNext();
		size--;
		return tempNode;
	}

	public INode<k> popLast() {
		INode<k> tempNode = this.head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		this.tail.setNext(null);
		size--;
		return tempNode;

	}

	public boolean search(k value) {
		INode<k> node = this.head;
		while (node != null) {
			if (node.getKey().equals(value)) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	public void printMyNodes() {
		INode<k> node = this.head;
		if (node != null) {
			System.out.println("List: " + node.getKey());
			while ((node = node.getNext()) != null) {
				System.out.println("->" + node.getKey());
			}
		}

	}

	public void insertAfter(k value, INode<k> newNode) {
		INode<k> node = this.head;
		while (node != null) {
			if (node.getKey().equals(value)) {
				break;
			}
			node = node.getNext();
		}
		if (node != null) {
			INode<k> temp = node.getNext();
			node.setNext(newNode);
			node.getNext().setNext(temp);
			if (node == this.tail) {
				this.tail = newNode;
			}
			size++;
		}
	}

	public void deleteNode(k value) {
		INode<k> node = this.head;
		if (node == this.tail && node != null) {
			if (node.getKey().equals(value)) {
				this.head = null;
				this.tail = null;
				size--;
			}
		} else if (node != null) {
			while (node != this.tail && !(node.getNext().getKey().equals(value))) {
				node = node.getNext();
			}
			if (node != this.tail) {
				INode<k> deleteNode = node.getNext();
				node.setNext(deleteNode.getNext());
				deleteNode.setNext(null);
				if (deleteNode == this.tail) {
					this.tail = node;
				}
				size--;
			}
		}
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		list.append(node1);
		list.append(node3);
		list.insert(node1, node2);
		list.printMyNodes();
		System.out.println("\nPopped element: " + list.popLast().getKey());
		System.out.println("\nList after popping:\n");
		list.printMyNodes();
	}
}

interface INode<k> {
	k getKey();

	void setKey(k key);

	INode<k> getNext();

	void setNext(INode<k> next);
}

class MyNode<k> implements INode<k> {
	private k key;
	private MyNode<k> next;

	public MyNode(k key) {
		super();
		this.key = key;
		this.next = null;
	}

	public k getKey() {
		return key;
	}

	public void setKey(k key) {
		this.key = key;
	}

	public MyNode<k> getNext() {
		return next;
	}

	public void setNext(INode<k> next) {
		this.next = (MyNode<k>) next;
	}

}
