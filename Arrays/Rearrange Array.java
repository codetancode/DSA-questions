import java.lang.*;
import java.util.*;
import java.util.Collections;

public class Solution {
	//O(n, 1)
	//idea is to make a value represent 2 values by * by n and adding <n numbers, finally make them as %n(their true value)
    //idea is similar to 24 hour clock timings, 1 value represents 2 values by { *(big number) and + (less than big number)}
	public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        //setting all values as val*n
		for(int i=0;i < n;i++){
            A.set(i, A.get(i)*n);
        }
		//now setting thoses values as val + (val to replace/n)
        for(int i=0;i < n;i++){
            A.set(i, A.get(i)+A.get(A.get(i)/n)/n);
        }
        for(int i=0;i < n;i++){
			//finally %n will give their true values
            A.set(i, A.get(i)%n);
        }

    }
}
