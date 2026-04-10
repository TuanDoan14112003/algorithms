def quotient(x, y, result = 0):
	if y  > x:
		return result
	i = 0
	while x >= (y << i):
		i += 1
	return quotient( x - (y << (i - 1)),y, result + (1 << (i -1)))
	
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
