public class Solution {
    //O((n+m)logn, n+m) for sorting edges by weights and storing them
    //idea is to consider vertical and horizontal edges, sort them by weight,
    // and keep adding the cost based on if its a vertical edges or horizontal edge
    //if its a vertical edge, we can use it for columnstimes
    //if its a horizontal edge, we can use it for row times.
    //total edges to connect n+1 row and col+1 cities, is (n+1)*(col+1)-1 edges
    class EdgeWeight{
        boolean isVertical;
        int w;
        EdgeWeight(boolean isV, int w){
            this.isVertical = isV;
            this.w = w;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    long row = A.size();
    long col = B.size();
    long cost = 0;

    ArrayList<EdgeWeight> totalWEdge = new ArrayList<EdgeWeight>();
    //fill vertical edges
    for(int i=0;i < row;i++){
        totalWEdge.add(new EdgeWeight(true, A.get(i)));
    }
    //fill horizontal edge
    for(int i=0;i < col;i++){
        totalWEdge.add(new EdgeWeight(false, B.get(i)));
    }
    //as we have n+1 and m+1 cities
    //total edges to connect row+1, and col+1 will be (row+1)*(col+1)-1
    row++;
    col++;
    long totalEdges = row*col-1;

    totalWEdge.sort((a, b)->Integer.compare(a.w, b.w));

    int i=0;
    long mod = 1000000007;
    // till we fill all the edges, so
    while(totalEdges > 0){
        //get smallest edge
        EdgeWeight small = totalWEdge.get(i);
        //if vertical
        if(small.isVertical){
            //add col times its cost, for all col edges(as it would be same)
            cost = (cost + col*(small.w))%mod;
            //as we have added col times edges so reducing from total edges count
            totalEdges-=col;
            //as one element will be overlapping so reducing 1 row count
            row--;
        }else{
            //add row times its cost, for all row edges(as it would be same)
            cost = (cost + row*(small.w))%mod;
            //as we have added row times edges so reducing from total edges count
            totalEdges-=row;
            //as one element will be overlapping so reducnig 1 col count
            col--;
        }

        i++;
    }

    return (int)cost;
    }
}
