class Obj{

	private int a;

	Obj(int a){
		System.out.println("Constructing Obj");	
		this.a=a;
	}

	public int getA(){return a;}

	public void setA(int a){this.a=a;}

}



public class StaticFinalObject{

	//Static means that the variable can be accessed without any object because it belongs to the class
	//Static does not mean that the static variable cannot be changed
	//Try to add final to the variable and remove /**/. The final refers to the reference, not to the object
 	static Obj o;

	static{
		o = new Obj(3);
	}

	public static void main(String[] args){

		
		System.out.println("Main");

		System.out.println(o.getA());

		changeValue(o);

		System.out.println(o.getA());

		StaticFinalObject.o = new Obj(0); /**/

		System.out.println(o.getA());
		

	}

	private static void changeValue(Obj o){
		
		System.out.println("Changing");	

		System.out.println(o.getA());	

		o.setA(2);
		
		System.out.println(o.getA());	

		//Allocates space for a new object and return the reference to a local variable, the old object still lives with the other reference and is not erased
		o = new Obj(1);

		System.out.println(o.getA());
	}
}
