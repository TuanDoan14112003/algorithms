# swapping bits at position i and j. Running time O(1), space complexity O(1). We only swap
# if the bits at i and j differ. To swap the bits, we just need to flip each bit (1 to 0 and 0 to 1)
# by using XOR with a bit mask where 1 is set at i and j, e.g. (__1___1__) 
def swap_bits(x, i, j):
	if (x >> i) & 1 != (x >> j) & 1:
		bit_mask = (1 << i) | (1 << j)
		x ^= bit_mask
	return x

print(swap_bits(73,6,1))


