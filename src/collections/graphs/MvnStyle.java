package collections.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MvnStyle
{

    static Graph<String> graph = new Graph<>(false);
    static {
        GNode<String> nodeA = new GNode<>();
        nodeA.setData("A");
        GNode<String> nodeB = new GNode<>();
        nodeB.setData("B");
        GNode<String> nodeC = new GNode<>();
        nodeC.setData("C");
        GNode<String> nodeD = new GNode<>();
        nodeD.setData("D");
        GNode<String> nodeE = new GNode<>();
        nodeE.setData("E");
        GNode<String> nodeF = new GNode<>();
        nodeF.setData("F");
        List<GNode<String>> connections = new ArrayList<>();
        connections.add(nodeB);
        graph.addNode(nodeA, connections);
        
        connections = new ArrayList<>();
        connections.add(nodeC);
        graph.addNode(nodeB, connections);
        
        connections = new ArrayList<>();
        connections.add(nodeD);
        graph.addNode(nodeC, connections);

        connections = new ArrayList<>();
        connections.add(nodeE);
        graph.addNode(nodeD, connections);
        
        graph.addNode(nodeF, null);
        
    }
    
    public static void main(String[] args)
    {
        MvnStyle m = new MvnStyle();
        Stack<GNode> stack = new Stack<GNode>();
    }
    
    private void printGraph(Stack<GNode> stack) {
        
        if(stack == null) {
            return;
        }
        GNode<String> node = stack.pop();
        
    }

}
