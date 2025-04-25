import java.util.Stack;

public class DFS {
    
    // Function to perform DFS
    public static boolean dfs(int[][] graph, int startNode, int targetNode) {
        int n = graph.length; // Number of nodes in the graph
        boolean[] visited = new boolean[n]; // Array to track visited nodes
        
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode); // Push the starting node onto the stack
        
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            
            // If the target node is found, return true
            if (currentNode == targetNode) {
                return true;
            }
            
            // If the current node has not been visited, mark it as visited
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                
                // Push all adjacent nodes to the stack
                for (int i = 0; i < n; i++) {
                    if (graph[currentNode][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        
        // If the loop ends without finding the target, return false
        return false;
    }
    
    public static void main(String[] args) {
        // Example graph as an adjacency matrix (undirected graph)
        // 0 - 1 - 2
        // |     |
        // 3 - 4
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };
        
        // Searching for a node in the graph
        int startNode = 0; // Start DFS from node 0
        int targetNode = 4; // Target node to search for
        
        boolean found = dfs(graph, startNode, targetNode);
        
        if (found) {
            System.out.println("Node " + targetNode + " found.");
        } else {
            System.out.println("Node " + targetNode + " not found.");
        }
    }
}
