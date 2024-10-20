//tells how many toys in each segment ( we can segment and sub segement)
//If you want to find the sum, minimum, maximum, or any other aggregate function over a range of elements in an array
//log n - query and update

class SegmentTree {
    private int[] tree;   // Array to store the segment tree
    private int n;        // Size of the input array

    // Constructor to initialize the segment tree
    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // Size of segment tree
        build(arr, 0, 0, n - 1);
    }

    // Function to build the segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            // Leaf node will have a single element
            tree[node] = arr[start];
        } else {
            // Recursively build the segment tree
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid); // Left child
            build(arr, 2 * node + 2, mid + 1, end); // Right child
            // Internal node will have the sum of both of its children
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    // Function to query the sum in a given range
    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    // Function to query the sum in the range [L, R]
    private int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            // Range represented by a node is completely outside the given range
            return 0; // Sum is 0 for out-of-range
        }
        if (L <= start && end <= R) {
            // Range represented by a node is completely inside the given range
            return tree[node];
        }
        // Range represented by a node is partially inside and partially outside
        int mid = (start + end) / 2;
        int leftSum = query(2 * node + 1, start, mid, L, R);
        int rightSum = query(2 * node + 2, mid + 1, end, L, R);
        return leftSum + rightSum;
    }

    // Function to update the value at a specific index
    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    // Function to update the value at index `idx`
    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            // Leaf node
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                // If idx is in the left child, recurse on the left child
                update(2 * node + 1, start, mid, idx, value);
            } else {
                // If idx is in the right child, recurse on the right child
                update(2 * node + 2, mid + 1, end, idx, value);
            }
            // Update the internal node value after the change
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println("Sum of values in range [1, 3]: " + segmentTree.query(1, 3)); // Output: 15
        System.out.println("Sum of values in range [0, 5]: " + segmentTree.query(0, 5)); // Output: 36

        // Update the value at index 1
        segmentTree.update(1, 10);
        System.out.println("After updating index 1 to 10");
        System.out.println("Sum of values in range [1, 3]: " + segmentTree.query(1, 3)); // Output: 22
    }
}
