import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
    TreeNode root;

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode temp = root;
        TreeNode prev = null;

        while (temp != null) {
            prev = temp;
            if (val < temp.value) {
                temp = temp.left;
            } else {// if (val > temp.value) {
                temp = temp.right;
            }
        }

        if (prev.value > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
    }

    public TreeNode delete(TreeNode root, int target) {
        if (root == null)
            return root;

        if (target > root.value) {
            root.right = delete(root.right, target);
        } else if (target < root.value) {
            root.left = delete(root.left, target);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = inOrderSuccessor(root.right);

            root.right = delete(root.right, root.value);
        }

        return root;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public void inOrder() {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode temp = root;

        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();
            System.out.println(temp.value + " ");
            temp = temp.right;
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void postOrder() {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            s2.push(curr);

            if (curr.left != null)
                s.push(curr.left);
            if (curr.right != null)
                s.push(curr.right);
        }

        while (!s2.isEmpty())
            System.out.println(s2.pop().value);
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder() {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            System.out.println(curr.value + " ");

            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
        }
    }

    public void levelOrder() {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            double sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                System.out.println(front.value);
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
        }
    }

    public int inOrderSuccessor(TreeNode node) {
        int succ = node.value;
        while (node.left != null) {
            succ = node.left.value;
            node = node.left;
        }
        return succ;
    }
}
