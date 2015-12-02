import static java.lang.System.*;


public class Arabic2Roman{

	public static void main(String[] args){ //args[0]: number in arabic

		int arabic = Integer.parseInt(args[0]);
		
		String roman = "";

		int i = 0;

		int[] value = {1000,500,100,50,10,5,1};
		char[] symbol = {'M','D','C','L','X','V','I'};

		while(i<symbol.length && arabic!=0){

			int ratio = arabic/value[i];
	
			if(ratio==4){
				if(symbol[i-1]=='V' || symbol[i-1]=='L' || symbol[i-1]=='D'){
					roman = roman.substring(0,roman.length()-1);
					roman += symbol[i];
					roman += symbol[i-2];
					arabic -= (value[i-2]-value[i]-value[i-1]);
				}
				else{	
					roman += symbol[i];
					roman += symbol[i-1];
					arabic -= (value[i-1]-value[i]);
				}
			}else if(ratio>=1){
				for(int s=0;s<ratio;s++){
					roman += symbol[i];
					arabic -= value[i];
				}
			}
			
			i++;

		}
		
		out.println("Arabic: " + arabic);
		out.println("Roman: " + roman);
		
		
	}

}
