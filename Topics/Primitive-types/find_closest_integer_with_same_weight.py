import math

def find_closest(x):
    word_size = 64
    for i in range(word_size - 1):
        if (x >> i) & 1 != (x >> (i+1)) & 1:
            return x ^ ((1 << i) | (1 << (i +1)))
    raise ValueError('All bits are 0 or 1')


def find_closest_optimised(x):
    if x & 1 == 0:
        delta = x & ~(x-1)
    else:
        delta = (~x) & (x + 1)

    return x ^ (delta | (delta >> 1))
    
    


print(find_closest(11))
print(find_closest_optimised(11))