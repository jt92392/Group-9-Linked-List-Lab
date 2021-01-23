
public class CircularlyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> tail;
	private int size;

	public CircularlyLinkedList() {
		tail = null;
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return tail.getNext().getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	public void rotate() {
		if (!isEmpty()) {
			tail = tail.getNext();
		}
	}

	public void addFirst(E e) {
		if (isEmpty()) {
			tail = new Node<E>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<E>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}

	public void addLast(E e) {
		addFirst(e);
		rotate();
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		Node<E> head = tail.getNext();
		if (length() == 1) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}

	public String toString() {
		String result = length() + ":[";
		if (!isEmpty()) {
			Node<E> p = tail.getNext();
			for (int count = 0; count < length(); p = p.getNext(), count++) {
				result += p.getElement();
				if (count < length() - 1) {
					result += ", ";
				}
			}
		}
		result += "]";
		return result;
	}
}