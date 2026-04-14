class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        return ((rec2[0] <= rec1[0] and rec1[0] < rec2[2]) or  (rec1[0] <= rec2[0] and rec2[0] < rec1[2])) and ((rec2[1] <= rec1[1] and rec1[1] < rec2[3]) or  (rec1[1] <= rec2[1] and rec2[1] < rec1[3]))