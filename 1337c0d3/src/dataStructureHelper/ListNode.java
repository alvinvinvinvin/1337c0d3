package dataStructureHelper;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	
	//For test
	public void printList(){
		ListNode tmp = this;
		String out = "";
		while(tmp != null){
			String comma = (tmp.next == null) ? "" : ",";
			out += tmp.val+comma;
			tmp = tmp.next;
		}
		System.out.println("["+out+"]");
	}
}
