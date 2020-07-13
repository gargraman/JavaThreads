package collections.trees;

public class ValidateBST {
	public static void main(String[] args) {
		Node<Integer> root = TreeUtil.generateIntegerTree();
		System.out.println(isValid(root));
	}

	private static boolean isValid(Node<Integer> root) {
		if(root==null) {
			return true;
		}
		
		if(root.left!=null) {
			if(root.left.value>=root.value){
				return false;
				
			}
		}
		if(root.right!=null) {
			if(root.right.value<root.value){
				return false;
			}
		}
		
		return isValid(root.left) && isValid(root.right);
		
	}

}
