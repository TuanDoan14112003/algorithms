# The h-index is a metric that measures both the productivity and citation impact of a researcher.
# Specifically, a researcher's h-index is the largest number he such that the researcher has published
# h papers that have each been cited at least h times.
# Input: [1,4,1,4,2,1,3,5,6] (The citation numbers of a researcher's papers)
# Output: 4


def h_index(citation_numbers):
    citation_numbers.sort()
    n = len(citation_numbers)
    for i in range(n - 1, -1, -1):
        if (citation_numbers[i] <  n - i):
            return n - i - 1
    return n
        
input = [1,4,1,4,2,1,3,5,6]   
output = h_index(input)
