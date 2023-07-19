import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    //Given a non-empty array of integers nums,
    // every element appears twice except for one. Find that single one.

    //You must implement a solution with a linear runtime complexity
    // and use only constant extra space.

    //Example 1:
    //Input: nums = [2,2,1]
    //Output: 1

    public static int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<>();

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                result.remove(nums[i]);
            } else {
                result.add(nums[i]);
            }
        }

        return result.iterator().next();
    }

    //Bitwise operation

    /*Using Bit Manipulation -

    As we know XOR operation with 0 gives the same number
    i.e, a XOR 0 = a
    eg, for decimal no. 2=> 2 XOR 0 = 2
    in binary, 010 XOR 000 = 010

    Also we know that , XOR operation with same number gives 0
    i.e, a XOR a = 0
    eg, 2 XOR 2 = 0
    in binary, 010 XOR 010 = 000

    XOR is associative (like sum)
    i.e, (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4), So the order doesn't matter in performing XOR operation.
    eg, 2^3^4^6 = 3^2^6^4 = 4^2^6^3 ......*/

    public static int singleNumberBit(int[] nums) {
        int ans = 0; //since XOR with 0 returns same number

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];  // ans = (ans) XOR (array element at i)
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 2};

        System.out.println(singleNumber(nums));

        System.out.println(singleNumberBit(nums));


    }
}