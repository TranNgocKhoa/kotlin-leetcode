package lc_1948


class Solution {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val root = Trie()
        for (path in paths) {
            var cur = root
            for (name in path) {
                if (!cur.children.containsKey(name)) {
                    cur.children.put(name, Trie())
                }
                cur = cur.children[name]!!
            }
        }

        val g: MutableMap<String, Trie> = HashMap()

        fun dfs(node: Trie): String {
            if (node.children.isEmpty()) {
                return ""
            }
            val subs: MutableList<String> = ArrayList<String>()
            for (entry in node.children.entries) {
                subs.add(entry.key + "(" + dfs(entry.value) + ")")
            }
            subs.sort()
            val s = subs.joinToString("")
            if (g.containsKey(s)) {
                node.deleted = true
                g[s]!!.deleted = true
            } else {
                g.put(s, node)
            }

            return s
        }

        dfs(root)

        val ans: MutableList<MutableList<String>> = ArrayList()
        val path: MutableList<String> = ArrayList()

        fun dfs2(node: Trie) {
            if (node.deleted) {
                return
            }
            if (!path.isEmpty()) {
                ans.add(ArrayList(path))
            }
            for (entry in node.children.entries) {
                path.add(entry.key)
                dfs2(entry.value)
                path.removeAt(path.size - 1)
            }
            return
        }


        dfs2(root)

        return ans
    }

    class Trie {
        var children: MutableMap<String, Trie> = HashMap<String, Trie>()
        var deleted: Boolean = false
    }
}