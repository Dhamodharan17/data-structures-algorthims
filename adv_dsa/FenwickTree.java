//supports range query in logn 
//prefix concepts
class FenwickTree {
    private int[] tree; // The tree array
    private int n;      // Size of the array

    // Constructor to initialize the Fenwick Tree
    public FenwickTree(int size) {
        n = size;
        tree = new int[n + 1]; // Tree size is n + 1 (1-based index)
    }

    // Function to update the Fenwick Tree
    public void update(int index, int value) {
        // Increment the index to match the 1-based indexing of the tree
        index++;
        while (index <= n) {
            tree[index] += value; // Update the tree with the value
            index += index & -index; // Move to the next index
        }
    }

    // Function to get the prefix sum up to a given index
    public int getPrefixSum(int index) {
        // Increment the index to match the 1-based indexing of the tree
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index]; // Add the value from the tree
            index -= index & -index; // Move to the parent index
        }
        return sum;
    }

    // Function to get the sum in the range [left, right]
    public int getRangeSum(int left, int right) {
        return getPrefixSum(right) - getPrefixSum(left - 1);
    }

    public static void main(String[] args) {
        FenwickTree fenwickTree = new FenwickTree(5);
        
        // Initialize the Fenwick Tree with some updates
        fenwickTree.update(0, 1); // Add 1 at index 0
        fenwickTree.update(1, 2); // Add 2 at index 1
        fenwickTree.update(2, 3); // Add 3 at index 2
        fenwickTree.update(3, 4); // Add 4 at index 3
        fenwickTree.update(4, 5); // Add 5 at index 4
        
        // Querying the sum of values
        System.out.println("Sum of first 3 elements: " + fenwickTree.getPrefixSum(2)); // Output: 6
        System.out.println("Sum from index 1 to 3: " + fenwickTree.getRangeSum(1, 3)); // Output: 9
    }
}
