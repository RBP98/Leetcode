class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        freqDict = {}
        for letter in s:
            freqDict[letter] = freqDict.get(letter, 0) + 1
        for letter in t:
            freqDict[letter] = freqDict.get(letter, 0) - 1
            
        for val in freqDict.values():
            if val != 0:
                return False
        return True

        
        
        