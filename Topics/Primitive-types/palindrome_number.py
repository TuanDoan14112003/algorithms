# Given an integer x, return true if x is a palindrome, and false otherwise.

# Time Complexity: O(n) where n is the number of digits of the input
# Space Complexity: O(1)

import math
def is_palindrome(x):
	if x < 0:
		return False
	if x < 10:
		return True
	last_digit = x % 10
	first_digit = x // (10**int(math.log10(x)))
	if first_digit != last_digit:
		return False
	return is_palindrome( (x % (10**int(math.log10(x))) // 10))
print(is_palindrome(131))
print(is_palindrome(0))
print(is_palindrome(-1))
print(is_palindrome(32))
