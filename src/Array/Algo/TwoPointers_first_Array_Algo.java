package Array.Algo;

public class TwoPointers_first_Array_Algo {


        /*
         * TWO POINTERS PATTERN - Amazon's Favorite!
         *
         * WHAT IS IT?
         * - Use TWO variables to track positions in an array
         * - Move them strategically to solve problems efficiently
         *
         * WHY USE IT?
         * - Converts O(n²) nested loops to O(n) single loop
         * - Uses O(1) space instead of O(n)
         * - Clean, readable code
         */

        public static void main(String[] args) {
            // Demo different two pointer patterns
            int[] sortedArray = {1, 3, 5, 7, 9, 11};

            System.out.println("=== PATTERN 1: OPPOSITE ENDS ===");
            demonstrateOppositeEnds(sortedArray, 12);

            System.out.println("\n=== PATTERN 2: SAME DIRECTION ===");
            int[] unsortedArray = {1, 1, 2, 2, 3, 4, 4, 5};
            demonstrateSameDirection(unsortedArray);

            System.out.println("\n=== PATTERN 3: FAST & SLOW ===");
            int[] cycleArray = {1, 2, 3, 4, 5, 6};
            demonstrateFastSlow(cycleArray);
        }

        // PATTERN 1: OPPOSITE ENDS (Most Common for Amazon)
        // Use case: Sorted arrays, finding pairs, palindromes
        public static void demonstrateOppositeEnds(int[] arr, int target) {
            System.out.println("Finding pair that sums to: " + target);
            System.out.println("Array: " + java.util.Arrays.toString(arr));

            int left = 0;                    // Start from beginning
            int right = arr.length - 1;      // Start from end

            System.out.println("\nStep by step:");
            int step = 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                System.out.println("Step " + step + ": left=" + left +
                        " (value=" + arr[left] + "), right=" + right +
                        " (value=" + arr[right] + "), sum=" + sum);

                if (sum == target) {
                    System.out.println("✅ Found pair: " + arr[left] + " + " + arr[right] + " = " + target);
                    return;
                } else if (sum < target) {
                    System.out.println("   Sum too small, move LEFT pointer right →");
                    left++;   // Need bigger number, move left pointer right
                } else {
                    System.out.println("   Sum too big, move RIGHT pointer left ←");
                    right--;  // Need smaller number, move right pointer left
                }
                step++;
            }
            System.out.println("❌ No pair found");
        }

        // PATTERN 2: SAME DIRECTION (For removing duplicates, sliding window)
        // Use case: Remove duplicates, modify arrays in-place
        public static void demonstrateSameDirection(int[] arr) {
            System.out.println("Removing duplicates from: " + java.util.Arrays.toString(arr));

            if (arr.length <= 1) return;

            int slow = 0;  // Points to position of last unique element
            int fast = 1;  // Explores the array

            System.out.println("\nStep by step:");
            int step = 1;

            while (fast < arr.length) {
                System.out.println("Step " + step + ": slow=" + slow +
                        " (value=" + arr[slow] + "), fast=" + fast +
                        " (value=" + arr[fast] + ")");

                if (arr[slow] != arr[fast]) {
                    slow++;                    // Move to next unique position
                    arr[slow] = arr[fast];     // Copy unique element
                    System.out.println("   Found new unique: " + arr[fast] +
                            ", placed at position " + slow);
                } else {
                    System.out.println("   Duplicate found, skip");
                }
                fast++;
                step++;
            }

            System.out.println("✅ Unique elements: " + (slow + 1));
            System.out.print("Modified array: ");
            for (int i = 0; i <= slow; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // PATTERN 3: FAST & SLOW (Floyd's Algorithm)
        // Use case: Detect cycles, find middle element
        public static void demonstrateFastSlow(int[] arr) {
            System.out.println("Finding middle element in: " + java.util.Arrays.toString(arr));

            int slow = 0;  // Moves 1 step at a time
            int fast = 0;  // Moves 2 steps at a time

            System.out.println("\nStep by step:");
            int step = 1;

            // When fast reaches end, slow will be at middle
            while (fast < arr.length - 1 && fast < arr.length - 2) {
                slow++;       // Move 1 step
                fast += 2;    // Move 2 steps

                System.out.println("Step " + step + ": slow=" + slow +
                        " (value=" + arr[slow] + "), fast=" + fast +
                        " (value=" + (fast < arr.length ? arr[fast] : "end") + ")");
                step++;
            }

            System.out.println("✅ Middle element: " + arr[slow]);
        }

        // TEMPLATE FOR TWO POINTERS (OPPOSITE ENDS)
        public static boolean twoPointersTemplate(int[] arr, int target) {
            // Step 1: Initialize pointers
            int left = 0;
            int right = arr.length - 1;

            // Step 2: Loop until pointers meet
            while (left < right) {
                // Step 3: Calculate current result
                int currentSum = arr[left] + arr[right];

                // Step 4: Check if we found answer
                if (currentSum == target) {
                    return true;  // Found!
                }
                // Step 5: Move pointers based on condition
                else if (currentSum < target) {
                    left++;   // Need larger sum
                } else {
                    right--;  // Need smaller sum
                }
            }

            // Step 6: Return result if not found in loop
            return false;
        }
    }

    /*
     * WHEN TO USE TWO POINTERS:
     *
     * 1. Array is SORTED ✅
     * 2. Looking for PAIRS that meet condition ✅
     * 3. Need to AVOID nested loops ✅
     * 4. Want O(1) extra space ✅
     *
     * COMMON MISTAKE:
     * Using two pointers on UNSORTED array for pair problems
     * (Sort first, or use HashMap instead)
     *
     * AMAZON'S FAVORITE VARIATIONS:
     * - Two Sum (sorted array)
     * - Three Sum
     * - Container with most water
     * - Remove duplicates from sorted array
     * - Valid palindrome
     */

