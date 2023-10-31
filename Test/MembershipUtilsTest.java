
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MembershipUtilsTest {

    private Path testPath;
    private MembershipUtils utils = new MembershipUtils();
    private final String mockUserInputIsvalidAndActive = "7703021234";
    private final String mockUserInputIsvalidAndInactive = "BeaR BeLle";
    private final String mockUserInputIsInvald = "Test test";

    private final String mockDate1 = "2022-01-01";



    Customer customerTest = new Customer("Test1", "111", mockDate1);


    @Test
    public void checkMemberShipStatus() {

        String expectedMessageWhenValidAndActive = "The customer is an active member";
        String actualMessageWhenCValidAndActive = utils.checkMembershipStatus(mockUserInputIsvalidAndActive);

        Assertions.assertEquals(expectedMessageWhenValidAndActive, actualMessageWhenCValidAndActive);

        String expectedMessageWhenValidAndInactive = "The customer is not an active member";
        String actualMessageWhenValidAndInactive = utils.checkMembershipStatus(mockUserInputIsvalidAndInactive);

        Assertions.assertEquals(expectedMessageWhenValidAndInactive, actualMessageWhenValidAndInactive);

        String expectedMessageWhenInvalid = "The customer is not a member of this gym";
        String actualMessageWhenInvalid = utils.checkMembershipStatus(mockUserInputIsInvald);

        Assertions.assertEquals(expectedMessageWhenInvalid, actualMessageWhenInvalid);


    }

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        testPath = Files.createTempFile("tempFileToBeDeletedAfterTest", ".txt");


    }


    @Test
    public void privateTrainerLogWriterTest() {
        String expectedMessage = customerTest.getName() + " visited the gym on " + LocalDate.now() + "\n";
        utils.privateTrainerLogWriter(customerTest, testPath);

        try {
            String textInTestFile = Files.readString(testPath);
            assertEquals(expectedMessage, textInTestFile);

        } catch (IOException e) {
            System.out.println("IO exception while testing");
        }
    }

    @AfterEach
    void deleteTempFile() throws IOException {
        Files.deleteIfExists(testPath);
    }
}