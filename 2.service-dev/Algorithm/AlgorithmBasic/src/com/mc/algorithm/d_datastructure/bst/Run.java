package com.mc.algorithm.d_datastructure.bst;

public class Run {
    public static void main(String[] args) {
        // Create a binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Insert elements into the BST
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        System.out.println("bfs: ");
        System.out.println(bst.bfs());

//        removeTest(bst);

        System.out.println("=====================");
        System.out.println("Preorder DFS: ");
        System.out.println(bst.preorderDfs());
        System.out.println("Preorder DFS Recursion:");
        System.out.println(bst.preorderDfsRecursion());

        System.out.println("=====================");
        System.out.println("Inorder DFS: ");
        System.out.println(bst.inorderDfs());
        System.out.println("Inorder DFS Recursion:");
        System.out.println(bst.inorderDfsRecursion());

        System.out.println("=====================");
        System.out.println("Postorder DFS: ");
        System.out.println(bst.postorderDfs());
        System.out.println("Postorder DFS Recursion:");
        System.out.println(bst.postorderDfsRecursion());
    }

    private static void removeTest(BinarySearchTree<Integer> bst) {
        System.out.println("=====================");
        bst.delete(6);
        System.out.println(bst.bfs());
    }
}
