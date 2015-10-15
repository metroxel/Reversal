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
		File input = new File("test1.txt");
		File output = new File("test1Out.txt");

		// write to input file
		PrintWriter write = new PrintWriter(input);
		write.println("The cat runs");
		write.flush();
		write.close();

		// call Reversal code
		Reversal.reverseFile(input, output);
		Scanner scan = new Scanner(output);
		String expected = "snur tac eht";
		String actual = scan.nextLine();
		scan.close();
		assertEquals("Output file is not correct", expected, actual);
	}

}
