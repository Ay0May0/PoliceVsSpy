///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             NotNeighborException.java
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

public class NotNeighborException extends Exception {
	/**
	 * Default constructor
	 */
	public NotNeighborException() {
		
	}
	/**
	 * Constructor with message passed
	 * @param message return message when exception occurs
	 */
	public NotNeighborException(String message) {
		super(message);
	}
}