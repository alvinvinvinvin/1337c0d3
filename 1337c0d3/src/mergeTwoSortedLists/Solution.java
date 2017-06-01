/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
package mergeTwoSortedLists;
import dataStructureHelper.*;
/**
 * @author han.chen
 *
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode new_head;
        int n1 = l1.val;
        int n2 = l2.val;
        if(n1>n2){
            new_head = l2;
            new_head.next = mergeTwoLists(l1, l2.next);
        }else{
            new_head = l1;
            new_head.next = mergeTwoLists(l1.next, l2);
        }
        return new_head;
    }
}
