package algos.iqvia.csvprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    // Time complexity: O(n) since we are visiting one element in both the the lists
    // Space complexity: O(n) for storing unique combinations in set
    private static int uniqueCombinationsOfBuySell(List<String> buyList, List<String> sellList) {
        Set<String> uniqueCombinationsSet = new HashSet<>();

        // run the loop and iterate both lists in tandem
        for (int i = 0; i < buyList.size() ; i++) {
            uniqueCombinationsSet.add(buyList.get(i)+sellList.get(i));
        }

        return uniqueCombinationsSet.size();
    }

    // Time Complexity: O(n)
    // Space complexity: O(1), no additional space required for this method assuming that accountTxCountMap is
    // created in calling method
    private static int accountsTxCount(Map<String, Integer> accountTxCountMap) {
        int noOfAccounts = 0;
        for(String key :accountTxCountMap.keySet()) {
            // check if any account executed at least 500 transactions inclusive
            if(accountTxCountMap.get(key) >= 500) {
                noOfAccounts++;
            }
        }
        return noOfAccounts;
    }

    // Time complexity: O(nlogn) for processing each item of the map and for sorting the account average list
    // Space complexity: O(n) for creating account average info list
    private static AccountAverageInfo getAccountAverageForItemNumber(Map<String, List<Integer>> accountTxCountListMap, int index) {
        List<AccountAverageInfo> accountAverageInfoList = new ArrayList<>();
        for (String key: accountTxCountListMap.keySet()) {
            List<Integer> allTransactions = accountTxCountListMap.get(key);
            Double average = allTransactions.stream().mapToInt(val -> val).average().orElse(0.0);
            accountAverageInfoList.add(new AccountAverageInfo(key, average));
        }
        Collections.sort(accountAverageInfoList, (a,b) -> b.average.compareTo(a.average)); // Time complexity: O(nlogn)
        return accountAverageInfoList.get(index-1);
    }

    static class AccountAverageInfo {
        String account;
        Double average;

        public AccountAverageInfo(String account, Double average) {
            this.account = account;
            this.average = average;
        }

        public String getAccount() {
            return account;
        }

        public Double getAverage() {
            return average;
        }
    }


    /**
     * Below method stores the same information in multiple maps and lists. This is intentionally done for this program
     * Also, validations, run time failures/exceptions, etc are intentionally not included while programming
     * In real project, this would sparse into multiple model classes and the information can be loaded into one runtime data set
     *
     * Time complexity: O(n) where n is the no of rows in the input data sheet
     * Space Complexity: O(n+n+n) =O(3n) = O(n) for storing into two maps and internal list. Typically this can be avoided if we use MultiMap
     *
     *
     */
    public static void main(String[] args) {

        String csvFile = "/Users/imtiyaz/personal_projects/integrated-project/algorithms/src/main/java/algos/iqvia/csvprocessor/input_data_set.csv";
        String line = "";
        String cvsSplitBy = ",";

        List<String> buyList = new ArrayList<>();
        List<String> sellList = new ArrayList<>();
        int totalLinesRead=0;
        Map<String, Integer> accountTxCountMap = new HashMap<>();
        Map<String, List<Integer>> accountTxCountListMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] dataLine = line.split(cvsSplitBy);

                if(totalLinesRead++>0) {
                    buyList.add(dataLine[0]);
                    sellList.add(dataLine[1]);
                    accountTxCountMap.put(dataLine[3], accountTxCountMap.getOrDefault(dataLine[3], 0) + Integer.parseInt(dataLine[2]));

                    if(accountTxCountListMap.containsKey(dataLine[3])) {
                        accountTxCountListMap.get(dataLine[3]).add(Integer.parseInt(dataLine[2])) ;
                    } else {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(Integer.parseInt(dataLine[2]));
                        accountTxCountListMap.put(dataLine[3], newList);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("No of unique combinations of buy and sell is:"+uniqueCombinationsOfBuySell(buyList, sellList)); //14
        System.out.println("No of accounts with at least 500 transactions"+accountsTxCount(accountTxCountMap)); // 72

        AccountAverageInfo accountAverageInfo = getAccountAverageForItemNumber(accountTxCountListMap, 3);
        System.out.println("Account having 3rd Highest average tx amount is" + accountAverageInfo.getAccount() + " " +
                "and the average amount is: "+accountAverageInfo.getAverage()); // BkorJrry and 548375.125

    }

}
