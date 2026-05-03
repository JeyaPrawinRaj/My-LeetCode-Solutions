/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            // Use (low + (high - low) / 2) to prevent integer overflow
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // Found the number
            } else if (res == -1) {
                high = mid - 1; // Picked number is lower, move left
            } else {
                low = mid + 1; // Picked number is higher, move right
            }
        }
        
        return -1;
    }
}
