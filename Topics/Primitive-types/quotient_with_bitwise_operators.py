# Compute quotient without arithmetical operators

# To compute the quotient without using normal arithmetic operators, we can repeatedly 
# subtract the largest shifted multiple of the divisor.

# The key observation is:

# - find the largest k such that 2^k * y <= x
# - subtract 2^k * y from x
# - add 2^k to the quotient

# This works because left shift lets us efficiently compute powers of two multiples.


# Time complexity: $O(n^2)$ where n is the number of bits needed to represent x/y
def quotient(x, y, result = 0):
	if y  > x:
		return result
	i = 0
	while x >= (y << i):
		i += 1
	return quotient( x - (y << (i - 1)),y, result + (1 << (i -1)))



# We can also work backward. 
# This version is better because after finding the first largest k such that `^k * y <= x, 
# later iterations can continue from that previous value of k instead of starting over from 0.
# Time complexity: $O(n)$ where n is the number of bits needed to represent x/y
def quotient_second_version(x, y):
	power = 32
	result = 0
	y_power = y << power
	while x >= y:
		while y_power > x:
			power -= 1
			y_power >>= 1
		x -= y_power
		result += 1 << power
	return result
print(quotient(56,8))
print(quotient_second_version(56,8))
