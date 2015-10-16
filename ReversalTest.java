import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class ReversalTest {

	// Basic test to use for debugging process
	@Test
	public void test() throws FileNotFoundException {
		// create input and output files to be used
		File input = new File("testInput.txt");
		File output = new File("testOutput.txt");

		// empty output file
		PrintWriter writeOut = new PrintWriter(output);
		writeOut.println(" ");
		writeOut.flush();
		writeOut.close();

		// call Reversal code
		Reversal.reverseFile(input, output);

		// Compare to see if correct
		Scanner scan = new Scanner(output);
		String expected = "runs dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected2 = "runs cat The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();

	}
}
