def reverse_digits(x):
	absolute = abs(x)
	result = 0
	while absolute:
		result = result * 10 + absolute % 10
		absolute //= 10
	return result if x > 0 else -result

print(reverse_digits(123))
print(reverse_digits(-43))
print(reverse_digits(0))
print(reverse_digits(4))
print(reverse_digits(-8))
