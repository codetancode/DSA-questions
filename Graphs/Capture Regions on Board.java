public class Solution {
    // O(n*n, n*n) n*n for traversing over given matrix and n*n for space of visited 2d
    //idea is to check all the boundries first, if O found do dfs from that point and mark O regions as some other char '?'
    //now do simple traversal over the matrix and make '?' as 'O', rest all as 'X'

    //for checking bottom, top, right left of the current cell
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	void checkForOAtBoundry(int cellI, int cellJ, ArrayList<ArrayList<Character>> actualMatrix){
        //mark visited and check all around it
        int rowBoundry = actualMatrix.size();
        int colBoundry = actualMatrix.get(0).size();
        //mark visited
        //marking these unique Os
        actualMatrix.get(cellI).set(cellJ, '?');

        //for checking bottom, top, right left
        for(int i = 0;i < 4;i++){
            int x = cellI + dx[i];
            int y = cellJ + dy[i];
            //if in boundry and is O, call dfs on such x, y
            if( x >= 0 && x < rowBoundry && y >= 0 && y < colBoundry && actualMatrix.get(x).get(y) == 'O'){
                checkForOAtBoundry(x, y, actualMatrix);
            }

        }


    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        //idea is to travel in all 4 boundries and check for O, then dfs from O, and make them any diff char, ?,
        //latter travell entire array and mark ? as O, rest all X

        int row = a.size();
        int col = a.get(0).size();

        //if O found in any boundry call dfs from there and keep marking that region as '?'
        //left boundry
        for(int i=0;i < row;i++){
            if(a.get(i).get(0) == 'O'){
                checkForOAtBoundry(i, 0, a);
            }
        }
        //right boundry
        for(int i=0;i < row;i++){
            if(a.get(i).get(col-1) == 'O'){
                checkForOAtBoundry(i, col-1, a);
            }
        }

        //top boundry
        for(int j=0;j < col;j++){
            if(a.get(0).get(j) == 'O'){
                checkForOAtBoundry(0, j, a);
            }
        }
        //bottom boundry
        for(int j=0;j < col;j++){
            if(a.get(row-1).get(j) == 'O'){
                checkForOAtBoundry(row-1, j, a);
            }
        }

        for(int i=0;i < row;i++){
            for(int j=0;j < col;j++){
                //now just mark ? as O and rest all as X
                if(a.get(i).get(j) == '?'){
                    a.get(i).set(j, 'O');
                }else{
                    a.get(i).set(j, 'X');
                }

            }
        }

	}
}
