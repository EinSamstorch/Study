package myhash.demo1;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/7/20 11:02
 */

import java.util.Objects;

class TreeNode {
    public String key;
    public String val;
    public TreeNode next;


    public TreeNode(String key, String val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(key, treeNode.key) &&
                Objects.equals(val, treeNode.val) &&
                Objects.equals(next, treeNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val, next);
    }
}


public class MyHashMap {
    public TreeNode[] array = new TreeNode[101];
    public int size;

    public boolean put(String key, String val) {
        int hasValues = key.hashCode();
        int index = hasValues / array.length;

        TreeNode treeNode = array[index];
        if (treeNode == null) {
            array[index] = new TreeNode(key, val);
            size++;
            return true;
        }

        TreeNode cur = new TreeNode(key, val);
        if (contains(cur)) {
            return false;
        }

        cur.next = array[index];
        array[index] = cur;
        return true;

    }

    public boolean contains(TreeNode treeNode) {
        int hasValues = treeNode.key.hashCode();
        int index = hasValues / array.length;

        TreeNode cur = array[index];
        if (cur == null) {
            return false;
        }

        while (cur != null) {
            if (cur.key.equals(treeNode.key)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public boolean remove(TreeNode treeNode) {
        int hasValues = treeNode.key.hashCode();
        int index = hasValues / array.length;

        TreeNode cur = array[index];
        if (cur == null) {
            return false;
        }
        //设置一个前驱节点
        TreeNode prev = null;
        while (cur != null) {
            if (cur.key.equals(treeNode.key)) {
                if (prev == null) {
                    //头节点是要移除的节点
                    array[index] = array[index].next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

}

