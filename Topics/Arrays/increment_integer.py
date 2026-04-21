def increment(A):
    carry = 1
    index = len(A) - 1
    while carry > 0 and index >= 0:
        new_value = A[index] + 1
        A[index] = new_value % 10
        carry = new_value // 10
        index -= 1

    if carry  == 1:
        A.insert(0,1)


A = [9,9,9]
increment(A)
print(A)
