import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOutput
{
    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeEach
    public void init() {
        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterEach
    public void cleanUp() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @ParameterizedTest(name="{0}")
    @CsvFileSource(resources = "output_tests.csv")
    public void testOutputMatch(String testCaseName, String input, String expectedOutput, String matchType)
    {
        // Capture stdout
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Send input
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the class and capture stdout
        Main.main(new String[]{});
        String actualOutput = outputStream.toString().trim();

        // Perform the corresponding assertion based on the match type
        switch (matchType) {
            case "exact":
                assertEquals(expectedOutput, actualOutput);
                break;
            case "match":
                assertTrue(actualOutput.contains(expectedOutput), "Match failed for " + testCaseName +
                        "\n" + actualOutput + " does not contain " + expectedOutput);
                break;
            case "regex":
                assertTrue(Pattern.matches(expectedOutput, actualOutput), "Regex match failed for " + testCaseName +
                        "\n" + actualOutput + " does is not matched by pattern " + expectedOutput);
                break;
            default:
                fail("Invalid match type for " + testCaseName);
        }
    }
}

