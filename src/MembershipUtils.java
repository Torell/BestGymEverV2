import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class MembershipUtils {

    private final String pathOfCustomerDataBase = "src/Customers.txt";
    private final Path pathOfPrivateTrainerLog = Paths.get("src/PrivateTrainerLog.txt");
    private DatabaseOfCustomers customers = new DatabaseOfCustomers(pathOfCustomerDataBase);
    private final DateHandling date = new DateHandling();

    public MembershipUtils() {
    }

    public String checkMembershipStatus(String userInput) {
        for (Customer customer : customers.getListOfAllMembers()) {
            if (customer.getName().equalsIgnoreCase(userInput.trim())
                    || customer.getPersonNumber().equals(userInput)) {
                if (date.checkIfLastPaymentIsLessThan365DaysAgo(customer.getDateOfLastMembershipPayment())) {
                    privateTrainerLogWriter(customer, pathOfPrivateTrainerLog);
                    return "The customer is an active member";

                } else return "The customer is not an active member";

            }
        } return "The customer is not a member of this gym";
    }

    public void privateTrainerLogWriter(Customer customer, Path pathToWrite) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathToWrite, StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
            String stringToWrite = customer.getName() + " visited the gym on " + LocalDate.now();
            bufferedWriter.write(stringToWrite);
            bufferedWriter.newLine();
        }
        catch (FileNotFoundException e) {
            System.out.println("No such file named " + pathToWrite + " was found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
