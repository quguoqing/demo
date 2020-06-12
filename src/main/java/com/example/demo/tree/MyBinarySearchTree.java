package com.example.demo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: chunmu
 * @Date: 2020/6/10 20:26
 * @Description: 二叉搜索数的前中后序遍历，包括：递归和非递归(目前这三个遍历，都只能用栈实现非递归算法)
 */
public class MyBinarySearchTree {

    public  static void main(String[] args){
        TreeNode root = buildTree();
        System.out.println("#######前序遍历#######");
        preOrder(root);
        System.out.println();
        preOrderByStack(root);
        System.out.println();
        preOrderByStack2(root);

        System.out.println();
        System.out.println("#######中序遍历#######");
        inorder(root);
        System.out.println();
        inOrderByStack(root);
        System.out.println();
        inOrderByStack2(root);

        System.out.println();
        System.out.println("#######后序遍历#######");
        postorder(root);
        System.out.println();
        postorderByStack(root);
        System.out.println();
        postOrderByStack2(root);
    }


    private static void preOrder(TreeNode root){
        if(null == root){
            return;
        }
        System.out.print(root.getValue() + ",");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static void preOrderByStack(TreeNode root){
        if(null == root){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.getValue() + ",");
            if(null != node.getRight()){
                stack.push(node.getRight());
            }
            if(null != node.getLeft()){
                stack.push(node.getLeft());
            }
        }
    }

    private static void preOrderByStack2(TreeNode root){
        if(null == root){
            return;
        }
        List<Object> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                if(null != node.getRight()){
                    stack.push(node.getRight());
                }
                if(null != node.getLeft()){
                    stack.push(node.getLeft());
                }
                //非常妙啊！！！！
                //就是这两句话的位置，决定了前，中，后序遍历
                //前序：这两句在最后；中序：这两句在中间；后序：这两句在前面；
                //可以和后面的inOrderByStack2，postOrderByStack2进行比较
                stack.push(node);
                stack.push(null);
            }else {
                result.add(stack.pop().getValue());
            }
        }
        for(Object o : result){
            System.out.print(o + ",");
        }
    }

    private static void inorder(TreeNode root){
        if(null == root){
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getValue() + ",");
        inorder(root.getRight());
    }

    private static void inOrderByStack(TreeNode root){
        if(null == root){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode left = root.getLeft();
        //先初始化栈，直到可以弹出为止。
        while (null != left){
            stack.push(left);
            left = left.getLeft();
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.getValue() + ",");
            //弹出一个元素，要入栈右子树左节点
            TreeNode right = node.getRight();
            if(null != right){
                stack.push(right);
                TreeNode left1 = right.getLeft();
                while (null != left1){
                    stack.push(left1);
                    left1 = left1.getLeft();
                }
            }
        }
    }

    private static void inOrderByStack2(TreeNode root){
        if(null == root){
            return;
        }
        List<Object> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                if(null != node.getRight()){
                    stack.push(node.getRight());
                }
                stack.push(node);
                stack.push(null);
                if(null != node.getLeft()){
                    stack.push(node.getLeft());
                }
            }else {
                result.add(stack.pop().getValue());
            }
        }
        for(Object o : result){
            System.out.print(o + ",");
        }
    }

    private static void postorder(TreeNode root){
        if(null == root){
            return;
        }
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getValue() + ",");
    }

    private static void postorderByStack(TreeNode root){
        if(null == root){
            return;
        }
        List<Object> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.getValue());
            if(null != node.getLeft()){
                stack.push(node.getLeft());
            }
            if(null != node.getRight()){
                stack.push(node.getRight());
            }
        }
        //翻转result
        Collections.reverse(result);
        for(Object o : result){
            System.out.print(o + ",");
        }
    }

    private static void postOrderByStack2(TreeNode root){
        if(null == root){
            return;
        }
        List<Object> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(null != node){
                //这个再次push和push null，真的秀
                stack.push(node);
                stack.push(null);
                if(null != node.getRight()){
                    stack.push(node.getRight());
                }
                if(null != node.getLeft()){
                    stack.push(node.getLeft());
                }
            }else {
                result.add(stack.pop().getValue());
            }
        }
        for(Object o : result){
            System.out.print(o + ",");
        }
    }


    /**
     * 二叉搜索树的构造，有很多种
     * @return
     */
    private static TreeNode buildTree(){
        //这里先随便构造一个好了。
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(8);
        root.setLeft(left);
        root.setRight(right);

        TreeNode left_left = new TreeNode(1);
        TreeNode left_right = new TreeNode(4);
        left.setLeft(left_left);
        left.setRight(left_right);

        TreeNode right_left = new TreeNode(6);
        TreeNode right_right = new TreeNode(9);
        right.setLeft(right_left);
        right.setRight(right_right);

        TreeNode left_left_left = new TreeNode(0);
        left_left.setLeft(left_left_left);

        return root;
    }
}
