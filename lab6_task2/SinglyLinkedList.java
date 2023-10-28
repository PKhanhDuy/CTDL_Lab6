package lab6_task2;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
		head = tail;
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false
	// otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in
	// the list.
	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}
	}

	// Returns (but does not remove) the last element in
	// the list.
	public E last() {
		if (isEmpty())
			return null;
		return tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = tail = newNode;
			size++;
		} else {
			Node<E> cur = head;
			while (cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(newNode);
			tail = cur.getNext();
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty())
			return null;
		if (head.getNext() == null) {
			E res = head.getData();
			head = null;
			return res;
		}
		E data = head.getData();
		Node<E> curr = head;
		head = head.getNext();
		curr.setNext(null);
		size--;
		return data;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node<E> tempNode = head;
		E res = null;
		if (isEmpty())
			return null;
		if (head.getNext() == null) {
			head = null;
		} else {
			for (int i = 0; i < size - 1; i++) {
				if (tempNode.getNext().getNext() == null) {
					res = tempNode.getNext().getData();
					tempNode.setNext(null);
					tail = tempNode;
				}
				tempNode = tempNode.getNext();
			}
		}
		size--;
		return res;
	}

	public void print() {
		Node<E> tempNode = head;
		for (int i = 0; i < size; i++) {
			System.out.print(tempNode.getData() + " ");
			tempNode = tempNode.getNext();
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(5);
		list.addFirst(4);
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
//		list.removeLast();
		list.print();
//		System.out.println();
//		System.out.println(list.isEmpty());
//		System.out.println(list.last());
//		System.out.println(list.first());

	}
}
