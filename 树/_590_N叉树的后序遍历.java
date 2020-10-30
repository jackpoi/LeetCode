package 树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author beastars
 */
public class _590_N叉树的后序遍历 {
    List<Integer> list = new LinkedList<>();

    public List<Integer> postorder(Node root) {
//        recursivePostorder(root);
//        return list;
        return iterativePostorder(root);
    }

    /*
     * 迭代方法
     * 每次将节点存入栈中两次，每次循环将栈顶元素取出
     * 将取出的元素与栈顶元素比较：
     *       如果相同，说明还没有遍历过，判断是否有子树，
     *               有的话逆序压栈两次
     *               没有的话说明是叶子节点，先将叶子节点弹出，在进行添加
     *       如果不相同，说明已经遍历过该节点，直接将其添加
     * */
    public List<Integer> iterativePostorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null)
            return list;

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.poll();
            if (!curr.children.isEmpty() && curr == stack.peek()) {
                Collections.reverse(curr.children);
                for (Node child : curr.children) {
                    stack.push(child);
                    stack.push(child);
                }
            } else {
                if (curr == stack.peek())
                    stack.poll();
                list.add(curr.val);
            }
        }
        return list;
    }

    /**
     * 递归方法
     */
    public void recursivePostorder(Node root) {
        if (root == null)
            return;
        if (!root.children.isEmpty()) {
            for (Node child : root.children) {
                recursivePostorder(child);
            }
        }
        list.add(root.val);
    }
}
