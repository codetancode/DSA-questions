public class Solution {
    //O(n+e, n*n) basic BFS, n*n for visited 2d boolean matrix
    //all possible steps from a given i, j point
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    //pair of point/steps
    class Pair{
        int i;
        int j;
        //distance or steps taken so far, stored into a point
        int distance;
        Pair(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.distance = k;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        //  bfs On Possible Step of knight from i, j
        //visited 2d boolean
        ArrayList<ArrayList<Boolean>> vistedMatrix = new ArrayList<ArrayList<Boolean>>();
        for(int i=0;i < A;i++){
            vistedMatrix.add(new ArrayList<>(Collections.nCopies(B, false)));
        }
        //bfsQ for storing all possible steps from a given pair(point)
        Queue<Pair> bfsQ = new LinkedList<>();
        //0 based indexing, storing starting point pair with steps/distance 0
        bfsQ.add(new Pair(C-1, D-1, 0));

        //normal bfs loop for checking points
        while(!bfsQ.isEmpty()){
            Pair popOut = bfsQ.poll();
            int x = popOut.i;
            int y = popOut.j;
            int dist = popOut.distance;
            //if target found return this points dist
            if(x == E-1 && y == F-1){
                return dist;
            }
            //if already visited then continue
            if(vistedMatrix.get(x).get(y)){
                continue;
            }
            //if not visited then, mark visited
            vistedMatrix.get(x).set(y, true);

            // add all possible 8 steps from current point into bfsQ
            for(int i = 0;i < 8;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //if points in the boundry
                if(nx >= 0  && nx < A && ny >=0 && ny < B){
                    //as 1 step so prev dist + 1, for next step
                    bfsQ.add(new Pair(nx, ny, dist + 1));
                }
            }
        }

        // if not reached target then return -1
        return -1;
    }
}
