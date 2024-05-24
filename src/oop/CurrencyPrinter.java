package oop;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyPrinter {
    public static void main(String[] args) {
        double amount = 123165.65465;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(amount));

        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(nf.format(amount));

        System.out.println(nf.getClass().getName());

    }
}
