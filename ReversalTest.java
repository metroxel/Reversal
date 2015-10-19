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
	File inputDoesnNotExist;
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

	// test for non-existent input or output file
	@Test(expected = FileNotFoundException.class)
	public void testDoesNotExist() throws FileNotFoundException {
		outputFile = new File("outputFileNotHere.txt");
		Reversal.reverseFile(inputFile, outputFile);

	}

	// test for 1 line in input
	@Test
	public void test1Line() throws FileNotFoundException {
		// create files to be used
		inputFile = new File("input1Line.txt");
		outputFile = new File("output1Line.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("Today is saturday.");
		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// check correctness
		scan = new Scanner(outputFile);
		String expected = "saturday. is Today";
		String actual = scan.nextLine();
		assertEquals("Output is incorrect", expected, actual);
		scan.close();
	}

	// test for 2 lines in input
	@Test
	public void test2Lines() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("input2Lines.txt");
		outputFile = new File("output2Lines.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("The cat runs");
		write.println("The dog jumps");
		write.flush();
		write.close();

		// call Reversal code
		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "jumps dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected2 = "runs cat The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();

	}

	// test for empty line in middle
	@Test
	public void testEmptyMiddle() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputEmptyMiddle.txt");
		outputFile = new File("outputEmptyMiddle.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("The cat runs");
		write.println("");
		write.println("The dog jumps");
		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "jumps dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expectedMiddle = "";
		String actualMiddle = scan.nextLine();
		assertEquals("Output file is not correct", expectedMiddle, actualMiddle);

		String expected2 = "runs cat The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();
	}

	// test for empty line at beginning
	@Test
	public void testEmptyBegin() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputEmptyBegin.txt");
		outputFile = new File("outputEmptyBegin.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("");
		write.println("in the summer it is hot, in the winter it is cold");
		write.println("The dog jumps");
		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "jumps dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expectedMiddle = "cold is it winter the in hot, is it summer the in";
		String actualMiddle = scan.nextLine();
		assertEquals("Output file is not correct", expectedMiddle, actualMiddle);

		String expected2 = "";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();
	}

	// test for random empty line
	@Test
	public void testEmptyRandom() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputEmptyRandom.txt");
		outputFile = new File("outputEmptyRandom.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("Once upon a time there was a line");
		write.println("in the summer it is hot, in the winter it is cold");
		write.println("The dog jumps");
		write.println("");
		write.println("The dog jumped over the fence");

		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "fence the over jumped dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected1 = "";
		String actual1 = scan.nextLine();
		assertEquals("Output file is not correct", expected1, actual1);

		String expected2 = "jumps dog The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);

		String expected3 = "cold is it winter the in hot, is it summer the in";
		String actual3 = scan.nextLine();
		assertEquals("Output file is not correct", expected3, actual3);

		String expected4 = "line a was there time a upon Once";
		String actual4 = scan.nextLine();
		assertEquals("Output file is not correct", expected4, actual4);
		scan.close();

	}

	// test for multiple empty lines
	@Test
	public void testEmptyMultiple() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputEmptyRandomMult.txt");
		outputFile = new File("outputEmptyRandomMult.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("Once upon a time there was a line");
		write.println("");
		write.println("");
		write.println("");
		write.println("The dog jumped over the fence");

		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "fence the over jumped dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected1 = "";
		String actual1 = scan.nextLine();
		assertEquals("Output file is not correct", expected1, actual1);

		String expected2 = "";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);

		String expected3 = "";
		String actual3 = scan.nextLine();
		assertEquals("Output file is not correct", expected3, actual3);

		String expected4 = "line a was there time a upon Once";
		String actual4 = scan.nextLine();
		assertEquals("Output file is not correct", expected4, actual4);
		scan.close();

	}

	// test for numerous lines
	@Test
	public void testNumerousLines() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputNumLines.txt");
		outputFile = new File("outputNumLines.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("The cat runs");
		write.println("The dog jumps");
		write.println("There was rain in the clouds.");
		write.println("Lorem ipsum dolor sit amet");
		write.flush();
		write.close();

		// call Reversal code
		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "amet sit dolor ipsum Lorem";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expected1 = "clouds. the in rain was There";
		String actual1 = scan.nextLine();
		assertEquals("Output file is not correct", expected1, actual1);

		String expected2 = "jumps dog The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);

		String expected3 = "runs cat The";
		String actual3 = scan.nextLine();
		assertEquals("Output file is not correct", expected3, actual3);
		scan.close();

	}

	// test for lines with punctuation
	@Test
	public void testPunctuation() throws FileNotFoundException {
		// create input and output files to be used
		inputFile = new File("inputPun.txt");
		outputFile = new File("outputPun.txt");

		// create input file with two lines
		write = new PrintWriter(inputFile);
		write.println("The cat runs!!");
		write.println("There, are, commas");
		write.println("The dog jumps");
		write.flush();
		write.close();

		Reversal.reverseFile(inputFile, outputFile);

		// Compare to see if correct
		scan = new Scanner(outputFile);
		String expected = "jumps dog The";
		String actual = scan.nextLine();
		assertEquals("Output file is not correct", expected, actual);

		String expectedMiddle = "commas are, There,";
		String actualMiddle = scan.nextLine();
		assertEquals("Output file is not correct", expectedMiddle, actualMiddle);

		String expected2 = "runs!! cat The";
		String actual2 = scan.nextLine();
		assertEquals("Output file is not correct", expected2, actual2);
		scan.close();
	}
}
