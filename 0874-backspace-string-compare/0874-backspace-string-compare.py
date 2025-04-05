class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        p1 = len(s) - 1
        p2 = len(t) - 1

        skipS = 0
        skipT = 0
        while p1 >=0 or p2 >= 0:
            while p1 >= 0:
                if s[p1] == '#':
                    skipS += 1
                    p1 -= 1
                elif skipS > 0:
                    skipS -= 1
                    p1 -= 1
                else:
                    break
            while p2 >= 0:
                if t[p2] == '#':
                    skipT += 1
                    p2 -= 1
                elif skipT > 0:
                    skipT -= 1
                    p2 -= 1
                else:
                    break
            if p1 >= 0 and p2 >= 0 and s[p1] != t[p2]:
                return False
            if (p1 >= 0) != (p2 >= 0):
                return False
            p1 -= 1
            p2 -= 1
        return True