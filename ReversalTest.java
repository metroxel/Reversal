import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class ReversalTest {
	PrintWriter write;
	File inputFile;
	File outputFile;
	Scanner scan;

	// test for empty input file
	@Test
	public void testEmpty() throws FileNotFoundException {
		// create input and output files
		inputFile = new File("EmptyInput.txt");
		outputFile = new File("EmptyOutput.txt");

		// create empty file
		write = new PrintWriter(inputFile);
		write.println("");
		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);
		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "";
		String actual = null;
		if (!scan.hasNext()) {
			actual = "";
		}
		assertEquals("Output file is not correct, it should be empty",
				expected, actual);

	}

	// test for non-existent input file
	// test for blank line in middle
	// test for blank line at beginning
	// test for blank line at end
	// test for 1 line
	// test for multiple lines

	// Basic test to use for debugging process
	@Test
	public void test() throws FileNotFoundException {

		// create input and output files to be used
		File inputFile = new File("testInput.txt");
		File outputFile = new File("testOutput.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("The cat runs");
		write.println("The dog runs");
		write.flush();
		write.close();

		// call Reversal code
		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "runs dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected2 = "runs cat The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();

	}
}
