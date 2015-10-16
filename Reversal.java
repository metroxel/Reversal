import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

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
		ArrayList<String> linesToReverse = new ArrayList<String>();
		String temp = "";

		try {
			// reads in data
			Scanner scan = new Scanner(input);
			while (scan.hasNext()) {

				tempForTokens = scan.nextLine();
				// create a tokenizer to split words up at spaces
				StringTokenizer tokenizer = new StringTokenizer(tempForTokens,
						" ");

				// while there are still words, add to temp String in reverse
				// order
				while (tokenizer.hasMoreTokens()) {
					temp = tokenizer.nextToken() + " " + temp;

				}

				linesToReverse.add(temp);
				// reset temp
				temp = "";
			}
			// reverse the arrayList
			Collections.reverse(linesToReverse);

			// STILL NEED TO WRITE TO OUTPUT FILE

			// be sure to close everything since done
			scan.close();

		} catch (FileNotFoundException e) {
			System.out.print("File does not exist");
		} catch (IOException e) {
			System.out.print("File was not read properly");
		}
	}
}