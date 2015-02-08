
public class Application {
	
	public static StackWithLinkedList stackLL= new StackWithLinkedList ();
	public static StackWithArray stackAry= new StackWithArray ();
	
	public static void showStacksStatus (){
		System.out.println("LL " + stackLL.toString());
		System.out.println("Ary" + stackAry.toString());
	}
	
	public static void main (String [] args){
		System.out.println("This is my Stack program");

		if (stackLL.isEmpty()){
			stackLL.toString();
			System.out.println("LL is empty");
		}
		if (stackAry.isEmpty()){
			stackAry.toString();
			System.out.println("Ary is empty");
		}
		
		showStacksStatus();
		
		stackAry.push(10);
		stackLL.push(10);
		
		showStacksStatus();
		System.out.println (stackAry.pop());
		System.out.println (stackLL.pop ());
		showStacksStatus();
		
		stackAry.push(9);
		stackLL.push(9);
		showStacksStatus();
		stackAry.push(9);
		stackLL.push(9);
		showStacksStatus();
		
		for (int i = 0 ; i < 8 ; i ++){
			stackAry.push(i);
			stackLL.push(i);
			showStacksStatus();
		}
		
		System.out.println (stackAry.pop());
		System.out.println (stackLL.pop ());
		showStacksStatus();
		
		stackAry.push(100);
		stackLL.push(100);
		showStacksStatus();
		
		System.out.println (stackAry.pop());
		System.out.println (stackLL.pop ());
		showStacksStatus();
		
		for (int i = 0 ; i < 8 ; i ++){
			stackAry.push(i);
			stackLL.push(i);
			showStacksStatus();
		}
		
		for (int i = 0 ; i < 18 ; i ++){
			stackAry.pop();
			stackLL.pop();
			showStacksStatus();
		}
		
		
	}
}
