public class Customer {

    protected String name;
    protected String personNumber;
    protected String dateOfLastMembershipPayment;


    public Customer(String name, String personNumber, String dateOfLastMembershipPayment) {
        this.name = name;
        this.personNumber = personNumber;
        this.dateOfLastMembershipPayment = dateOfLastMembershipPayment;
    }



    public String getName() {
        return name;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getDateOfLastMembershipPayment() {
        return dateOfLastMembershipPayment;
    }
}
