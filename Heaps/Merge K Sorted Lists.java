/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    // we need to store node also, to know next node of that list

    //created a pair class and implemented its Comparator to store in PriorityQueue
    static class Pair{
        ListNode node;
        int val;
        Pair(int val, ListNode node){
            this.val = val;
            this.node = node;
        }

    }
    //now making a helper comparable class that implements comparable for Pair objects
    class HelperComp implements Comparator<Pair>{
        public int compare(Pair s1, Pair s2) {
            //just the difference of the two objects val
            return s1.val-s2.val;
        }

    }

	public ListNode mergeKLists(ArrayList<ListNode> a) {
        //keep a minheap and add heads of all, keep adding smallest value to the result list
        ListNode res = new ListNode(0);
        ListNode trav = res;
        //throwing new helper comparator for Pair objects
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new HelperComp());
        //fill all headnodes to heap then keep picking top
        for(int k=0;k < a.size();k++){
            minHeap.add(new Pair(a.get(k).val, a.get(k)));
        }

        // take out smallest make result list using trav, push next of added node in heap
        while(!minHeap.isEmpty()){
            Pair smallest = minHeap.poll();
            // pointing trav to smallest node
            trav.next = smallest.node;
            trav = trav.next;
            //in case that list ends
            if(trav.next!=null){
                minHeap.add(new Pair(trav.next.val, trav.next));
            }
        }
        //starting as 0 listnode so .next
        return res.next;
	}
}
