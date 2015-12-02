import java.util.*;
import static java.lang.System.*;

class Obj{

	public int a;

	Obj(int a){
		this.a=a;
	}
}
public class LoopCollection{

	public static void main(String [] args){

		ArrayList<String> strings = new ArrayList<String>();
		strings.add("1");
		strings.add("2");
		strings.add("3");

		for(String s:strings) out.println(s + " ");

		out.println();

		for(String s:strings) s="0";

		out.println();

		for(String s:strings) out.println(s + " ");

		out.println();
		out.println();

		///////////////////

		ArrayList<Obj> objs = new ArrayList<Obj>();
		objs.add(new Obj(1));
		objs.add(new Obj(2));
		objs.add(new Obj(3));


		for(Obj o:objs) out.println(o.a + " ");

		out.println();

		for(Obj o:objs) o.a = 0;

		out.println();

		for(Obj o:objs) out.println(o.a + " ");	

		out.println();
		out.println();

		///////////////////

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
	
		for(Integer i:list) out.println(i + " ");	
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			Integer i = (Integer)it.next();
			if(i==2) it.remove();
		}
		
		out.println();

		for(Integer i:list) out.println(i + " ");	
	} 

}

