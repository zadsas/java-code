import static java.lang.System.*;

public class Decimal2Hex{

	public static void main(String[] args){ //args[0]: number in decimal, args[1]: base

		int num = Integer.parseInt(args[0]);
		int base = Integer.parseInt(args[1]);

		int offset = 'A'-10;

		String conv = "";
		boolean end = false;

		/*
		while(num!=0){

			if(num%base>9) conv = ((char)(num%base+offset)) + conv;
			else conv = num%base + conv;
				
			num /= base;
		}*/

		//Better version: Map numbers to symbols
		char[] sym = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(num!=0){
			conv = sym[num%base] + conv;	
			num /= base;
		}

		out.println("Hex: " + conv);

		int decimal = Integer.parseInt(conv,base);
		out.println("Dec: " + decimal);
		
	}

}
