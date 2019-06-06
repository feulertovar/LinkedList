package proj1_cs342;

/**
 * @author feuler tovar
 *
 *         Node class for linked list 
 *         Integer for data
 */
public class Node {

	private String data;
	private Node next;
	private Integer instance;
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node() {
		// TODO Auto-generated constructor stub
		instance = 1;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getInstance() {
		return instance;
	}

	public void setInstance(Integer instance) {
		this.instance = instance;
	}

}
