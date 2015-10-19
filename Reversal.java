import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class Reversal
 * 
 * @author Megan Troxel
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

		try {
			String tempForTokens = "";
			ArrayList<String> linesToReverse = new ArrayList<String>();
			String temp = "";
			PrintWriter writeToOut = new PrintWriter(output);
			Scanner scan = new Scanner(input);
			StringTokenizer tokenizer;

			// reads data to then be manipulated
			while (scan.hasNext()) {

				tempForTokens = scan.nextLine();
				// create a tokenizer to split words up at spaces
				tokenizer = new StringTokenizer(tempForTokens, " ");

				// check for empty lines
				if (tempForTokens.equals("")) {
					temp = "";
				} else {
					// add first word to temp String
					temp = tokenizer.nextToken();
					// while there are still words, add to temp String in
					// reverse
					// order
					while (tokenizer.hasMoreTokens()) {
						temp = tokenizer.nextToken() + " " + temp;

					}
				}

				linesToReverse.add(temp);
				// reset temp
				temp = "";
			}

			// reverse the arrayList
			Collections.reverse(linesToReverse);

			// write to output file
			for (int i = 0; i < linesToReverse.size(); i++) {
				writeToOut.println(linesToReverse.get(i));
			}

			writeToOut.flush();

			// be sure to close everything since done
			writeToOut.close();
			scan.close();

		} catch (Exception e1) {
			throw new FileNotFoundException();
		}
	}
}