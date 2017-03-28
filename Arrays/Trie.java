
/**
 * Created by juanyan.li on 3/23/17.
 */
public class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26]; // a-z
        isWord = false;
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            isWord = true;
            return;
        }
        int pos = word.charAt(0) - 'a';
        if (children[pos] == null) children[pos] = new Trie();
        children[pos].insert(word.substring(1));
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            if (isWord) return true;
            return false;
        }
        boolean found = false;
        int pos = word.charAt(0) - 'a';
        if (children[pos] == null) return false;
        found |= children[pos].search(word.substring(1));
        return found;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return true;
        boolean found = false;
        int pos = prefix.charAt(0) - 'a';
        if (children[pos] == null) return false;
        found |= children[pos].startsWith(prefix.substring(1));
        return found;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("insane");
        trie.insert("insanity");
        boolean res = trie.search("insane"); // true
        res = trie.search("insan"); // false
        res = trie.startsWith("insan"); // true
        System.out.println("Finished");
    }
}
