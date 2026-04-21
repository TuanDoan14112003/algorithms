# Write a program that takes an array A and an index i into A, and rearranges the 
# elements such that all elements less than `A[i]` (the "pivot") appear first, 
# followed by elements equal to the pivot, followed by elements greater than the pivot

# Naive solution: create 3 subarrays for each category. This solution takes O(n) time and space

# We can reduce the space complexity from O(n) to O(1) at the cost of increased time complexity 
# to O(n^2). To do this, we go through the array twice, the first time, we push the elements
# less than the pivot to the top of the array. For the second pass, we push the elements more than
# the pivot to the top of the array:

def dutch_flag_partition(pivot_index, A) -> None:
    pivot = A[pivot_index]
    for i in range(len(A)):
        for j in range(i+1,len(A)):
            if A[j] < pivot:
                A[i], A[j] = A[j], A[i]
                break
            
    for i in reversed(range(len(A))):
        for j in reversed(range(i)):
            if A[j] > pivot:
                A[i], A[j] = A[j], A[i]
                break


# To reduce this solution time complextity, we need to gain 1 important insight. For each iteration, 
# we start from the beginning (either i or j) to look for the next suitable elements. We can optimize
# this by start looking from the last position from the previous iteration

def dutch_flag_partition(pivot_index, A) -> None:
    pivot = A[pivot_index]
    index = 0 
    for i in range(len(A)):
        if A[i] < pivot:
            A[index], A[i] = A[i], A[index]
            index += 1
                
    index = len(A) - 1
    for i in reversed(range(len(A))):
        if A[i] > pivot:
            A[index], A[i] = A[i], A[index]
            index -= 1

# the time complexity is O(n) and the space complexity is O(1)



# The below solution use only 1 pass to classify
def dutch_flag_partition(pivot_index, A) -> None:
    pivot = A[pivot_index]
    
    unclassified_start, unclassified_end = 0, len(A) - 1
    smaller_end = 0

    while unclassified_start <= unclassified_end:
        if A[unclassified_start] < pivot:
            A[smaller_end], A[unclassified_start] = A[unclassified_start], A[smaller_end]
            unclassified_start += 1
            smaller_end += 1
        elif A[unclassified_start] > pivot:
            A[unclassified_start], A[unclassified_end] = A[unclassified_end], A[unclassified_start]
            unclassified_end -= 1

        else:
            unclassified_start += 1