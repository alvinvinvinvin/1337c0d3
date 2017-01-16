package dataStructureHelper;

public class ListNodeTemplate<T> {
	private ListNodeTemplate<T> next;
	private T data;
	public ListNodeTemplate(T value){
		data = value;
	}
	public T getValue(){
		return data;
	}
	public ListNodeTemplate<T> getNext(){
		return next;
	}
	public void setValue(T value){
		data = value;
	}
	public void setNext(ListNodeTemplate<T> nextNode){
		next = nextNode;
	}
	/*
	 * Hint: You can use old head pointer to handle the returned new head,
	 * therefore, to update the head node.
	 */
	public ListNodeTemplate<T> insertNewHead(ListNodeTemplate<T> oldHead, T value){
		ListNodeTemplate<T> newHead = new ListNodeTemplate<T>(value);
		newHead.setNext(oldHead);
		return newHead;
	}
	
	/*
	 * For traversing list, don't forget to check whether you reach the end of the list.
	 */
	public ListNodeTemplate<T> findNode(ListNodeTemplate<T> startPoint, T value){
		while(startPoint!= null && startPoint.getValue() != value){
			startPoint = startPoint.getNext();
		}
		return startPoint;
	}
	
	public void insertNode(ListNodeTemplate<T> insertedOne){
		ListNodeTemplate<T> oldNext = next;
		next = insertedOne;
		insertedOne.setNext(oldNext);
	}
	
	public ListNodeTemplate<T> deleteFirstMatchingNode(ListNodeTemplate<T> head, T value){
		ListNodeTemplate<T> ref = head;
		if(ref.getValue() == value){
			return ref.getNext();
		}
		while(ref != null){
			if(ref.getNext().getValue() == value){
				ref.setNext(ref.getNext().getNext());
				return head;
			}
			ref = ref.getNext();
		}
		return head;
	}
	
}
