import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateHandling {

    public DateHandling() {
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public int stringToInteger(String stringToBeParsed) {
        return Integer.parseInt(stringToBeParsed.trim());
    }

    public LocalDate dateOfLastPayment(String lastPayment) {
        int year = stringToInteger(lastPayment.substring(0,lastPayment.indexOf("-")));
        int month = stringToInteger(lastPayment.substring(lastPayment.indexOf("-")+1,lastPayment.indexOf("-")+3));
        int day =  stringToInteger(lastPayment.substring(lastPayment.lastIndexOf("-")+1));
        return LocalDate.of(year, month, day);

    }

    public boolean checkIfLastPaymentIsLessThan365DaysAgo(String lastPayment) {
        LocalDate currentDate = getCurrentDate();
        LocalDate dateToBeCompared = dateOfLastPayment(lastPayment);
        long daysBetweenDates = ChronoUnit.DAYS.between(dateToBeCompared,currentDate);

        return daysBetweenDates<=365;
    }


}
