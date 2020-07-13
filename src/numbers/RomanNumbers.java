package numbers;

import java.util.HashMap;
import java.util.Map;

/*
 * Input : 9
Output : IX

Input : 40
Output : XL

Input :  1904
Output : MCMIV
 */
public class RomanNumbers {
	
	static Map<Integer, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		//1000 = M
		//100  = C
		//50   = L
		//10   = X
		//5    = V
		int num1 = 9;
		int num2 = 408;
		int num3 = 3549;
		map.put(1000,"M");
		map.put(500,"D");
		map.put(100,"C");
		map.put(50,"L");
		map.put(10,"X");
		map.put(5,"V");
		map.put(1,"I");
		map.put(0, "0");
		System.out.println(convert(num1));
		System.out.println(convert(num2));
		System.out.println(convert(num3));
				
	}

	private static String convert(int num1) {
		int n = num1;
		int cnt = 1;
		String ret="";
		while(n!=0) {
			int remainder = n%10;
			ret=romanChars(n, cnt,remainder)+ret;
			cnt=cnt*10;
			n=n/10;
		}
		return ret;
	}
	
	private static String romanChars(int n, int place, int rem) {
		
		String nowChar = map.get(place);
		String fiveChar = map.get(place*5);
		String nextChar = map.get(place*10);
		
		String retChar="";
		if(rem<4) {
			for(int i=0;i<rem;i++) {
				retChar+=nowChar;
			}
			
		}else if(rem==4) {
			for(int i=0;i<rem;i++) {
				retChar=nowChar+fiveChar;
			}
		}else if(rem==5) {
			retChar=fiveChar;
		}else if(rem>5 && rem<9) {
			retChar = fiveChar;
			for(int i=0;i<rem-5;i++) {
				retChar=retChar+nowChar;
			}
		}else if(rem<10){
			retChar=nowChar+nextChar;
		}
		return retChar;
		
	}
	

}
