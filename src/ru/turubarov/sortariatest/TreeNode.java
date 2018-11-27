package ru.turubarov.sortariatest;

import java.util.ArrayList;

public class TreeNode {
    String value;
    ArrayList<TreeNode> childs;
    TreeNode parent;

    public TreeNode(TreeNode parent, String value) {
        this.parent = parent;
        this.value = value;
        this.childs = new ArrayList<>();
    }

    public TreeNode addChild(String value) {
        TreeNode result = new TreeNode(this, value);
        childs.add(result);
        return result;
    }

    public String getValue() {
        return value;
    }
}
