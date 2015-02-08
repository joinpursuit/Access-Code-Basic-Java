import java.util.Arrays;
import java.util.LinkedList;

//This is easier compared with stack implementing using array
public class StackWithLinkedList {
	
	private LinkedList <Integer> linkedList;
	public StackWithLinkedList (){
		linkedList = new LinkedList<Integer>();	
	}
	
	public int pop(){
		int result = linkedList.getLast();
		linkedList.removeLast();
		return result;
	}
	
	public void push (int data){
		linkedList.add(data);
	}
	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	
	public String toString (){
		linkedList.size();
		return Arrays.toString(linkedList.toArray());
	}
}
