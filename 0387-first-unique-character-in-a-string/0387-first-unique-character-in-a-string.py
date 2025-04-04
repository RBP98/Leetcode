class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict = Counter(s)

        for i, letter in enumerate(s):
            if dict[letter] == 1:
                return i
        return -1
