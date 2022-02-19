public class Solution {
    //O(n*m, n*m)
    //idea is to have a time state 2d array to keep track of rotten orrange(rotten =0, all else -1), then fill all rotten coordinatess into Queue
    //Multi Source BFS algo., increase time after every level, lvl trav. using lvlsize variable for bfsq.
    //take out a pair if its time ==-1(not taken already in timeState) then check its neighbour for 1(fresh orange), push that pair in bfs q
    //after the bfs q is empty, traverse the given 2 d array checking if a fresh orange coordinates has time -1 in timeState, if yes return impossible
    //else return max of timeState 2 d array
    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    //just debug function
    static void show2d(ArrayList<ArrayList<Integer>> A){
        System.out.println("[ ");
        for(int i=0;i < A.size();i++){
            System.out.print("[ ");
            for(int j=0;j < A.get(0).size();j++){
                System.out.print(A.get(i).get(j)+", ");
            }
            System.out.println(" ]");
        }
        System.out.println(" ]");
    }

    //check surrounding of rotten , if that has a fresh orange and corresponding timeState is -1(not seen) then add in bfsQ
    void checkAround(Pair rotten, ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> timeState, Queue<Pair> bfsQ, int time){
        // check top down left and right making sure its within the limit of array
        int top = rotten.i - 1;
        int down = rotten.i + 1;
        int left = rotten.j - 1;
        int right = rotten.j + 1;
        //top of rotten check
        if(top >= 0 && A.get(top).get(rotten.j) == 1){
            if(timeState.get(top).get(rotten.j) == -1){
                bfsQ.add(new Pair(top, rotten.j));
                timeState.get(top).set(rotten.j, time);
            }
        }
        //down of rotten check
        if(down < A.size() && A.get(down).get(rotten.j) == 1){
            if(timeState.get(down).get(rotten.j) == -1){
                bfsQ.add(new Pair(down, rotten.j));
                timeState.get(down).set(rotten.j, time );
            }
        }
        //left of rotten check
        if(left >= 0 && A.get(rotten.i).get(left) == 1){
            if(timeState.get(rotten.i).get(left) == -1){
                bfsQ.add(new Pair(rotten.i, left));
                timeState.get(rotten.i).set(left, time );
            }
        }
        //right of rotten check
        if(right < A.get(0).size() && A.get(rotten.i).get(right) == 1){
            if(timeState.get(rotten.i).get(right) == -1){
                bfsQ.add(new Pair(rotten.i, right));
                timeState.get(rotten.i).set(right, time );
            }
        }

    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> timeState = new ArrayList<ArrayList<Integer>>();
        Queue<Pair> bfsQ = new LinkedList<>();
        int row = A.size();
        int col = A.get(0).size();

        //fill timeState with arrays same as A
        for(int i=0;i < row;i++){
            timeState.add(new ArrayList<>(Collections.nCopies(col, 0)));
        }

        //fill time state 2d array
        for(int i=0;i < row;i++){
            for(int j=0;j < col;j++){
                if(A.get(i).get(j) == 2){
                    //at time t=0, take up all rotten in bfs Q
                    bfsQ.add(new Pair(i, j));
                    //mark rotten as at 0 time
                    timeState.get(i).set(j, 0);
                }else{
                    //all empty or fresh as -1(not seen)
                    timeState.get(i).set(j, -1);
                }
            }
        }
        //for ist we filled time at 0 for rotten, now t = 1
        int t=1;
        int lvlSize = bfsQ.size();

        //till q has some after each lvl increase time
        while(!bfsQ.isEmpty()){
            lvlSize = bfsQ.size();
            while(lvlSize > 0){
                Pair rotten = bfsQ.poll();
                checkAround(rotten, A, timeState, bfsQ, t);
                lvlSize--;
            }
            //for every lvl time increase
            t++;
        }

        //check if there is a un seen(timeState = -1) fresh orange(A = 1)
        t=0;
        for(int i=0;i < row;i++){
            for(int j=0;j < col;j++){
                //1 in A and -1 in timeState for same orange then impossible to have all rotten orange
                if(A.get(i).get(j) == 1 && timeState.get(i).get(j) == -1){
                    return -1;
                }
                //keep max time
                t=Math.max(t, timeState.get(i).get(j));
            }
        }
        return t;
    }
}
