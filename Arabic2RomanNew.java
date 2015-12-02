import static java.lang.System.*;
import static java.lang.Math.*;


public class Arabic2RomanNew{

	public static void main(String[] args){ //args[0]: number in arabic

		int arabic = Integer.parseInt(args[0]);
		
		String roman = "";

		int i = 0;

		int[] value = {1000,500,100,50,10,5,1};
		char[] symbol = {'M','D','C','L','X','V','I'}; 

		//Only M,C,X or I can be repeated, but this it guaranteed because of the order reading the array
		//Checking multiples of 4 and 9 guarantees that only I,X and C will substract

		while(arabic!=0){

			int ratio = arabic/value[i];

			if(ratio==0){
				i++;
				continue;
			}

			if(ratio==4){
				roman += ("" + symbol[i] + symbol[i-1]);
				arabic -= (value[i-1]-value[i]);
				i++;
			}

			else if(value[i-1]!=5 && arabic/(value[i-1]/10)==9){
				roman += ("" + symbol[i+1] + symbol[i-1]);
				arabic -= (value[i-1]-value[i+1]);
				i+=2;
			}

			else{
				/*				
				for(int s=0;s<ratio;s++){
					roman += symbol[i];
					arabic -= value[i];
				}
				i++;
				*/
				roman += symbol[i];
				arabic -= value[i];

			}


		}
		
		out.println("Roman: " + roman);
		
		
	}

}
