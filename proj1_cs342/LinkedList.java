/**
 * 
 */
package proj1_cs342;

/**
 * @author feuler
 *
 *         linked list
 */
public class LinkedList {


	private Node head;
	private int count;

	/**
	 * constructor
	 */
	public LinkedList() {
		head = null;
		count = 0;
	}

	/**
	 * copy constructor
	 */
	public LinkedList(LinkedList list) {
		this.head = list.head;
		this.count = list.count;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * add to head of list
	 */
	public void addToHead(String data) {
		Node ng = new Node();
		ng.setData(data);

		ng.setNext(head);

		head = ng;
		count++;
		return;
	}

	/**
	 * search list for given data, start from head
	 * returns Node of data
	 */
	public Node search(String data) {

		Node tmp = head;

		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				break;
			}
			tmp = tmp.getNext();
		}
		return tmp;
	}

	private class PrevCur {
		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getCur() {
			return cur;
		}

		public void setCur(Node cur) {
			this.cur = cur;
		}

		private Node prev;
		private Node cur;
	}

	/**
	 * previous current search list for given data,
	 * returns PrevCur Object
	 */
	public PrevCur prevCurSearch(String data) {
		PrevCur n = new PrevCur();

		n.setPrev(null);
		n.setCur(head);

		while (n.getCur() != null) {
			if (n.getCur().getData().equals(data)) {
				return n;
			}

			n.setPrev(n.getCur());
			n.setCur(n.getCur().getNext());
		}

		return n;

	}

	/**
	 * search for given data
	 * add new data before given data, 
	 */
	public void addBefore(String abData, String newData) {
		PrevCur s = this.prevCurSearch(abData);
		if (s.getCur() == null) {
			// means data to add before does not exist
			return;
		}

		// see if we need to add to new head
		if (s.getPrev() == null) {
			addToHead(newData);
			return;

		}

		// Add elsewhere in the list
		Node n = new Node();
		n.setData(newData);
		n.setNext(s.getCur());
		s.getPrev().setNext(n);
		count++;
	}

	/**
	 * search for given data
	 * add new data after given data, 
	 */
	public void addAfter(String aaData, String newData) {

		Node addAfter = search(aaData);

		// if the data to add after doesn't exist in the list, just return
		if (addAfter == null) {
			return;
		}

		Node n = new Node();
		n.setData(newData);

		n.setNext(addAfter.getNext());
		addAfter.setNext(n);
		count++;

	}

	/**
	 * delete given data from head
	 * advance head to next node, 
	 */
	public void deleteFromHead(String aaData, String newData) {

		//
		if (head == null) {
			return;
		}

		head = head.getNext();
		count--;

	}

	/**
	 * search for given data
	 * remove data after given data, 
	 */
	public void deleteAfter(String data) {
		PrevCur s = prevCurSearch(data);

		if ((s.getCur() == null) || (s.getCur().getNext() == null)) {
			// not found
			return;
		}

		s.getCur().setNext(s.getCur().getNext().getNext());
		count--;
	}

	/**
	 * search for given data
	 * remove data once found
	 */
	public void delete(String data) {
		PrevCur s = prevCurSearch(data);

		if (s.getCur() == null) {
			// not found
			return;
		}

		if (s.getPrev() == null) {
			// head of list

			head = head.getNext();
			count--;
			return;
		}

		// general purpose delete
		s.getPrev().setNext(s.getCur().getNext());
		count--;
	}

	// Implement
	public void deleteBefore(String data) {

	}

	/**
	 * 
	 * toString override
	 */
	public String toString() {
		String rtn = "";

		if (head == null) {
			return "<Empty>";
		}

		Node tmp = head;

		while (tmp != null) {
			rtn += "<" + tmp.getData() + "(" + tmp.getInstance() + ")" + ">";
			tmp = tmp.getNext();
			if (tmp != null) {
				rtn += " -> ";
			} else {
				rtn += " -> null";
			}

		}
		return rtn;
	}

	public int size() {
		return getCount();
	}

}
