package com.example.demo.tree;

/**
 * @author: chunmu
 * @Date: 2020/6/10 20:24
 * @Description:
 */
public class TreeNode {

    private Object value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(Object value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
