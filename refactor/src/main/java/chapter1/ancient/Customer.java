package chapter1.ancient;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 *
 * @author YangBo
 * @date 2019/04/29
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    /**
     * 生成详单的函数
     *
     * @return
     */
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental for " + getName() + " \n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            switch (each.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_dayRented() > 2) {
                        thisAmount += (each.get_dayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.get_dayRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.get_dayRented() > 3) {
                        thisAmount += (each.get_dayRented() - 3) * 1.5;
                    }
                    break;
                default:
                    break;
            }
            // add drequent reter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_dayRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

}
