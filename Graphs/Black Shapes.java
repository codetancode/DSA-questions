public class Solution {
    //dfs O(n+e, n)
    //simply keep dfs on nodes and markinging them visited, counting for every unvisited section as a region
    // top down left right
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // static boolean oFound = false;

    void dfs(int currI, int currJ, ArrayList<ArrayList<Character>> matrix, ArrayList<ArrayList<Boolean>> visited){
        // mark visited
        visited.get(currI).set(currJ, true);
        //travel around, if x run dfs on it and mark keep marking them visited
        for(int i=0;i < 4;i++){
            int x = currI + dx[i];
            int y = currJ + dy[i];
            if(x < matrix.size() && x >= 0 && y < matrix.get(0).size() && y >= 0 &&
            !visited.get(x).get(y) && matrix.get(x).get(y) == 'X'){
               dfs(x, y, matrix, visited);
            }
        }

    }

    public int black(ArrayList<String> A) {
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>();
        ArrayList<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();
        int count=0;
        for(int i=0;i < A.size();i++){
            visited.add(new ArrayList<>(Collections.nCopies(A.get(i).length(), false)));
            matrix.add(new ArrayList<Character>());
        }

        for(int i=0;i < A.size();i++){
            for(int j=0;j < A.get(i).length();j++){
                matrix.get(i).add(A.get(i).charAt(j));
            }
        }
        for(int i=0;i < A.size();i++){
            for(int j=0;j < A.get(i).length();j++){
                if(!visited.get(i).get(j) && matrix.get(i).get(j) == 'X'){
                    dfs(i, j, matrix, visited);
                    //if unvisited count it a section of X
                    count++;
                    }
            }
        }
        return count;
    }
}
