package ru.turubarov.sortariatest;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("input.txt")));
        String result;
        MyScanner sc = new MyScanner(input);
        TypesOfSymbol curType;
        TreeNode curNode = null;
        TreeNode root = null;
        TreeNode curChild = null;
        int bracketCount = 0;
        while ((curType = sc.Scan()) != TypesOfSymbol.END) {
            switch (curType) {
                case TEXT:
                    if (curNode == null) {
                        root = new TreeNode(null, sc.getLexem().toString());
                        curNode = root;
                        curChild = curNode;
                    } else {
                        curChild = curNode.addChild(sc.getLexem().toString());
                    }
                    break;
                case LEFT_BRACKET:
                    bracketCount ++;
                    curNode = curChild;
                    break;
                case RIGHT_BRACKET:
                    bracketCount --;
                    curNode = curNode.parent;
                    break;
                case COMMA:
                    break;
            }
        }
        if (bracketCount != 0) {
            result = "ERROR";
        } else {
            result = TreeWalker.treeWalk(root).toString();
        }
        try (PrintWriter out = new PrintWriter("output.txt")) {
            out.println(result);
        }
    }
}
