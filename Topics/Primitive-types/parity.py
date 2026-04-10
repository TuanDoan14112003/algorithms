# This program return the parity of a number. 
# The parity is 1 if there are odd 1s in the number's binary string
# The parity is 0 if there are even 1s in the number's binary string
# Note: in this program, ^ (XOR) acts if as a running odd/even counter:
# 0 ^ 1 = 1; 1 ^ 1 = 0 (flip the result if encounter 1)
# 0 ^ 0 = 0; 1 ^ 0 = 1 (keep the result if encounter 0)
# Time complexity O(n)
# Space complexity O(1)

def parity(number):
    result = 0
    while number:
        result ^= number & 1
        number >>= 1
    return result
        

# The improved solution use this bit manipulation trick number &= number - 1 to remove the 
# lowest set bit of number
# New time Complexity O(k) where k is the number of 1s in the binary string
def improved_parity(number):
    result = 0
    while number:
        result ^= 1
        number &= number - 1

# Another solution for 64-bit word integer use array based lookup table to cache the known parity value of 16 bits numbers
# Time complexity = O(n/L) where n is the word size and L is the width of the words 
# for which we cache the results (This does not include the time for initialization of the lookup table)
def more_improved_parity(x):
	MASK_SIZE = 16
	BIT_MASK = 0xFFFF
	return (PRECOMPUTED_PARITY[x >> (3 * MASK_SIZE)] ^ PRECOMPUTED_PARITY[(x >> (2 * MASK_SIZE)) & BIT_MASK] ^ PRECOMPUTED_PARITY[(x >> MASK_SIZE) & BIT_MASK] ^ PRECOMPUTED_PARITY[x & BIT_MASK] )

# There is another solution with an improved worst case running time. This solution uses the 
# definition of the XOR operation. In particular, the XOR of a group of bits is its parity.
# The parity of (b3,b2,b1,b0) equals the parity of the XOR of (b3,b2) and (b1,b0). We repeat the
# same operation with 2, and 1 bit operand to get the result.
# For example: The parity of (1010) is the parity of (10) XORed with (10), i.e (00).
# The final result is 0 XORed with ), i.e. 0.
# another solution with time complexity O(logn) where n is the word size:

def parity(x):
     x ^= x >> 32
     x ^= x >> 16
     x ^= x >> 8
     x ^= x >> 4
     x ^= x >> 2
     x ^= x >> 1
     return x & 0x1

