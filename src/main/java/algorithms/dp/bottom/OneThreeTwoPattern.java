package algorithms.dp.bottom;

import java.util.TreeSet;

/**
 * 456. 132 Pattern
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Integer[] biggestNumberThatIsSmallerOnTheLeft = new Integer[nums.length];
        TreeSet<Integer> biggestNumberThatIsSmaller = new TreeSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            Integer biggestNumber = biggestNumberThatIsSmaller.lower(nums[i]);
            biggestNumberThatIsSmallerOnTheLeft[i] = biggestNumber;
            biggestNumberThatIsSmaller.add(nums[i]);
        }
        Integer[] smallestNumberThatIsBiggerOnTheRight = new Integer[nums.length];
        TreeSet<Integer> smallestNumberThatIsBigger = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            TreeSet<Integer> headSet = (TreeSet<Integer>) smallestNumberThatIsBigger.headSet(nums[i], false);
            Integer smallestNumber = !headSet.isEmpty()? headSet.first() : null;
            smallestNumberThatIsBiggerOnTheRight[i] = smallestNumber;
            smallestNumberThatIsBigger.add(nums[i]);
        }
        for(int i= 0; i < nums.length; i++) {
            if(smallestNumberThatIsBiggerOnTheRight[i] != null && biggestNumberThatIsSmallerOnTheLeft[i] != null) {
                if(smallestNumberThatIsBiggerOnTheRight[i] < biggestNumberThatIsSmallerOnTheLeft[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
