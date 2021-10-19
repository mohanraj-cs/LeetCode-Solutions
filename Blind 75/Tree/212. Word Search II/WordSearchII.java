class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List < String > findWords(char[][] board, String[] words) {
        List < String > res = new ArrayList < > ();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List < String > res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null)
            return;
        node = node.children[c - 'a'];
        if (node.word != null) { // found one
            res.add(node.word);
            node.word = null; // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) 
            dfs(board, i - 1, j, node, res); //Down
        if (j > 0) 
            dfs(board, i, j - 1, node, res); //LEFT
        if (i < board.length - 1) 
            dfs(board, i + 1, j, node, res); //TOP
        if (j < board[0].length - 1) 
            dfs(board, i, j + 1, node, res); //RIGHT
        board[i][j] = c;
    }
}