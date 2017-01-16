/**
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package reverseLinkedList;

import java.util.Stack;

/**
 * @author alvin
 *
 */

import dataStructureHelper.ListNode;
public class Solution {
	public static ListNode reverseList(ListNode head) {
		if(head == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode toAdd = head;
        while(toAdd != null){
        	stack.push(toAdd);
        	toAdd = toAdd.next; 
        }
        head = stack.pop();
        ListNode tmp = head;
        while(!stack.isEmpty()){
            ListNode next = stack.pop();
            tmp.next = next;
            tmp = tmp.next;
        }
        tmp.next = null;//we have to manually set the last node's next node is null, OW Java will be stuck.
        return head;
    }
	
	public static ListNode reverseList2(ListNode head){
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null){
			ListNode nextNode = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nextNode;
		}
		return pre;
	}
	
	
	
	public static void main(String[] args){
		ListNode test = new ListNode(5);
		test.next= new ListNode(7);
		test.next.next = new ListNode(2);
		test.next.next.next = new ListNode(1);
		
		test.printList();
		ListNode newTest = reverseList2(test);
		newTest.printList();
	}
}
