class ArrayRotator {

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k % n == 0) {
            return;
        }

        k = k % n;

        reverse(nums, 0, n - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, n - 1);
    }
}

class ArrayMerger {

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int p1 = 0;
        int p2 = 0;
        int k = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                merged[k] = nums1[p1];
                p1++;
            } else {
                merged[k] = nums2[p2];
                p2++;
            }
            k++;
        }

        while (p1 < m) {
            merged[k] = nums1[p1];
            p1++;
            k++;
        }

        while (p2 < n) {
            merged[k] = nums2[p2];
            p2++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        System.out.println("--- Array Merger Tests ---");
        int[] numsA = {1, 3, 5, 7};
        int[] numsB = {2, 4, 6, 8, 10};
        int[] resultAB = mergeSortedArrays(numsA, numsB);
        System.out.println("Result A + B: " + java.util.Arrays.toString(resultAB));

        int[] numsC = {10, 20, 30};
        int[] numsD = {5, 15, 25, 35};
        int[] resultCD = mergeSortedArrays(numsC, numsD);
        System.out.println("Result C + D: " + java.util.Arrays.toString(resultCD));

        System.out.println("\n--- Array Rotator Tests ---");

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Original: " + java.util.Arrays.toString(nums1) + ", k=" + k1);
        ArrayRotator.rotate(nums1, k1);
        System.out.println("Rotated:  " + java.util.Arrays.toString(nums1));

        System.out.println("--------------------");

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 5;
        System.out.println("Original: " + java.util.Arrays.toString(nums2) + ", k=" + k2);
        ArrayRotator.rotate(nums2, k2);
        System.out.println("Rotated:  " + java.util.Arrays.toString(nums2));
        
        System.out.println("--------------------");
        
        int[] nums3 = {10, 20};
        int k3 = 2;
        System.out.println("Original: " + java.util.Arrays.toString(nums3) + ", k=" + k3);
        ArrayRotator.rotate(nums3, k3);
        System.out.println("Rotated:  " + java.util.Arrays.toString(nums3));
    }
}
