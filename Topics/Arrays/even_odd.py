def even_odd(A) -> None:

    def is_even(x):
        return x % 2 == 0
            
    i, j = 0, len(A) - 1

    while i < j:
        if is_even(A[j]) and not is_even(A[i]):
            A[i], A[j] = A[j], A[i]

        if is_even(A[i]):
            i += 1
            
        if not is_even(A[j]):
            j -= 1
        