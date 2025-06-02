package algorithms.binarysearch;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 */
public class CountOfSmallerNumbersAfterSelf {

    private static class SegmentTree {
        int leftFrom;
        int leftTo;
        SegmentTree left; //[leftFrom, leftTo)

        int rightFrom;
        int rightTo;
        SegmentTree right; //[rightFrom, rightTo)

        int value = 0;

        SegmentTree construct(int from, int to) {
            if (from == to - 1) return new SegmentTree();
            SegmentTree root = new SegmentTree();
            int mid = from + (to - from) / 2;
            root.leftFrom = from;
            root.leftTo = mid;
            root.left = construct(root.leftFrom, root.leftTo);

            root.rightFrom = mid;
            root.rightTo = to;
            root.right = construct(root.rightFrom, root.rightTo);

            return root;
        }

        int getSmaller(int i) {
            if (i == rightTo - 1) {
                return value;
            } else if (leftFrom <= i && i < leftTo) {
                return left.getSmaller(i);
            } else if (rightFrom <= i && i < rightTo) {
                return left.value + right.getSmaller(i);
            }
            return value;
        }

        void increase(int i) {
            this.value = value + 1;
            if (left != null && i < leftTo - 1) {
                left.increase(i);
            } else if (right != null && i < rightTo - 1) {
                right.increase(i);
            }
        }
    }

    public static List<Integer> countSmallerST(int[] nums) {
        SegmentTree root = new SegmentTree();
        LinkedList<Integer> result = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        root = root.construct(min, max + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            result.addFirst(root.getSmaller(nums[i]));
            root.increase(nums[i]);
        }
        return result;
    }

    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> sorted = new ArrayList<>(nums.length);
        for (int num : nums) {
            sorted.add(num);
        }
        sorted.sort(Integer::compareTo);
        LinkedList<Integer> result = new LinkedList<>();
        for (int num : nums) {
            result.add(binarySearch(num, sorted));
            sorted.remove((Integer) num);
        }
        return result;
    }


    private int binarySearch(int value, ArrayList<Integer> array) {
        int start = 0;
        int end = array.size();
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array.get(mid) < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
