public class Solution {
//O(n, n) as tree of n nodes, stack and queues for n nodes
//idea is to get farthest node from any point, using BFS, fom that point get farthest node using DFS
//keeping max distance
    public int solve(ArrayList < Integer > A) {
        int n = A.size();
        ArrayList < ArrayList < Integer >> adjList = new ArrayList < ArrayList < Integer >> ();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList < Integer > ());
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            if (num == -1) {
            // getting -1 (root) index
                root = i;
                continue;
            }
            //undirected tree, so both ways
            adjList.get(i).add(num);
            adjList.get(num).add(i);
        }
        // Find the node which is farthest from root node using BFS
        int node = bfs(adjList, n, root);
        // Find the maximum distance from farthest node using modified DFS
        return dfs(adjList, n, node);
    }


    public int bfs(ArrayList < ArrayList < Integer >> adjList, int n, int fromNode) {
        boolean[] vis = new boolean[n];
        Queue < Integer > bfsQ = new LinkedList < Integer > ();
        bfsQ.add(fromNode);
        while (!bfsQ.isEmpty()) {
            // stores the farthest node from root node
            fromNode = bfsQ.remove();
            if (!vis[fromNode]) {
                vis[fromNode] = true;
                for (Integer v: adjList.get(fromNode)) {
                    if (!vis[v]) {
                        bfsQ.add(v);
                    }
                }
            }
        }
        return fromNode;
    }

    //dfs using stack, and another stack for distance
    public int dfs(ArrayList < ArrayList < Integer >> adjList, int n, int u) {
        int max = 0;
        //as distance and nodes are coupled with each other so using same distance stack for the corresponding node in dfsSt
        Stack < Integer > dfsSt = new Stack < Integer > ();
        Stack < Integer > dist = new Stack < Integer > ();
        boolean[] vis = new boolean[n];
        dfsSt.push(u);
        dist.push(0);
        while (!dfsSt.isEmpty()) {
            u = dfsSt.pop();
            int d = dist.pop();
            //pop from stack if not visited, mark visited and add adjList of it
            if (!vis[u]) {
                vis[u] = true;
                for (Integer v: adjList.get(u)) {
                    //if adjList is not visited, then add
                    if (!vis[v]) {
                        //keeping a max distance for result
                        max = Math.max(max, d + 1);
                        dfsSt.push(v);
                        dist.push(d + 1);
                    }
                }
            }
        }
        return max;
    }
}
