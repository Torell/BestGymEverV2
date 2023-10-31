import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DatabaseOfCustomersTest {

    private final String testPath = "Test/CustomersTest.txt";
    private DatabaseOfCustomers testDatabase = new DatabaseOfCustomers(testPath);


    @Test
    public void checkCustomersTest() {

        assert(testDatabase.getListOfAllMembers().size() == 3);
        String expectedName = "Alhambra Aromes";
        String actualName = testDatabase.getListOfAllMembers().get(0).getName();
        Assertions.assertEquals(expectedName, actualName);
        assert(testDatabase.getListOfAllMembers().get(0).getPersonNumber().equals("7703021234"));
        assert(testDatabase.getListOfAllMembers().get(0).getDateOfLastMembershipPayment().equals("2023-07-01"));
        assert(testDatabase.getListOfAllMembers().get(1).getDateOfLastMembershipPayment().equals("2019-12-02"));
    }






}