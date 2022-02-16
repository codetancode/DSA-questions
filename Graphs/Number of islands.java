public class Solution {
    // O(n*m, n*m) best
    //idea is to imagine all connected cells as 1 island, having a 2d visited boolean array,
    // with DFS check all possible 8 cells around a land(==1) cell recursivly and mark it visited in 2d array.
    // so every time we get land not visited i.e a new island

    //gloabal ans
    static int ans = 0;
    //dfs just mark visited for different cells
    //dfs for target celli, and cell j, and check if it has any unvisited land aroung its 8 cells
    void dfs(int cellI, int cellJ, ArrayList<ArrayList<Integer>> ActualCells,  boolean[][] visitedCells ){
        //for bountry check in matrix
        int rowBoundry = ActualCells.size();
        int colBoundry = ActualCells.get(0).size();
        //marking this cell as visited
        visitedCells[cellI][cellJ] = true;

        //checking all 8 cell aroung cellI and cellJ, if in boundry, not visited and a land cell found(==1) call dfs on that cell
        for(int dx=-1;dx <= 1;dx++){
            for(int dy=-1;dy <= 1;dy++){
                int x = cellI + dx;
                int y = cellJ + dy;
                if(0 <= x && x < rowBoundry
                && 0 <= y && y < colBoundry
                && !visitedCells[x][y] && ActualCells.get(x).get(y) == 1
                )
                dfs(x, y, ActualCells, visitedCells);
            }
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        // reset global ans
        ans = 0;
        int row = A.size();
        int col = A.get(0).size();
        boolean[][] visitedCells = new boolean[row][col];
        //traversing all cells, if unvisited and a land cell found call DFS to inspect 8 surrounding cells and mark them visited
        for(int i=0;i < row;i++){
            for(int j=0;j < col;j++){
                if(!visitedCells[i][j] && A.get(i).get(j) == 1){
                    //one unvisited cell of land found so ++ island
                    ans++;
                    dfs(i, j, A, visitedCells);
                }
            }
        }

        //return starting points as every start will be an island
        return ans;
    }
}
