from collections import defaultdict
class WordDistance:

    def __init__(self, words: List[str]):
        self.posMap = defaultdict(list)
        for i, w in enumerate(words):
            self.posMap[w].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        posList1 = self.posMap[word1]
        posList2 = self.posMap[word2]
        len1 = len(posList1)
        len2 = len(posList2)
        diff = float('inf')
        i = j = 0
        while i < len1 and j < len2:
            diff = min(diff, abs(posList1[i] - posList2[j]))
            if posList1[i] < posList2[j]:
                i += 1
            else:
                j += 1
        return diff


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)