package com.streams.ch6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

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

    public static final List<Dish> menu =
            asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {
        // group list of transactions by currency
        groupByCurrency();

        // group meat in one group, fish in other, rest all in other
        Map<Dish.Type, List<Dish>> res = menu.stream().collect(Collectors.groupingBy(Dish::getType));

        Map<String, List<Dish>> values = menu.stream().collect(Collectors.groupingBy(
                d -> {
                    if(d.getCalories() < 400) {
                        return "GoodDiet";
                    } else if(d.getCalories() < 700) {
                        return "AboveNormal";
                    } else {
                        return "Fat";
                    }
                }
        ));
        System.out.println(values);

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

        // or can be done using reducing function
        Optional<Transaction> t2 =transactions.stream().collect(Collectors.reducing((d1, d2 )-> d1.getValue() > d2.getValue() ? d1 : d2));
        System.out.println(t2.get());
    }


}
