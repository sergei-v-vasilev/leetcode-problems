package algorithms.slidingwindow;

import java.util.TreeMap;

/**
 * 480. Sliding Window Median
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        //part of size k/2
        TreeMap<Integer, Integer> firstPart = new TreeMap<>();
        //part of size k-k/2
        TreeMap<Integer, Integer> secondPart = new TreeMap<>();
        int firstPartSize = 0;
        int secondPartSize = 0;
        int firstPartCapacity = k / 2;
        int secondPartCapacity = k - k / 2;
        //construct the fist part
        for (int i = 0; i < k; i++) {
            firstPart.put(nums[i], firstPart.getOrDefault(nums[i], 0) + 1);
            firstPartSize++;
        }
        //construct the second part
        while (firstPartSize > firstPartCapacity) {
            int biggestValue = firstPart.lastKey();
            secondPart.put(biggestValue, secondPart.getOrDefault(biggestValue, 0) + 1);
            secondPartSize++;
            decreaseElement(biggestValue, firstPart);
            firstPartSize--;
        }

        //move window
        for (int i = 0; i < result.length; i++) {
            //add the median of the current window
            result[i] = getMedian(k, firstPart, secondPart);
            //shrink the window from the left (remove the first element in the window)
            int valueToRemove = nums[i];
            if (firstPart.containsKey(valueToRemove)) {
                decreaseElement(valueToRemove, firstPart);
                firstPartSize--;
            } else {
                decreaseElement(valueToRemove, secondPart);
                secondPartSize--;
            }
            //add the new element to the parts (add the first element after the window)
            if (i + k < nums.length) {
                int valueToAdd = nums[i + k];
                if (secondPartSize == 0 || valueToAdd < secondPart.firstKey()) {
                    firstPart.put(valueToAdd, firstPart.getOrDefault(valueToAdd, 0) + 1);
                    firstPartSize++;
                } else {
                    secondPart.put(valueToAdd, secondPart.getOrDefault(valueToAdd, 0) + 1);
                    secondPartSize++;
                }
            }
            //re-balance parts so we can use it next iteration properly to calculate the median
            //froms second to first
            while (secondPartSize > secondPartCapacity && firstPartSize < firstPartCapacity) {
                int lowest = secondPart.firstKey();
                firstPart.put(lowest, firstPart.getOrDefault(lowest, 0) + 1);
                firstPartSize++;
                decreaseElement(lowest, secondPart);
                secondPartSize--;
            }
            //from first to second
            while (firstPartSize > firstPartCapacity && secondPartSize < secondPartCapacity) {
                int biggest = firstPart.lastKey();
                secondPart.put(biggest, secondPart.getOrDefault(biggest, 0) + 1);
                secondPartSize++;
                decreaseElement(biggest, firstPart);
                firstPartSize--;
            }
        }

        return result;
    }

    private double getMedian(int k, TreeMap<Integer, Integer> firstPart, TreeMap<Integer, Integer> secondPart) {
        if (k % 2 != 0) {
            return secondPart.firstKey();
        } else {
            double result = firstPart.lastKey();
            result += secondPart.firstKey();
            return result / 2;
        }
    }


    private void decreaseElement(int value, TreeMap<Integer, Integer> map) {
        if (map.get(value) == 1) {
            map.remove(value);
        } else {
            map.put(value, map.get(value) - 1);
        }
    }
}
