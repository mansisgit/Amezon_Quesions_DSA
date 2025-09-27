package Array;
import java.util.*;

public class Array_Basics {

    public static void main(String[] args) {
        // 1. ARRAY DECLARATION & INITIALIZATION (Amazon Style)

        // Method 1: Declare then initialize
        int[] prices;
        prices = new int[5]; // Creates array of size 5, all elements = 0

        // Method 2: Declare and initialize together
        int[] ratings = new int[]{4, 5, 3, 4, 5};

        // Method 3: Short form (most common in interviews)
        int[] quantities = {100, 200, 150, 300, 250};

        // 2. BASIC OPERATIONS (What Amazon tests)

        // Access element - O(1) time
        System.out.println("First item: " + quantities[0]); // Output: 100

        // Modify element - O(1) time
        quantities[0] = 120; // Update first item

        // Get array length
        System.out.println("Total items: " + quantities.length); // Output: 5

        // 3. COMMON ARRAY PATTERNS (Amazon Favorites)

        // Pattern 1: Iterate through array
        System.out.println("All quantities:");
        for (int i = 0; i < quantities.length; i++) {
            System.out.print(quantities[i] + " ");
        }
        System.out.println();

        // Pattern 2: Enhanced for loop (when you don't need index)
        System.out.println("All quantities (enhanced loop):");
        for (int qty : quantities) {
            System.out.print(qty + " ");
        }
        System.out.println();

        // Pattern 3: Find maximum element (Amazon classic)
        int maxQty = findMaximum(quantities);
        System.out.println("Maximum quantity: " + maxQty);

        // Pattern 4: Check if array contains target (Amazon favorite)
        boolean found = contains(quantities, 200);
        System.out.println("Contains 200: " + found);

        // Pattern 5: Two pointers demonstration
        int[] sortedPrices = {10, 20, 30, 40, 50, 60};
        int target = 70;
        boolean pairExists = twoSum(sortedPrices, target);
        System.out.println("Pair exists for target " + target + ": " + pairExists);
    }

    // HELPER METHODS (Write these cleanly in interviews)

    // Find maximum element - O(n) time, O(1) space
    public static int findMaximum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = arr[0]; // Assume first element is maximum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Check if array contains target - O(n) time, O(1) space
    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // TWO POINTERS TECHNIQUE - Amazon's #1 favorite!
    // Check if any two elements sum to target
    public static boolean twoSum(int[] arr, int target) {
        // This works only if array is SORTED!
        int left = 0;                    // Start pointer
        int right = arr.length - 1;      // End pointer

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                System.out.println("Found pair: " + arr[left] + " + " + arr[right]);
                return true;
            } else if (currentSum < target) {
                left++;  // Need larger sum, move left pointer right
            } else {
                right--; // Need smaller sum, move right pointer left
            }
        }
        return false; // No pair found
    }
}
