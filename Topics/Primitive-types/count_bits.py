# This program count the numbers of bits that are set to 1 in a positive integer
# Time complexity O(n)
# Space Complexity O(1)

def counts_bit(x):
    count = 0
    while x:
        count += x & 1
        x >>= 1
    return count
