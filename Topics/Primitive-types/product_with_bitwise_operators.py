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
