import static java.lang.System.*;
import java.util.*;

class Movements{
	
	/*
	distances: Array with distances
	times: Array with times for each distance
	rest: Time to rest between runs
	total: Kilometers to complete by the robot
	*/
	public static void run(int[] distances, int[] times, int rest, int total){

		//Max time in the array of times
		//UpperBound of the maximum possible time given the actual distances
		int maxTime = max(times);
		int upperBound = 100*distances.length*maxTime;

		//Best time in a subproblem with 'i' kilometers
		//Initialized to '-rest' because the robot does not rest before the first run
		int[] bestTimes = new int[total+1];
		bestTimes[0] = -rest;
		
		//Array in which subproblem 'i' points to the previous subproblem 'i-X' such that 'i' bases its min on 'i-X'
		int[] bestMovements = new int[total+1];
		bestMovements[0] = -1;

		
		//minTime: Min time per subproblem
		//parent: Index of a previous subproblem such that the actual subproblem bases its min on it
		int minTime = 0;
		int parent = 0;

		//Main Loop: Track all the subproblems
		for(int i=1;i<total+1;i++){

			//Initialize these variables in order to look for the min
			minTime = upperBound;
			parent = 0;

			//Try with the previous subproblems that are reachable from the actual one
			for(int j=0;j<distances.length;j++){

				if(i-distances[j]>=0){
					int time = bestTimes[i-distances[j]]+rest+times[j];

					if(time<minTime){
						minTime = time;
						parent = i-distances[j];
					}
				}

			}
			
			//Store min time and movements for the actual subproblem
			bestTimes[i] = minTime;
			bestMovements[i] = parent;

		}

		//Output
		if(bestMovements[total]!=0 || bestMovements[total]==0 && isIn(total,distances)){
			LinkedList<Integer> dis = unravel(total, bestMovements);
			out.print("Distances: ");		
			for(Integer i: dis) out.print(i + " ");
		
			out.println("\nTime: " + bestTimes[total]);			
		}
		else
			out.println("It is not possible to cover the distance");


	}	

	//Auxiliary method to unravel the vector of subproblems pointing to the previous one
	private static LinkedList<Integer> unravel(int total, int[] bestMovements){
		
		LinkedList<Integer> order = new LinkedList<Integer>();

		int target = total;
		int origin = bestMovements[total];

		while(origin!=-1){
			order.add(0,target-origin);
			target = origin;
			origin = bestMovements[origin];
		}

		return order;

	}

	//Auxiliary method to find the max value in a vector
	private static int max(int[] v){

		int m = -1;

		for(int i=0;i<v.length;i++)
			if(v[i]>m)	
				m=v[i];

		return m;

	}

	//Auxiliary method to find if a value is in the list
	private static boolean isIn(int v, int[] array){

		for(int i=0;i<array.length;i++)
			if(v==array[i])	
				return true;

		return false;

	}

}

public class Robot{

	public static void main(String[] args){

		int[] distances = {5,6,7};
		int[] times = {7,8,9};
		int rest = 2;
		int total = 20;

		Movements.run(distances, times, rest, total);

	}
	
}
