package proj1_cs342;

/**
 * @author feuler tovar
 * data model to hold query search of linked list
 * search through linked list and store data here
 */
public class QueryData {

	public QueryData() {
		// TODO Auto-generated constructor stub
	}
	
	private int cntportrait = 0;
	private int cntpersian = 0;
	private int cntdorian = 0;
	private int cntexperimental = 0;
	private int cntmagnetic = 0;
	private int listCount = 0;
	private Node strFrequent;
	private Node strLongest;
	private Node strBeforeIrrating;

	public int getCntportrait() {
		return cntportrait;
	}


	public void setCntportrait(int cntportrait) {
		this.cntportrait = cntportrait;
	}


	public int getCntpersian() {
		return cntpersian;
	}


	public void setCntpersian(int cntpersian) {
		this.cntpersian = cntpersian;
	}


	public int getCntdorian() {
		return cntdorian;
	}


	public void setCntdortian(int cntdorian) {
		this.cntdorian = cntdorian;
	}


	public int getCntexperimental() {
		return cntexperimental;
	}


	public void setCntexperimental(int cntexperimental) {
		this.cntexperimental = cntexperimental;
	}


	public int getCntmagnetic() {
		return cntmagnetic;
	}


	public void setCntmagnetic(int cntmagnetic) {
		this.cntmagnetic = cntmagnetic;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public Node getStrFrequent() {
		return strFrequent;
	}


	public void setStrFrequent(Node node) {
		this.strFrequent = node;
	}


	public Node getStrLongest() {
		return strLongest;
	}


	public void setStrLongest(Node strLongest) {
		this.strLongest = strLongest;
	}


	public Node getStrBeforeIrrating() {
		return strBeforeIrrating;
	}


	public void setStrBeforeIrrating(Node strBeforeIrrating) {
		this.strBeforeIrrating = strBeforeIrrating;
	}
	
}
