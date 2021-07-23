package interview.design;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/16 10:40
 */
public class WordDictionary {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode root) {
        char[] charArray = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            // 对于'.'递归判断所有不为空的孩子
            if (charArray[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        if (search(word.substring(i + 1), node.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // 不含有当前节点
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
