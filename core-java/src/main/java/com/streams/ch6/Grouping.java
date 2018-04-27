package com.streams.ch6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Grouping {
    public static List<Transaction> transactions = Arrays.asList( new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0) );


    public static void main(String[] args) {
        // group list of transactions by currency
        groupByCurrency();

        // find highest transaction
        highestCurrencyTransaction();
    }


    public static void groupByCurrency() {
        Map<Currency, List<Transaction>> result = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(result);
    }

    public static void highestCurrencyTransaction() {
        Optional<Transaction> t = transactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));
        System.out.println(t.get());
    }


}
