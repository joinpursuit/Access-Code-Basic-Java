import java.util.Arrays;
import java.util.NoSuchElementException;


public class StackWithArray {
		private int[] stackArray;
		private int emptyIndex; //pointing at empty usable spot;
		public StackWithArray (){
			stackArray = new int[10];
			int emptyIndex = 0;
		}
		
		public StackWithArray (int size){
			stackArray = new int[size];
			int emptyIndex = 0;
		}
		
		private void biggerArray (){
			int [] temp = new int[stackArray.length*2];
			for (int i = 0 ; i < stackArray.length; i ++){
				temp[i] = stackArray[i];
			}
			stackArray = temp;
			return;
		}
		
		public int pop(){
			if (emptyIndex == 0){
				throw new NoSuchElementException ();
			}
			else {
				return stackArray[--emptyIndex];
			}
		}
		
		public void push (int data){
			if (emptyIndex == stackArray.length){
				this.biggerArray();
			}
			stackArray[emptyIndex++] = data;
			return;
		}
		
		public boolean isEmpty(){
			return emptyIndex == 0;
		}
		
		public String toString (){
			StringBuffer sBuffer = new StringBuffer ();
			sBuffer.append("[");
			for (int i = 0 ; i <emptyIndex  ; i ++){
				if (i != 0 ){
					sBuffer.append (", ");
					sBuffer.append (stackArray[i]);
				}
				else {
					sBuffer.append(stackArray[i]);
				}
			}
			sBuffer.append("]");
			return sBuffer.toString();
		}

}
