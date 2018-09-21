///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             GraphNode.java
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
 * GraphNode class maintains a vertex name and a list of adjacent vertices
 * which stores the neighbors in a sorted list.
 */

public class GraphNode implements Comparable<GraphNode> {
	private String nodeName;
	private boolean spycam;
	private List<Neighbor> neighbors;
	private boolean visited;
	private List<String> names;

	/** 
	 * Constructs a GraphNode with the vertex name and empty neighbors list.
	 * 
	 * @param name of the vertex, which needs to be unique
	 */
	public GraphNode(String name) {
		// Used to hold neighbors of this node
		neighbors = new ArrayList<Neighbor>();
		// Holds names of neighbors
		names = new ArrayList<String>();
		// Holds whether a spycam is at this node
		spycam = false;
		// name of node
		nodeName = name;
		// marks whether node was visited used for DFS
		visited = false;
	}

	/** 
	 * Returns the name of the vertex. 
	 *
	 * @return the name of this GraphNode
	 */
	public String getNodeName() {
		return nodeName;
	}

	/** 
	 * Returns the neighbors of the vertex. 
	 *
	 * @return the neighbors of this GraphNode
	 */
	public List<Neighbor> getNeighbors() {
		return neighbors;
	}

	/**
	 * Sets the visited flag of this vertex.
	 *
	 * @param flagVal boolean value used to set the flag
	 */
	public void setVisited(boolean flagVal) {
		visited = flagVal;
	}

	/**
	 * Gets the visited flag of this vertex.
	 *
	 * @return visited boolean value 
	 */
	public boolean getVisited() {
		return visited;
	}

	/** 
	 * Return the results of comparing this node's name to the other node's 
	 * name. 
	 * 
	 * @param otherNode GraphNode instance whose vertex name is required for 
	 * comparison
	 * @return negative value or 0 or positive value
	 */
	public int compareTo(GraphNode otherNode) {
		return this.nodeName.compareTo(otherNode.getNodeName());
	}

	/** 
	 * Adds a new neighbor and maintains sorted order of neighbors by neighbor 
	 * name.
	 *
	 * @param neighbor an adjacent node 
	 * @param cost to move to that node (from this node)
	 */
	public void addNeighbor(GraphNode neighbor, int cost) {
		Neighbor newNeighbor = new Neighbor(cost, neighbor);
		neighbors.add(newNeighbor);
		names.add(neighbor.getNodeName());
		neighbors.sort(null);
	}

	/** 
	 * Prints a list of neighbors of this GraphNode and the cost of the edge to 
	 * them. 
	 */
	public void displayCostToEachNeighbor() {
		for (int i = 0; i < neighbors.size();i++) {
			System.out.println(neighbors.get(i).getCost() + " " 
					+ neighbors.get(i).getNeighborNode().getNodeName());
		}
	}
	
	/** 
	 * Returns cost to reach the neighbor.
	 *
	 * @param neighborName name of neighbor
	 * @return cost to neighborName
	 * @throws NotNeighborException if neighborName is not a neighbor
	 */
	public int getCostTo(String neighborName) throws NotNeighborException {
		if (neighborName == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < neighbors.size(); i++) {
			if (neighborName.equals(neighbors.get(i).getNeighborNode()
					.getNodeName())) {
				return neighbors.get(i).getCost();
			}
		}
		throw new NotNeighborException();
	}

	/** 
	 * Returns the GraphNode associated with name that is a neighbor of the 
	 * current node.
	 *
	 * @param neighborName name of neighbor
	 * @return the GraphNode associated with name that is neighbor of this node
	 * @throws NotNeighborException if neighborName is not a neighbor
	 */
	public GraphNode getNeighbor(String neighborName) throws NotNeighborException {
		if (neighborName == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < names.size(); i++) {
			if (neighborName.equals(neighbors.get(i).getNeighborNode()
					.getNodeName())) {
				return neighbors.get(i).getNeighborNode();
			}
		}

		throw new NotNeighborException();
	}

	/** 
	 * Returns an iterator that can be used to find neighbor names
	 * of this GraphNode.
	 *
	 * @return iterator of String node labels
	 */
	public Iterator<String> getNeighborNames() {
		return names.iterator();
	}

	/** 
	 * Sets/unsets spycam at this node.
	 *
	 * @param cam indicates whether the node now has a spycam
	 */
	public void setSpycam(boolean cam) {
		spycam = cam;
	}

	/** 
	 * Returns information about spycam presense in this node.
	 *
	 * @return true if the GraphNode has a spycam
	 */
	public boolean getSpycam() {
		return spycam;
	}

	/** 
	 * Returns true if this node name is a neighbor of current node.
	 *
	 * @param neighborName name of neighbor
	 * @return true if the node is an adjacent neighbor
	 */
	public boolean isNeighbor(String neighborName) {
		if (neighborName == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals(neighborName)) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * Returns the name of this node.
	 *
	 * @return name of node
	 */
	public String toString() {
		return this.nodeName;
	}
}