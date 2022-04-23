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
            } else {
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

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
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
