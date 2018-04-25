package com.streams.trader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        test1(transactions);

        uniqueCities(transactions);

        tradersFromCambridge(transactions);

        allTraderNamesStored(transactions);

        areAnyTradersFromMilan(transactions);

        findTransactionWithSmallestValue(transactions);
    }

    public static void test1(List<Transaction> transactions) {
        List<Transaction> list = transactions.stream()
                .filter(tx-> tx.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static void uniqueCities(List<Transaction> transactions) {
        Set<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(cities);
    }

    public static void tradersFromCambridge(List<Transaction> transactions) {
        List<String> traderNames = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(trader -> trader.getName())
                .collect(Collectors.toList());
        System.out.println(traderNames);
    }

    public static void allTraderNamesStored(List<Transaction> transactions) {
        String str = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a,b) -> a+b);
        System.out.println(str);
    }

    public static void areAnyTradersFromMilan(List<Transaction> transactions) {
        boolean result = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity() == "Milan");
        System.out.println(result);
    }

    public static void findTransactionWithSmallestValue(List<Transaction> transactions) {
        transactions.stream()
                .map(Transaction::getValue)
                .reduce((a,b) -> Integer.min(a,b) ).ifPresent(System.out::println);

        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::println);
    }
}
