class Solution(object):
    def checkIfPangram(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        unique = set(sentence)
        return len(unique) == 26
        