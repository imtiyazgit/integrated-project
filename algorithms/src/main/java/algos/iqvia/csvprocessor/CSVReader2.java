package algos.iqvia.csvprocessor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;


class AssetGroupInfo {
    int count;
    int txAmount;
    String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int  getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(int txAmount) {
        this.txAmount = txAmount;
    }
}

public class CSVReader2 {

    public static void main(String[] args) {

        String csvFile = "/Users/imtiyaz/personal_projects/integrated-project/algorithms/src/main/java/algos/iqvia/csvprocessor/input_data_set.csv";
        String groupsCsvFile = "/Users/imtiyaz/personal_projects/integrated-project/algorithms/src/main/java/algos/iqvia/csvprocessor/groups.csv";

        String line = "";
        String cvsSplitBy = ",";

        int totalLinesRead=0;

        Map<String, AssetGroupInfo>  nameAssetGroupInfoMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] dataLine = line.split(cvsSplitBy);

                if(totalLinesRead++>0) {
                    AssetGroupInfo assetGroupInfo = new AssetGroupInfo();
                    if(dataLine[1].equals("GOOG")) {
                        assetGroupInfo.setCount(assetGroupInfo.getCount() + 1);
                        assetGroupInfo.setTxAmount(Integer.parseInt(dataLine[2]));

                        // load entries into map
                        nameAssetGroupInfoMap.put(dataLine[3], assetGroupInfo);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(groupsCsvFile))) {

            while ((line = br.readLine()) != null) {

                String[] dataLine = line.split(cvsSplitBy);

                if(totalLinesRead++>0) {
                    AssetGroupInfo assetGroupInfo = nameAssetGroupInfoMap.get(dataLine[0]);
                    if(assetGroupInfo != null) {
                        assetGroupInfo.setGroupName(dataLine[1]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collection<AssetGroupInfo> assetGroupInfo = nameAssetGroupInfoMap.values();
        List<AssetGroupInfo> assetGroupInfoList = new ArrayList<>(assetGroupInfo);
        Collections.sort(assetGroupInfoList, (a, b) -> b.getTxAmount() - a.getTxAmount());

        System.out.println(assetGroupInfoList.get(0).getGroupName());
        System.out.println(assetGroupInfoList.get(0).getTxAmount());

    }

}
