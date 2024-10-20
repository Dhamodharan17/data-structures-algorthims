/*

1. Basic Operations
AND (&): Useful for clearing bits.
OR (|): Useful for setting bits.
XOR (^): Useful for toggling bits and checking for equality.
NOT (~): Useful for inverting bits.

2. Shifting Bits
Left Shift (<<): Multiplies a number by 2power n
Right Shift (>>): Divides a number by 2 power n

3. Checking Specific Bits
Check if k-th bit is set: (num & (1 << k)) != 0
Check if k-th bit is cleared: (num & (1 << k)) == 0

4. Setting and Clearing Bits
Set k-th bit: num | (1 << k)
Clear k-th bit: num & ~(1 << k)
Toggle k-th bit: num ^ (1 << k)

5. Counting Bits
while (num > 0) {
    num &= (num - 1); // Reduces the number of set bits by 1
    count++;
}
Count total bits: Integer.bitCount(num) in Java.
6.Bit Masking

for (int mask = 0; mask < (1 << n); mask++) {
    // Use mask to form a subset
}

*/
