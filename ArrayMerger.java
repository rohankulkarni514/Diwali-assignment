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
        int[] numsA = {1, 3, 5, 7};
        int[] numsB = {2, 4, 6, 8, 10};
        int[] resultAB = mergeSortedArrays(numsA, numsB);
        System.out.println("Result A + B: " + java.util.Arrays.toString(resultAB));

        int[] numsC = {10, 20, 30};
        int[] numsD = {5, 15, 25, 35};
        int[] resultCD = mergeSortedArrays(numsC, numsD);
        System.out.println("Result C + D: " + java.util.Arrays.toString(resultCD));
    }
}