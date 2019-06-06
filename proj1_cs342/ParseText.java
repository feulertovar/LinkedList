/**
 * 
 */
package proj1_cs342;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author feuler tovar parser for text file search through linked list for text
 *         display information relevant to found text
 */
public class ParseText {

	/**
	 * 
	 */
	public ParseText() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * parse text file filter each word and remove all non-alphanumeric characters
	 * display information relevant to found text
	 */
	public LinkedList buildList(String filename) {
		LinkedList myList = new LinkedList();

		try {

			// read text file into scanner
			Scanner scan = new Scanner(new File(filename));
			String strword;
			int curCount = 0;

			while (scan.hasNext()) {
				// filter word before adding to List
				// Only letters & numbers
				// all lower case
				// EXtra Character's should be eaten
				strword = scan.next();
				strword = filterWord(strword);

				// check list to see if word already exist
				// update instance count to it exist
				// add word to the Linked List if it does not exist
				Node ns = new Node();
				ns = myList.search(strword);

				if (ns != null) {
					curCount = ns.getInstance() + 1;
					ns.setInstance(curCount);
					// check for word made of blank spaces
					// do not add to the list if found
				} else if (!strword.equals("")) {
					myList.addToHead(strword);
				}

			}
		} catch (IOException e) {
			System.out.println("Error accessing input file!");
		}
		
		return myList;
	}

	/**
	 * filer each word for non a-z or 0-9 characters
	 */
	public String filterWord(String strword) {

		// filter letter and numbers
		strword = strword.replaceAll("[^a-zA-Z0-9]", "");
		// make all lower case
		strword = strword.toLowerCase();

		return strword;
	}

	/**
	 * query linked list for given text store information in data model display
	 * information in console
	 */
	public QueryData queryList(QueryData data, LinkedList list) {

		// How times do the following words appear in the linked list:
		// a. portrait b. persian c. dorian d. experimental e. magnetic
		data.setCntportrait(wordInstances("portrait", list));
		data.setCntpersian(wordInstances("persian", list));
		data.setCntdortian(wordInstances("dorian", list));
		data.setCntexperimental(wordInstances("experimental", list));
		data.setCntmagnetic(wordInstances("magnetic", list));
		data.setListCount(list.size());
		data.setStrFrequent(getMostFrequent(list));
		data.setStrLongest(getLongest(list));

		// display answers determined above
		System.out.println("portrait appears = " + data.getCntportrait());
		System.out.println("persian appears = " + data.getCntpersian());
		System.out.println("dorian appears = " + data.getCntdorian());
		System.out.println("experimental appears = " + data.getCntexperimental());
		System.out.println("magnetic appears = " + data.getCntmagnetic());

		// How many entries are in the linked list.
		System.out.println("");
		System.out.println("number of word entries = " + list.getCount());
		System.out.println("Most frequent occurring word is  = " + data.getStrFrequent().getData() + "("
				+ data.getStrFrequent().getInstance() + ")");
		System.out.println("Longest word is = " + data.getStrLongest().getData());
		System.out.println("Word before irritating is = " + list.search("irritating").getNext().getData());
		System.out.println("Total words found is = " + getTotalWords(list));
		System.out.println("");

		// call getMoreThanTwenty here
		getMoreThanTwenty(list);

		return data;
	}

	/**
	 * determine the instances of a given word of linked list return count
	 */
	public int wordInstances(String word, LinkedList mylist) {
		LinkedList list = new LinkedList(mylist);

		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			Node nor = list.search(word);
			if (nor != null) {
				count = nor.getInstance();
				if (nor.getNext() != null) {
					list.setHead(nor.getNext());
				}
			}

		}
		return count;

	}

	/**
	 * determine the words that have more than 20 instances in the linked list
	 * return the nodes
	 * 
	 * @return
	 */
	public void getMoreThanTwenty(LinkedList list) {
		LinkedList tmpList = new LinkedList(list);
		Node[] nodes = new Node[1000];
		int count = 0;

		// loop though list and get words that have more than 20 instances
		// add to a list array and return
		for (int i = 0; i < tmpList.size(); i++) {
			Node nor = tmpList.getHead();
			if (nor != null) {
				//
				if (nor.getInstance() > 20) {

					nodes[count] = nor;
					count += 1;
				}
				//
				if (nor.getNext() != null) {
					tmpList.setHead(nor.getNext());
				}
			}
		}

		System.out.println("Number of Words with more than 20 instances = " + count);

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				System.out.println(nodes[i].getData() + "(" + nodes[i].getInstance() + ")");
			}
		}
	}

	/**
	 * determine the word used most frequently in the linked list return its node
	 */
	public Node getMostFrequent(LinkedList list) {
		LinkedList tmpList = new LinkedList(list);
		Node topnode = new Node();

		// loop though list and get the most frequent occurring word
		// return its node
		for (int i = 0; i < list.size(); i++) {

			if (tmpList.getHead().getNext() != null) {
				//
				if (tmpList.getHead().getInstance() > tmpList.getHead().getNext().getInstance()) {
					topnode = tmpList.getHead();
				} else {
					topnode = tmpList.getHead().getNext();
				}
				//
				if (tmpList.getHead().getNext() != null) {
					tmpList.setHead(tmpList.getHead().getNext());
				}
			}

		}
		return topnode;
	}

	/**
	 * determine the longest word used in the linked list return its node
	 */
	public Node getLongest(LinkedList list) {
		LinkedList tmpList = new LinkedList(list);

		Node topnode = new Node();

		if (tmpList.getHead().getNext() != null) {
			//
			int max = 0;

			for (Node node = tmpList.getHead(); node != null; node = node.getNext()) {
				if (node.getData().length() > max) {
					max = node.getData().length();
					topnode = node;
				}
			}
		}

		return topnode;
	}

	/**
	 * determine the total word count in the linked list return total
	 */
	public int getTotalWords(LinkedList list) {
		LinkedList tmpList = new LinkedList(list);

		int total = 1;

		if (tmpList.getHead().getNext() != null) {
			//
			for (Node node = tmpList.getHead(); node != null; node = node.getNext()) {
				total = total + node.getInstance();
			}
		}
		return total;
	}

}
