import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOfCustomers {

        protected List<Customer> listOfAllMembers = new ArrayList<>();
        protected DateHandling date = new DateHandling();


        public DatabaseOfCustomers (String pathOfData) {
            String tempNameAndPersonNumber;
            String name;
            String personNumber;
            String tempDate;

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathOfData))) {
                while ((tempNameAndPersonNumber = bufferedReader.readLine()) != null) {
                    name = tempNameAndPersonNumber.substring(tempNameAndPersonNumber.indexOf(",") + 2);
                    personNumber = tempNameAndPersonNumber.substring(0, tempNameAndPersonNumber.indexOf(","));
                    tempDate = bufferedReader.readLine();

                    Customer customer = new Customer(name, personNumber, tempDate);
                    this.listOfAllMembers.add(customer);

                }

            } catch (FileNotFoundException e) {
                System.out.println("No file found");
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            catch (IOException e) {
                System.out.println("Unexpected IO error");
                e.printStackTrace();
            }

        }

        public List<Customer> getListOfAllMembers() {
            return listOfAllMembers;
        }

}

