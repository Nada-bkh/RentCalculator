package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author nadab
 */
public class Rent {

    int idPayment;
    Date paymentDate;
    int amount;
    int type;
    int rental;
    Date createdAt;

    public Rent() {
    }

    public Rent(int idPayment, Date paymentDate, int amount, int type, int rental, Date createdAt) {
        this.idPayment = idPayment;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.type = type;
        this.rental = rental;
        this.createdAt = createdAt;
    }

    public Rent(Date paymentDate, int amount, int type, int rental, Date createdAt) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.type = type;
        this.rental = rental;
        this.createdAt = createdAt;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public int getType() {
        return type;
    }

    public int getRental() {
        return rental;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setRental(int rental) {
        this.rental = rental;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Rent{" + "idPayment=" + idPayment + ", paymentDate=" + paymentDate + ", amount=" + amount + ", type=" + type + ", rental=" + rental + ", createdAt=" + createdAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rent other = (Rent) obj;
        if (this.idPayment != other.idPayment) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.rental != other.rental) {
            return false;
        }
        if (!Objects.equals(this.paymentDate, other.paymentDate)) {
            return false;
        }
        return Objects.equals(this.createdAt, other.createdAt);
    }

    public static List<Rent> getByDate(List<Rent> rentList, Date targetDate) {
        List<Rent> filteredList = new ArrayList<>();

        for (Rent rent : rentList) {
            Date createdAt = rent.getCreatedAt();
            if (createdAt != null && createdAt.equals(targetDate)) {
                filteredList.add(rent);
            }
        }

        return filteredList;
    }

        public static Map<Date, Integer> calculateTotalAmountByDate(List<Rent> rentList) {
        return rentList.stream()
            .collect(Collectors.groupingBy(Rent::getPaymentDate, Collectors.summingInt(Rent::getAmount)));
    }

    public static int calculateTotalAmountForMonth(Rent[] rents, Date targetMonth) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");

        String targetMonthString = monthFormat.format(targetMonth);

        return Arrays.stream(rents) //blaset l list rent[] rent
                .filter(rent -> targetMonthString.equals(monthFormat.format(rent.getPaymentDate()))) //filter month instead of for 
                .mapToInt(Rent::getAmount) //nextractiw l amount men kol rent w nbadlouha lel intStream khater sum tehseb ken intStream
                .sum(); // méthode tehseb l intStream
    }

    public static int calculateTotalAmountByYear(Rent[] rents, Date targetYear) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        String targetYearString = yearFormat.format(targetYear);

        return Arrays.stream(rents)
                .filter(rent -> targetYearString.equals(yearFormat.format(rent.getPaymentDate())))
                .mapToInt(Rent::getAmount)
                .sum();
    }

}
