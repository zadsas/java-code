import static java.lang.System.*;

public class CharInt{


	//because size(int) > size(char)
	public static void main(String[] args){

		char character = 'a';

		out.println(character);

		int num = character;
		
		out.println(num);


		num = 98;

		out.println(num);
		
		character = (char)num;

		out.println(character);

	}



}
