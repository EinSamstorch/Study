package interview.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/18 10:56
 */
public class FileSystem {
    class Node {
        /**
         * key：子目录或者文件名称
         * value: 子目录或者文件的节点对象
         */
        Map<String, Node> fileList = new TreeMap<>();

        /**
         * 如果当前目录是文件，记录文件内容
         */
        StringBuilder text = new StringBuilder();
    }

    Node root = new Node();

    public FileSystem() {
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) {
                continue;
            }
            node = node.fileList.get(dir);
        }
        return new ArrayList<>(node.fileList.keySet());
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) {
                continue;
            }
            Node child = node.fileList.get(dir);
            if (child == null) {
                child = new Node();
                node.fileList.put(dir, child);
            }
            node = child;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        Node node = root;
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if ("".equals(dir)) {
                continue;
            }
            Node child = node.fileList.get(dir);
            if (child == null) {
                child = new Node();
                node.fileList.put(dir, child);
            }
            if (i == dirs.length - 1) {
                child.text.append(content);
                child.fileList.put(dir, null);
            }
            node = child;
        }
    }

    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) continue;
            node = node.fileList.get(dir);
        }
        return node.text.toString();
    }

}


