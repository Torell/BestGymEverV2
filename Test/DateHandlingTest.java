import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateHandlingTest {

    private DateHandling dateTest = new DateHandling();
    private final String mockDate1 = "2022-01-01";
    private final String mockDate2 = "2023-01-01";
    private final String mockDate3 = "2022-12-12";

    Customer customerTest = new Customer("Test1", "111",mockDate1);
    Customer customerTest2 = new Customer("Test2","222",mockDate2);
    Customer customerTest3 = new Customer("Test3","333",mockDate3);



    @Test
    public void getCurrentDateTest() {
        
        LocalDate expectedDate = LocalDate.now();
        LocalDate actualDate = dateTest.getCurrentDate();

        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void stringToIntegerTest() {
        String stringToBeParsed = "1999      ";
        int expectedInt = 1999;
        int actualInt = dateTest.stringToInteger(stringToBeParsed);

        Assertions.assertEquals(expectedInt, actualInt);
    }

    @Test
    public void getDateOfLastPaymentTest() {
        LocalDate expectedLocalDate = LocalDate.of(2022,01,01);
        LocalDate actualLocalDate = dateTest.dateOfLastPayment(customerTest.getDateOfLastMembershipPayment());

        LocalDate expectedLocalDate2 = LocalDate.of(2023,01,01);
        LocalDate actualLocalDate2 = dateTest.dateOfLastPayment(customerTest2.getDateOfLastMembershipPayment());

        Assertions.assertEquals(expectedLocalDate, actualLocalDate);
        Assertions.assertEquals(expectedLocalDate2,actualLocalDate2);
    }

    @Test
    public void checkIfLastPaymentIsLessThan365DaysAgoTest() {
        assertFalse(dateTest.checkIfLastPaymentIsLessThan365DaysAgo(customerTest.getDateOfLastMembershipPayment()));
        assertTrue(dateTest.checkIfLastPaymentIsLessThan365DaysAgo(customerTest2.getDateOfLastMembershipPayment()));
        assertTrue(dateTest.checkIfLastPaymentIsLessThan365DaysAgo(customerTest3.getDateOfLastMembershipPayment()));

    }

}