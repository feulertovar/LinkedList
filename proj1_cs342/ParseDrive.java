/**
 * 
 */
package proj1_cs342;

/**
 * @author feuler tovar
 *
 *         driver for Linked List text parser project
 */
public class ParseDrive {

	public ParseDrive() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParseDrive myParse = new ParseDrive();
		myParse.doIt();
	}

	/**
	 * input text from file parse text file for relevant information
	 */
	public void doIt() {

		// instantiate new linked list
		LinkedList list = new LinkedList();

		// text file stored locally
		String filePath = "pg174.txt";

		// new parser
		ParseText prs = new ParseText();

		// Build Linked List from text file
		list = prs.buildList(filePath);

		// Query Linked List and get relevant data
		QueryData data = new QueryData();
		data = prs.queryList(data, list);
	}

}
