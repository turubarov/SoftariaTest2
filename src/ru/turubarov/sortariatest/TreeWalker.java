package ru.turubarov.sortariatest;

public class TreeWalker {

    public static StringBuilder treeWalk(TreeNode node) {
        StringBuilder result = new StringBuilder();
        if (node.childs.size() == 0) {
            return new StringBuilder(node.getValue());
        }
        if (node == null) {
            return new StringBuilder();
        }
        result.append(node.value);
        result.append("(");
        for (int i = node.childs.size() - 1; i >= 0 ;i--) {
            result.append(treeWalk(node.childs.get(i)));
            if (i > 0) {
                result.append(",");
            }
        }
        result.append(")");
        return result;
    }
}
