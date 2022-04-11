public class Solution {
    //given onstraints, so making global adjlist, visited and sistance array for dijkstra
    static int maxn = 1009;
    static ArrayList < ArrayList < pair > > adj;
    static int[] dist = new int[maxn];
    static int[] visited = new int[maxn];
    static int inf = 1000000000;

    //initilize all arrya till given constrain
    public static void graph() {
        adj = new ArrayList < ArrayList < pair > > (maxn);
        for (int i = 0; i < maxn; i++) {
            dist[i] = 0;
            visited[i] = 0;
            adj.add(new ArrayList < pair > ());
        }
    }


    public int solve(int A, int[][] B) {
        graph();
        Map < pair, Integer > mp = new HashMap < pair, Integer > ();

        //adding edges and weights b/w nodes
        for (int[] row: B) {
            // if (row[0] == row[1]) continue;
            //as Comparable implemented for Pairs, checking if edges from a to b, or b to a is already present or not
            if (mp.containsKey(new pair(row[0], row[1])) || mp.containsKey(new pair(row[1], row[0])))
                continue;

            //map to check freq of edges from a to b, b to a, as 1
            mp.put(new pair(row[0], row[1]), 1);
            mp.put(new pair(row[1], row[0]), 1);

            //adding both ways as undirected graph, Pair(toNode and weight of edge)
            // from row[0], pair (tonode row[1], weight row[2])
            adj.get(row[0]).add(new pair(row[1], row[2]));
            adj.get(row[1]).add(new pair(row[0], row[2]));
        }

        int ans = Integer.MAX_VALUE;
        //again goinf through the given edges and weights
        //we are trying to remove every edges from adjlist and doing dijkstra, and keeping min cost, them adding that edge back
        //its like back tracking
        for (int[] row: B) {
            int u = row[0];
            int v = row[1];
            int w = row[2];

            removeEdge(u, v, w);
            int cost = dijkstra(u, v);
            if (cost != inf)
                ans = Math.min(ans, cost + w);
            //back track
            addEdge(u, v, w);
        }
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }


    public static void removeEdge(int u, int v, int w) {
        adj.get(u).remove(new pair(v, w));
        adj.get(v).remove(new pair(u, w));
    }
    public static void addEdge(int u, int v, int w) {
        adj.get(u).add(new pair(v, w));
        adj.get(v).add(new pair(u, w));
    }

    public static int dijkstra(int source, int dest) {
        PriorityQueue < pair > pq = new PriorityQueue < pair > (new CustomComp());
        // re initilizing  global visited and distance array
        for (int i = 0; i < maxn; i++) {
            dist[i] = inf;
            visited[i] = 0;
        }
        //keeping source as 0
        dist[source] = 0;
        pq.add(new pair(source, 0));

        while (pq.size() != 0) {
            pair temp = pq.poll();
            int u = temp.toNode;
            //looking for low weights edges, if node not visited
            if (visited[u] == 1)
                continue;
            // mark it visited
            visited[u] = 1;
            //looking for its adjnodes
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).toNode;
                int w = adj.get(u).get(i).w;

                //if distance to U + weight of current node < distance to V, add current node
                if (dist[u] + w < dist[v]) {
                    //distance to V is smaller using current node, so update it
                    dist[v] = dist[u] + w;
                    pq.add(new pair(v, dist[v]));
                }
            }
        }
        return dist[dest];
    }
}


class pair implements Comparable {
    int toNode, w;
    pair(int f, int s) {
        toNode = f;
        w = s;
    }
    @Override
    public int compareTo(Object o) {
        pair p1 = (pair) this;
        pair p2 = (pair) o;
        return (p1.toNode != p2.toNode) ? p1.toNode - p2.toNode : p1.w - p2.w;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pair)) return false;
        pair p1 = (pair) this;
        pair p2 = (pair) o;
        return p1.toNode == p2.toNode && p1.w == p2.w;
    }
    @Override
    public int hashCode() {
        // hash code combination of both parameters
        return this.toNode + 97 * this.w;
    }
}

class CustomComp implements Comparator < pair > {
    @Override
    public int compare(pair aa, pair bb) {
        return aa.toNode - bb.toNode;
    }
}
