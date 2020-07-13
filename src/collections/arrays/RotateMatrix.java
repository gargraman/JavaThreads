package collections.arrays;

public class RotateMatrix {
	
	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{12,14,15,16}};
		printMatrix(input);
		System.out.println("");
		System.out.println("");
		printMatrix(rotateMatrix(input));
		
		
	}
	
	private static void printMatrix(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(" "+arr[i][j]);
			}
			System.out.println("");
		}
	}
	
	private static int[][] rotateMatrix(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int[][] rarr= new int[cols][rows];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				rarr[j][i]=arr[i][j];
			}
		}
		return rarr;
	}

}
