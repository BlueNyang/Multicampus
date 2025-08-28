package com.mc.algorithm.d_datastructure.bst;

import com.mc.algorithm.d_datastructure.Queue.MyQueue;
import com.mc.algorithm.d_datastructure.list.MyLinkedList;
import com.mc.algorithm.d_datastructure.stack.MyStack;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    int size;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E data) {
        Node<E> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node<E> current = root;
        while (true) {
            if (data.compareTo(current.getData()) < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    break;
                }
                current = current.getLeft();
            } else if (data.compareTo(current.getData()) > 0) {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    break;
                }
                current = current.getRight();
            } else {
                // When data is duplicated
                return;
            }
        }
        size++;
    }

    public void delete(E data) {
        Node<E> parent = null;
        Node<E> current = root;

        while (current != null && data.compareTo(current.getData()) != 0) {
            parent = current;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();

            } else {
                current = current.getRight();
            }
        }

        if (current == null) {
            return;
        }

        if (current.getLeft() != null && current.getRight() != null) {
            Node<E> successorParent = current;
            Node<E> successor = current.getRight();

            while (successor.getLeft() != null) {
                successorParent = successor;
                successor = successor.getLeft();
            }

            current.setData(successor.getData());

            parent = successorParent;
            current = successor;
        }

        deleteNode(current, parent);
    }

    private void deleteNode(Node<E> current, Node<E> parent) {
        Node<E> child = (current.getLeft() != null) ? current.getLeft() : current.getRight();

        if (parent == null) {
            root = child;
        } else if (current.equals(parent.getLeft())) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }


        size--;
    }

    public MyLinkedList<E> bfs() {
        MyQueue<Node<E>> queue = new MyQueue<>();
        MyLinkedList<E> result = new MyLinkedList<>();

        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            System.out.print("Level " + level + ": ");
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node<E> node = queue.poll();
                System.out.print(node.getData() + " ");
                result.add(node.getData());

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            level++;
            System.out.println();
        }
        return result;
    }

    public MyLinkedList<E> preorderDfs() {
        MyStack<Node<E>> stack = new MyStack<>();
        MyLinkedList<E> result = new MyLinkedList<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            result.add(node.getData());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return result;
    }

    public MyLinkedList<E> preorderDfsRecursion() {
        MyLinkedList<E> result = new MyLinkedList<>();
        if (root == null) {
            return result;
        }
        preorderDfsHelper(root, result);
        return result;
    }

    private void preorderDfsHelper(Node<E> node, MyLinkedList<E> result) {
        if (node == null) {
            return;
        }

        result.add(node.getData());
        preorderDfsHelper(node.getLeft(), result);
        preorderDfsHelper(node.getRight(), result);
    }

    public MyLinkedList<E> inorderDfs() {
        MyStack<Node<E>> stack = new MyStack<>();
        MyLinkedList<E> result = new MyLinkedList<>();

        if (root == null) {
            return result;
        }

        Node<E> current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            Node<E> node = stack.pop();
            result.add(node.getData());

            if (node.getRight() != null) {
                current = node.getRight();
            }
        }

        return result;
    }

    public MyLinkedList<E> inorderDfsRecursion() {
        MyLinkedList<E> result = new MyLinkedList<>();
        if (root == null) {
            return result;
        }

        inorderDfsHelper(root, result);
        return result;
    }

    private void inorderDfsHelper(Node<E> node, MyLinkedList<E> result) {
        if (node == null) {
            return;
        }
        inorderDfsHelper(node.getLeft(), result);
        result.add(node.getData());
        inorderDfsHelper(node.getRight(), result);
    }

    public MyLinkedList<E> postorderDfs() {
        MyStack<Node<E>> stack1 = new MyStack<>();
        MyStack<Node<E>> stack2 = new MyStack<>();
        MyLinkedList<E> result = new MyLinkedList<>();

        if (root == null) {
            return result;
        }

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node<E> node = stack1.pop();
            stack2.push(node);

            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            Node<E> node = stack2.pop();
            result.add(node.getData());
        }

        return result;
    }

    public MyLinkedList<E> postorderDfsRecursion() {
        MyLinkedList<E> result = new MyLinkedList<>();
        if (root == null) {
            return result;
        }
        postorderDfsHelper(root, result);
        return result;
    }

    private void postorderDfsHelper(Node<E> node, MyLinkedList<E> result) {
        if (node == null) {
            return;
        }
        postorderDfsHelper(node.getLeft(), result);
        postorderDfsHelper(node.getRight(), result);
        result.add(node.getData());
    }
}
