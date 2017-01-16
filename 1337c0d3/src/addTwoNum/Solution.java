/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package addTwoNum;

import dataStructureHelper.*;
/**
 * @author alvin
 *
 */
public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode resultListNode = new ListNode(0);
		ListNode pointerNode = resultListNode;
		while(l1 != null || l2 != null){
			//Get tens of sum from previous step.
			sum /= 10;
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			//Assign the digit to a new node
			//and add it to result list.
			pointerNode.next = new ListNode(sum % 10);
			pointerNode = pointerNode.next;
		}
		//If there is still a carry left.
		if(sum / 10 ==1){
			pointerNode.next = new ListNode(1);
		}
        return resultListNode.next;
    }
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		ListNode resultListNode = addTwoNumbers(l1, l2);
		printListNodes(resultListNode);
	}
	
	public static void printListNodes(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
