# Compute Product Without Arithmetical Operators


# Solution: We can compute the product using the long multiplication method, but instead of 
# using normal arithmetic operators, we only use bitwise operations.

# To implement addition, we use a recursive `add` function:

# a ^ b adds bits without carrying

# (a & b) << 1 computes the carry

# We repeat this until there is no carry left.

def add(a,b):
	return a if b == 0 else add(a^b, (a & b) << 1)
	
def product(a,b):
	result = 0
	i = 0
	while b:
		if (b & 1) == 1:
			result = add(result, a << i)
		i += 1
		b >>= 1
	return result

print(product(2,3))		
print(product(7,8))
print(product(8,9))
