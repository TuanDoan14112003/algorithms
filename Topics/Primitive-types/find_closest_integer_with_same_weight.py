
# Write a program that takes as input a nonnegative integer x and returns a number y such that:


# y != x
# y has the same weight as x
# The difference |y - x| is as small as possible

#You can assume x is neither 0 nor all 1s.

## Idea


# To find the nearest integer with the same weight, we need to swap: one 1 bit with one 0 bit


# To make the difference as small as possible, those two bits should:
# - be adjacent
# - be as close to the least significant bit as possible

# So the goal is to find the rightmost pair of adjacent bits that differ, then swap them.

def find_closest(x):
    word_size = 64
    for i in range(word_size - 1):
        if (x >> i) & 1 != (x >> (i+1)) & 1:
            return x ^ ((1 << i) | (1 << (i +1)))
    raise ValueError('All bits are 0 or 1')

# We can also derive an `O(1)` approach using bit manipulation.
# x & ~(x - 1) isolates the lowest bit that is `1` in `x`
# (~x) & (x + 1) isolates the rightmost `0` bit in `x` and flips it to `1`

# After finding the rightmost bit that differs from the least significant bit, 
# we swap it with the bit right next to it.

def find_closest_optimised(x):
    if x & 1 == 0:
        target_bit = x & ~(x-1)
    else:
        target_bit = (~x) & (x + 1)

    return x ^ (target_bit | (target_bit >> 1)) # flipping target bit and the bit right next to it


print(find_closest(11))
print(find_closest_optimised(11))