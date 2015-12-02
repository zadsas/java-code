import java.util.*;

public class ListImpl{


	public static void main(String[] args){

		//This does not work because the method 'addFirst()' is not declared in the interface 'List'
		//List<Integer> list = new LinkedList<Integer>();

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(2);
		list.addFirst(1);


	}



}
