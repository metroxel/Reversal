import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Reversal
 * 
 * @author Megan Troxel
 * @version 10/15/15
 *
 */
public class Reversal {

	/*
	 * reverseFile -- reads in lines of text from file, and writes these lines
	 * in reverse order, the words in each line are also in reverse order
	 * 
	 * 
	 * @params - input file, output file
	 */
	public static void reverseFile(File input, File output)
			throws FileNotFoundException {

		String wordsInReverse = "";
		String tempForTokens = "";
		ArrayList<String> fileContents = new ArrayList<String>();

		try {
			// reads in data
			Scanner scan = new Scanner(input);
			while (scan.hasNext()) {
				// create a tokenizer to split words up
			}
			// reverse words
			// add to a temporary string
			// store strings to be written to output file
			// write stored strings to output file
			// be sure to close everything since done
		} catch (FileNotFoundException e) {
			System.out.print("File does not exist");
		} catch (IOException e) {
			System.out.print("File was not read properly");
		}
	}
}