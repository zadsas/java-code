import static java.lang.System.*;


public class Roman2Arabic{

	//Idea: Without considering repetitions, the value is always lower than the previous
	//Exception: Take aways are two letter grouped in a value
	public static void main(String[] args){ //args[0]: number in roman

		String roman = args[0];
		
		int arabic = 0;

		int i = 0;

		while(true){

			if(i>=roman.length()) break;

			if(i<roman.length()-1 && lessValue(roman.charAt(i+1), roman.charAt(i))){
				int aux = getValue(roman.charAt(i+1)) - getValue(roman.charAt(i));
				arabic += aux;
				i+=2;
				continue;
			}
		
			while(i<roman.length()-1 && roman.charAt(i)==roman.charAt(i+1)){
				arabic += getValue(roman.charAt(i));
				i++;
			}
			arabic += getValue(roman.charAt(i));
			
			if(i==roman.length()-1 || !lessValue(roman.charAt(i),roman.charAt(i+1))) break;

			i++;
		

		}

		out.println("Roman: " + roman);
		out.println("Arabic: " + arabic);
		
	}

	private static int getValue(char symbol){

		switch(symbol){

			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;

		}	

		return 1000;
	

	}

	private static boolean lessValue(char a, char b){

		if(getValue(b)<getValue(a)) return true;
		return false;	

	}

}
