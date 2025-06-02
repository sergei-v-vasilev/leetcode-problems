package algorithms.math;

/**
 * 932. Beautiful Array
 */
public class BeautifulArray {
    /*
        split the input array into two arrays of alternate numbers,
        recurse on those to splitted arrays and combine them
                [1,2,3,4,5,6,7]    
            [1,3,5, 7]         [2,4,6]
          [1, 5]  [3,7]      [2, 6] [4]
          [1, 5, 3, 7]       [2, 6, 4]
                [1,5,3,7,2,6,4] 
    */
    
    public int[] beautifulArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        return beautify(arr);
    }

    private int[] beautify(int[] arr) {
        if (arr.length <= 2)
            return arr;
        int n = arr.length;
        int[] leftArray = new int[(n + 1) / 2];
        int[] rightArray = new int[n / 2];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                leftArray[i / 2] = arr[i];
            else
                rightArray[i / 2] = arr[i];
        }

        leftArray = beautify(leftArray);
        rightArray = beautify(rightArray);

        return concatenate(leftArray, rightArray);
    }

    int[] concatenate(int[] arr1, int[] arr2) {
        int[] combinedArr = new int[arr1.length + arr2.length];
        copyToArr(arr1, 0, combinedArr);
        copyToArr(arr2, arr1.length, combinedArr);
        return combinedArr;
    }

    void copyToArr(int[] source, int start, int[] target) {
        for (int i = 0; i < source.length; i++)
            target[start++] = source[i];
    }
}
