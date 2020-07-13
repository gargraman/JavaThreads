package collections.trees;

public class TreeUtil {
	
	public static Node<Integer> generateIntegerTree(){
		Node<Integer> n1 = new Node<Integer>();
		
		n1.left=getNode(18);
		n1.right=getNode(12);
		return n1;
	}
	
	private static Node<Integer> getNode(Integer a){
		Node<Integer> x = new Node<Integer>();
		x.value=a;
		return x;
	}

}
