import java.util.Stack;

public class DFS {
    
    public static boolean dfs(int[][] graph, int startNode, int targetNode) {
        int n = graph.length; // Number of nodes in the graph
        boolean[] visited = new boolean[n]; // Array to track visited nodes
        
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode); // Push the starting node onto the stack
        
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            
          
            if (currentNode == targetNode) {
                return true;
            }
            
           
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                
        
                for (int i = 0; i < n; i++) {
                    if (graph[currentNode][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
     
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
