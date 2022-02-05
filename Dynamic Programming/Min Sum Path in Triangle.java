public class Solution {
    //top to bottom approach
    // O(n*n, 1)(traversing all emenent, and using given input for space so 1)
    //idea is to go either top to bottom, adding up min() path cost in rows(topback and top),
    // for last element top doesnot exist, add opback only
    // in the end get minimum of last row
	// [   1 int 0th row is topback for 2 in next row, top for 1 in next row
    //     [1] notop for 2 in next row
    //     [1, 2] notop for 3 in next row
    //     [1, 2, 3]
    // ]

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int minCost = Integer.MAX_VALUE;
        //fix 1st column in all rows
        for(int row=1;row < a.size();row++){
            a.get(row).set(0, a.get(row-1).get(0)+a.get(row).get(0));
        }

        // now starting from 1stindex row and 1st index col for all rows
        for(int row=1;row < a.size();row++){
            for(int col=1;col < a.get(row).size();col++){
                int topBack = a.get(row-1).get(col-1);
                int curr = a.get(row).get(col);
                 //all elements in row except last element will have top in prev row
                if(col < a.get(row).size()-1){
                    int top = a.get(row-1).get(col);
                    //set minimum sum, from top and topBack
                    a.get(row).set(col, Math.min( curr + topBack, curr + top));

                }else{
                //last element of next row will not have top element in previous row
                // so just add topBack
                    a.get(row).set(col, curr + topBack);
                }
            }
        }
        // minimum cost in last row
        for(int col=0;col < a.get(a.size()-1).size();col++){
            minCost = Math.min(minCost, a.get(a.size()-1).get(col));
        }

        return minCost;
	}
}
