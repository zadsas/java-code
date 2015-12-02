import static java.lang.System.*;

public class Strings{


	public static String getString1(){
		return "string 1";
	}

	public static String getString2(){
		return new String("string 1");
	}

	public static void main(String[] args){

	
		String s1 = "string 1";
		String s2 = "string 1";

		if(s1==s2) out.println("s1 and s2 point to the same object");
		else out.println("s1 and s2 do not point to the same object");


		String s3 = new String("string 1");
		String s4 = new String("string 1");

		if(s3==s4) out.println("s3 and s4 point to the same object");
		else out.println("s3 and s4 do not point to the same object");

		String s5 = getString1();
		if(s1==s5) out.println("s1 and s5 point to the same object");
		else out.println("s1 and s5 do not point to the same object");

		String s6 = getString2();
		if(s1==s6) out.println("s1 and s6 point to the same object");
		else out.println("s1 and s6 do not point to the same object");

	}


}
