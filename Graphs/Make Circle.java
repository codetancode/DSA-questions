public class Solution {
    //O(n+e, e) dfs, adj space of edges
    //idea is to take consider a graph from first char to last char of a string. so every string is a edge from 1st char to last char of itself
    //to form cycle number of a char in inChar(first char) == outChar(last char), so checking that
    //for Directed nodes to be connected, after dfs from 1 node all nodes must be visited

    //dfs considering 1st char of string
    void dfs(int currCharNode, ArrayList<Boolean> visited, ArrayList<ArrayList<Integer>> adjList){
        //mark 1st char(first node) visited
        visited.set(currCharNode, true);
        //go for other strings
        for(Integer adjNode : adjList.get(currCharNode)){
            if(!visited.get(adjNode)){
                dfs(adjNode, visited, adjList);
            }
        }
    }

    public int solve(ArrayList<String> A) {
        //al of al for adjlist
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Boolean> visited = new ArrayList<Boolean>(Collections.nCopies(26, false));

        //in and out char freq array
        ArrayList<Integer> IncharArr = new ArrayList<>(Collections.nCopies(26, 0));
        ArrayList<Integer> OutcharArr = new ArrayList<>(Collections.nCopies(26, 0));

        //filling adj list
        for(int i=0;i < 26;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i < A.size();i++){
            //going through the string, adding last chr at first char index
            int firstChar = A.get(i).charAt(0) - 'a';
            int lastChar = A.get(i).charAt(A.get(i).length() - 1) - 'a';
            adjList.get(firstChar).add(lastChar);

            //increase the freq of first and last chars in frq array
            IncharArr.set(firstChar, IncharArr.get(firstChar) + 1);
            OutcharArr.set(lastChar, OutcharArr.get(lastChar) + 1);
        }

        //checking if any char x has different incount and outcount
        for(int i=0;i < 26;i++){
            if(!IncharArr.get(i).equals(OutcharArr.get(i))){
                return 0;
            }
        }

        //dfs from any given input char to check connected
        dfs(A.get(1).charAt(0)-'a', visited, adjList);

        //after dfs checking if all given input char are visited or not
        for(int i=0;i < 26;i++){
            //if IncharArr has count of it and in visited array that char is not visited, then break
            if(OutcharArr.get(i) > 0 && !visited.get(i)){
                return 0;
            }
        }
        //if not then return true
        return 1;
    }
}
