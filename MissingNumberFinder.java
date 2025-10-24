public class LongestStringFinder {

    public static int findLongestLength(String[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 0;

        for (String str : arr) {
            if (str != null) {
                int currentLength = str.length();
                
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] words1 = {"apple", "banana", "kiwi", "grapefruit", "orange"};
        int length1 = findLongestLength(words1);
        System.out.println("Array 1: {\"apple\", \"banana\", \"kiwi\", \"grapefruit\", \"orange\"}");
        System.out.println("Length of the longest string: " + length1);

        System.out.println("\n-------------------------------\n");

        String[] words2 = {"", "a", "bb", "ccc", ""};
        int length2 = findLongestLength(words2);
        System.out.println("Array 2: {\"\", \"a\", \"bb\", \"ccc\", \"\"}");
        System.out.println("Length of the longest string: " + length2);

        System.out.println("\n-------------------------------\n");

        String[] words3 = {};
        int length3 = findLongestLength(words3);
        System.out.println("Array 3: {}");
        System.out.println("Length of the longest string: " + length3);

        System.out.println("\n-------------------------------\n");
        
        String[] words4 = {"a", null, "longestword", "b", "c"};
        int length4 = findLongestLength(words4);
        System.out.println("Array 4: {\"a\", null, \"longestword\", \"b\", \"c\"}");
        System.out.println("Length of the longest string: " + length4);
    }
}