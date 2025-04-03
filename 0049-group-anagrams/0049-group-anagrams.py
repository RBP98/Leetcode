class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for s in strs:
            sortedVal = tuple(sorted(s))
            if sortedVal not in dic:
                dic[sortedVal] = []

            dic[sortedVal].append(s)

        return list(dic.values())

