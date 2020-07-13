package numbers;

import java.util.HashSet;
import java.util.Set;

/*
 * Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"

 */
public class DigitSequence {

	public static void  main(String[] arg) {
		char[] num="1234".toCharArray();
		Set<String> out = new HashSet<>();
		int A='A'-1;
		int Z='Z';
		String str = "";
		for(char c : num) {
			str += convertToChar(c,'0');
		}
		out.add(str);
		System.out.print(str);
	}
	
	private static String convertToChar(char numChar1, char numChar2) {
		int ic1= 'A' -1 + Integer.parseInt(numChar1+"");
		if(numChar2!='0') {
			int ic2= 'A' -1 + Integer.parseInt(numChar1+""+numChar2);
			if( ic2 <= 'Z') {
				char out = (char)(ic2);
				return out+"";
			}else {
				return (char)ic1+""+(char)('A' -1 + Integer.parseInt(numChar2+""));
			}
		}
		
		return (char)ic1 +"" ;
	}
}
