package lab6;

import java.awt.Container;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
		size = 0;
	}

	// creates an array of double-size if the array of
	// elements is full
	public void growSize() {
		if (size == elements.length - 1) {
			int newCap = elements.length * 2;
			E[] newList = (E[]) new Object[newCap];
			for (int i = 0; i < elements.length; i++) {
				newList[i] = elements[i];
			}
			elements = newList;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		for (int j = 0; j < size; j++) {
			if (j == i) {
				return elements[i];
			}
		}
		throw new IndexOutOfBoundsException("Invalid index!!!");
	}

	// Replaces the element at index i with e, and
//		returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		for (int j = 0; j < size; j++) {
			if (j == i) {
				E replacedE = elements[i];
				elements[i] = e;
				return replacedE;
			}
		}
		throw new IndexOutOfBoundsException("Invalid index!!!");

	}

	// It is used to append the specified element at the
	// end of a list.
	public boolean add(E e) {
		growSize();
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all
//		subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i > size || i < 0) {
			throw new IndexOutOfBoundsException("Invalid index!!!");
		} else {
			growSize();
			for (int j = size - 1; j >= i; j--) {
				elements[j + 1] = elements[j];
			}
			elements[i] = e;
			size++;
		}
	}

	// Removes and returns the element at index i,
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Invalid index!!!");
		} else {
			E removedE = elements[i];
			for (int j = i; j < size; j++) {
				elements[j] = elements[j + 1];
			}
			size--;
			return removedE;
		}
	}

	// It is used to clear all elements in the list.
	public void clear() {
		size = 0;
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	// It is used to return the index in this list of the
	// last occurrence of the specified element, or -1 if the
	// list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i > 0; i--) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the
	// elements in this list in the correct order.
	public E[] toArray() {
		E[] resArr = (E[]) new Object[size];
		int i = 0;
		for (E e : resArr) {
			resArr[i] = e;
			i++;
		}
		return resArr;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> newList = new MyArrayList<>();
		newList.elements = elements.clone();
		newList.size = size;
		return newList;
	}

	// It returns true if the list contains the specified
	// element
	public boolean contains(E o) {
		if (indexOf(o) != -1)
			return true;
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				return i;
		}
		return -1;
	}

	// It is used to remove the first occurrence of the
	// specified element.
	public boolean remove(E e) {
		int index = indexOf(e);
		if (index > -1) {
			for (int i = index; i < size; i++) {
				elements[i] = elements[i + 1];
				size--;
			}
			return true;
		}
		return false;
	}

	// It is used to sort the elements of the list on the
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
		E[] newElements = toArray();
		Arrays.sort(newElements, c);
	}
	public void printList() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] +  " ");
		}
	}
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(3);
		list.add(2,6);
//		list.clear();
//		System.out.println(list.remove(2));
		System.out.println(list.contains(1));
		System.out.println(list.indexOf(6));
		list.printList();
 	}
}
