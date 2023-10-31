import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        String pathToCustomerFile = "src/Customers.txt";
        DatabaseOfCustomers customersList = new DatabaseOfCustomers(pathToCustomerFile);
        MembershipUtils membershipUtils = new MembershipUtils();

        String userInput = JOptionPane.showInputDialog("Please enter the customers name or personal identify number");
        String memberShipStatus = membershipUtils.checkMembershipStatus(userInput);
        JOptionPane.showMessageDialog(null, memberShipStatus);

    }

}
