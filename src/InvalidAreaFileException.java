///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// File:             InvalidAreaFileException.java
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

public class InvalidAreaFileException extends Exception {
    public static final String example =
"NODES\na\nb\nc\nd\ne\nf\n"+
"EDGES\n"+"a b 1\n"+"b c 2\n"+"c d 1\n"+"d e 3\n"+"e f 1\n"+"f a 1\n"+"a c 4\n"
		+"a d 20\n";
    public InvalidAreaFileException(String badLine) {
        super("InvalidAreaFilenameException\n"+
        "Example Format for 6 vertices and 8 edges:\n"+example);
        System.out.println(badLine+ " is invalid as vertex label or edge "
        		+ "descriptor");
    }
}
