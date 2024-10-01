import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SportLoggerTest {
    private SportLogger logger;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;



    @Before
    public void setUp() {
        logger = new SportLogger();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }


    @Test
    public void handleAddActivityTest() {
        logger.addActivity("jogging", 55);
        logger.addActivity("skiing", 320);

        assertEquals(2, logger.getActivityMap().size());
        assertTrue(logger.getActivityMap().containsKey("jogging"));
        assertTrue(logger.getActivityMap().containsKey("skiing"));
        assertEquals(Integer.valueOf(55), logger.getActivityMap().get("jogging"));
    }

    @Test
    public void testDisplayLoggedActivities() {
        logger.addActivity("jogging", 55);
        logger.addActivity("swimming", 150);
        System.setOut(originalOut);

        outContent.reset();

        logger.displayLoggedActivities();
        System.setOut(new PrintStream(outContent));



        String expectedOutput = "";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testCheckTotalTime() {
        logger.addActivity("jogging", 55);
        logger.addActivity("swimming", 150);

        assertEquals(205, logger.getTotalTime());
    }
}