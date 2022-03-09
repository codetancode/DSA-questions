public class Solution {
    // O(n, 1) counting sort
    //usng Swapping in 1 pass
    public int[] sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high){
            //if mid 0, swap and increment both lod and mid
            if(arr[mid] == 0){
                swap(mid, low, arr);
                low++;
                mid++;

            }else if(arr[mid] == 1){
                //if 1 just increment mid
                mid++;
            }
            else{
                //if 2 Swap decrement high, but dont increment mid as swapped currnt mid value could be 0/1
                swap(mid, high, arr);
                high--;
            }
        }

        return arr;
    }

    static void swap(int i, int j, int[] arr){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

}
