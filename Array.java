import static java.lang.System.*;
import java.util.*;

public class Array{

	public static void main(String[] args){ 

		
		int[] array = {1,1,1,2,4,5,5,6,6,6,7,8,10};
		for(int i: array) out.print(i + " ");
		out.println();
		
		//Eliminate duplicates and consecutives in a step

		int i=0;
		boolean step = false;		
		List<Integer> list = new LinkedList<Integer>();

		while(i<array.length){
			
			if(!step) list.add(array[i]);
			
			while(i!=array.length-1 && array[i]==array[i+1]) i++;
			
			if(i<array.length-1 && array[i]+1==array[i+1]) step=true;
			else step=false;
	
			i++;
				
		}

		for(Integer j: list) out.print(j + " ");
		out.println();
		
		
	}

}
