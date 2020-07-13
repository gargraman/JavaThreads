package collections.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V>
{
    boolean isBidirectional = false;

    List<GNode<V>> nodes = new ArrayList<>();

    Map<GNode<V>, Set<GNode<V>>> edges = new HashMap<>();

    public Graph(boolean twoWayDirection)
    {
        this.isBidirectional = twoWayDirection;
    }

    public List<GNode<V>> allNodes()
    {
        return nodes;
    }

    public Map<GNode<V>, Set<GNode<V>>> allEdges()
    {
        return edges;
    }

    public void addNode(GNode<V> node, List<GNode<V>> connections)
    {

        if (connections != null) {
            connections.forEach(x -> addchild(node, x));
        }
        nodes.add(node);

    }

    private void addchild(GNode<V> node, GNode<V> x)
    {
        Set<GNode<V>> edge = edges.get(node);
        if (edge == null) {
            edge = new HashSet<>();
        }
        edge.add(x);
        edges.put(node, edge);

        if (isBidirectional) {
            edge = edges.get(x);
            if (edge == null) {
                edge = new HashSet<>();
            }
            edge.add(node);
            edges.put(x, edge);
        }
    }

    public void deleteNode(GNode<V> node)
    {
        nodes.remove(node);
        edges.remove(node);
        edges.forEach((key, value) -> value.remove(node));
    }
}
