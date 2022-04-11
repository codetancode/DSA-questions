public class Solution {
    public ArrayList < Integer > solve(int p1, int p2, int p3, int k) {
        ArrayList < Integer > finalAnswer = new ArrayList < Integer > ();
        int[] nextBestNumbers = new int[3];
        // natural number multiplicatio for all 3 prime are stores in current index(1, 2, 3, ..) for 2 prime no.
        int[] currIndex = new int[3];
        int[] prime = new int[3];

        nextBestNumbers[0] = prime[0] = p1;
        nextBestNumbers[1] = prime[1] = p2;
        nextBestNumbers[2] = prime[2] = p3;

        currIndex[0] = currIndex[1] = currIndex[2] = -1;

        for (int j = 1; j <= k; j++) {
            int nextNumber = Math.min(nextBestNumbers[0], Math.min(nextBestNumbers[1], nextBestNumbers[2]));
            finalAnswer.add(nextNumber);

            //to avoid duplicates
            for (int i = 0; i < 3; i++) {
                if (nextNumber == nextBestNumbers[i]) {
                    //increaseing multipliers for that prime number
                    currIndex[i]++;
                    // adding increased index multiplication of that ith prime nuo. into the choices(nextBest array)
                    nextBestNumbers[i] = finalAnswer.get(currIndex[i]) * prime[i];
                }
            }
        }
        return finalAnswer;

    }
}
