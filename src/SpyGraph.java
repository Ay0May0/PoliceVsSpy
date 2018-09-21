///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             SpyGraph.java
// Semester:         CS367 Summer 2017
//
// Author:           Manish Dhungana
// CS Login:         dhungana
// Lecturer's Name:  Meena Syamkumar
// Lab Section:      
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair Partner:     Jack Cerhan
// Email:            jcerhan@wisc.edu
// CS Login:         cerhan
// Lecturer's Name:  Meena Syamkumar
// Lab Section:      
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
// 
// Online sources:   StackOverflow
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
/**
 * Stores all vertexes as a list of GraphNodes.  Provides necessary graph
 * operations as need by the SpyGame class.
 */
public class SpyGraph implements Iterable<GraphNode> {

	private List<GraphNode> vlist;

	/**
	 * Initializes an empty list of GraphNode objects
	 */
	public SpyGraph(){
		vlist = new ArrayList<GraphNode>();
	}

	/**
	 * Add a vertex with this label to the list of vertexes.
	 * No duplicate vertex names are allowed.
	 * @param name The name of the new GraphNode to create and add to the list.
	 */
	public void addGraphNode(String name){
		for (int i =0; i < vlist.size(); i++) {
			if (vlist.get(i).getNodeName().equals(name)){
				return;
			}
		}
		vlist.add(new GraphNode(name));
	}

	/**
	 * Adds v2 as a neighbor of v1 and adds v1 as a neighbor of v2.
	 * Also sets the cost for each neighbor pair.
	 *   
	 * @param v1name The name of the first vertex of this edge
	 * @param v2name The name of second vertex of this edge
	 * @param cost The cost of traveling to this edge
	 * @throws IllegalArgumentException if the names are the same
	 */
	public void addEdge(String v1name, String v2name, int cost) 
			throws IllegalArgumentException {
		if (v1name.equals(v2name)) {
			throw new IllegalArgumentException();
		}
		GraphNode v1Node = getNodeFromName(v1name);
		GraphNode v2Node = getNodeFromName(v2name);
		if (v1Node == null || v2Node == null) {
			return;
		}
		v1Node.addNeighbor(v2Node, cost);
		v2Node.addNeighbor(v1Node, cost);
	}

	/**
	 * Return an iterator through all nodes in the SpyGraph
	 * @return iterator through all nodes in alphabetical order.
	 */
	public Iterator<GraphNode> iterator() {
		return vlist.iterator();
	}

	/**
	 * Return Breadth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in BFS traversal
	 * @param end Last node (match node) in BFS traversal
	 * @return The BFS traversal from start to end node.
	 */
	public List<Neighbor> BFS( String start, String end ) {
		GraphNode startNode = getNodeFromName(start);
    	GraphNode endNode = getNodeFromName(end);
    	if (startNode != null && endNode != null) {
    		// sets up queue for bfs traversal
			Queue<Neighbor> queue = new LinkedList<Neighbor>();
			// stores successors of current node
			ArrayList<Neighbor> successor = new ArrayList<Neighbor>();
			// stores predecessors of current node
			ArrayList<Neighbor> predecessor = new ArrayList<Neighbor>();
			// stores visited nodes
			ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
			queue.add(new Neighbor(0, startNode));
			visited.add(startNode);
			// returns true when end node is found
			boolean isFound = false;
			while (!isFound && !queue.isEmpty()) {
				Neighbor currNode = queue.remove();
				for (Neighbor neighbor : currNode.getNeighborNode()
						.getNeighbors()) {
					if (neighbor.getNeighborNode().getNodeName().equals(end)) {
						successor.add(neighbor);
						predecessor.add(currNode);
						isFound = true;
						break;
					}
					if (!visited.contains(neighbor.getNeighborNode())) {
						successor.add(neighbor);
						predecessor.add(currNode);
						visited.add(neighbor.getNeighborNode());
						queue.add(neighbor);
					}
				}
			}
			if (isFound) {
				// new list to store nodes stored in successor
				ArrayList<Neighbor> bfsList = new ArrayList<Neighbor>();
				int index = successor.size() - 1;
				while (index != -1) {
					bfsList.add(0, successor.get(index));
					index = successor.indexOf(predecessor.get(index));
				}
				return bfsList;
			}
		}
		return null;
    }
	
	/**
	 * @param name Name corresponding to node to be returned
	 * @return GraphNode associated with name, null if no such node exists
	 */
	public GraphNode getNodeFromName(String name){
		for ( GraphNode n : vlist ) {
			if (n.getNodeName().equalsIgnoreCase(name))
				return n;
		}
		return null;
	}

	/**
	 * Return Depth First Search list of nodes on path 
	 * from one Node to another.
	 * @param start First node in DFS traversal
	 * @param end Last node (match node) in DFS traversal
	 * @return The DFS traversal from start to end node.
	 */

	public List<Neighbor> DFS(String start, String end) {
		// set all nodes as unvisited
		for (GraphNode setNodes : vlist) {
			setNodes.setVisited(false);
		}
		GraphNode startNode = getNodeFromName(start);
		List<Neighbor> searchList = new ArrayList();
		DFS(end, startNode, searchList); 
		return searchList;
	}
	private boolean DFS(String end, GraphNode currNode, 
			List<Neighbor> searchList) {
		if (currNode.getNodeName().equals(end)) {
			return true;
		}
		if (currNode.getVisited()) {
			return false;
		}
		currNode.setVisited(true);
		// adds nodes to search list but if path does not reach target
		// via that path removes those nodes from lists
		for(Neighbor N : currNode.getNeighbors()) {
			searchList.add(N);
			if (DFS(end, N.getNeighborNode(), searchList)) {
				return true;
			}
			else {
				searchList.remove(N);
			}
		}
		return false;
	}

	/**
	 * OPTIONAL: Students are not required to implement Dijkstra's ALGORITHM
	 *
	 * Return Dijkstra's shortest path list of nodes on path 
	 * from one Node to another.
	 * @param start First node in path
	 * @param end Last node (match node) in path
	 * @return The shortest cost path from start to end node.
	 */
	public List<Neighbor> Dijkstra(String start, String end){
		return new ArrayList();
	}

	/**
	 * DO NOT EDIT THIS METHOD 
	 * @return a random node from this graph
	 */
	public GraphNode getRandomNode() {
		if (vlist.size() <= 0 ) {
			System.out.println("Must have nodes in the graph before randomly "
					+ "choosing one.");
			return null;
		}
		int randomNodeIndex = Game.RNG.nextInt(vlist.size());
		return vlist.get(randomNodeIndex);
	}
}
