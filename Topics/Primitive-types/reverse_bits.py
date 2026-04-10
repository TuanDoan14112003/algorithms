# Reversing bits using a look up table. Time complexity: O(n/L) where n is the word size and L is the chunk size
def reverse_bit(x):
	chunk_size = 16
	bit_mask = 0xFFFF
	return (PRECOMPUTED_REVERSE_BITS[x >> (chunk_size * 3)]) | (PRECOMPUTED_REVERSE_BITS[(x >> (chunk_size * 2)) & bit_mask] << chunk_size)  | (PRECOMPUTED_REVERSE_BITS[(x >> chunk_size) & bit_mask] << (chunk_size * 2)) | (PRECOMPUTED_REVERSE_BITS[x & bit_mask] << chunk_size * 3)
	

