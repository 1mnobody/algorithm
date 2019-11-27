package leetcode.clone.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzhsh on 11/27/2019.
 */
class Solution {

    // 保存已经克隆过的节点，遇到克隆过的节点时直接从这里面拿已有的节点
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        map.clear();
        return _cloneGraph(node);
    }

    public Node _cloneGraph(Node node) {
        if (node != null) {
            Node newNode = new Node();
            newNode.val = node.val;
            if (node.neighbors != null) {
                map.put(node, newNode);
                List<Node> newNodeNeighbors = new ArrayList<>();
                newNode.neighbors = newNodeNeighbors;
                for (Node neighbor : node.neighbors) {
                    if (map.containsKey(neighbor)) {
                        newNodeNeighbors.add(map.get(neighbor));
                    } else {
                        newNodeNeighbors.add(_cloneGraph(neighbor));
                    }
                }
            }
            return newNode;
        }
        return null;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
