package ibu.edu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String selectionSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\SelectionSort IPs.csv";
        String insertionSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\InsertionSort IPs.csv";
        String shellSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\ShellSort IPs.csv";

        File file = new File(path);
        File newFileSelection = new File(selectionSortPath);
        File newFileInsertion = new File(insertionSortPath);
        File newFileShell = new File(shellSortPath);

        Scanner input = new Scanner(file);

        FileWriter selectionFileWriter = new FileWriter(newFileSelection);
        FileWriter insertionFileWriter = new FileWriter(newFileInsertion);
        FileWriter shellFileWriter = new FileWriter(newFileShell);

        String[] ips;
        IPAddress[] ipAddressesSelection = new IPAddress[50];
        IPAddress[] ipAddressesInsertion = new IPAddress[50];
        IPAddress[] ipAddressesShell = new IPAddress[50];

        int i = 0;
        while(input.hasNextLine() && i < 50){

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddressesSelection[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            ipAddressesInsertion[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            ipAddressesShell[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //Selection sort
        long start = System.currentTimeMillis();
        SelectionSort.sort(ipAddressesSelection);

        for(int a = 0; a < ipAddressesSelection.length; a++){
            selectionFileWriter.write("\"" + ipAddressesSelection[a].ipFrom + "\"," + "\"" + ipAddressesSelection[a].ipTo + "\"," + "\"" + ipAddressesSelection[a].countryCode + "\"," + "\"" + ipAddressesSelection[a].countryName + "\"," + "\"" + ipAddressesSelection[a].regionName + "\"," + "\"" + ipAddressesSelection[a].cityName + "\n");
        }
        selectionFileWriter.close();
        System.out.println("Selection sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");

        //Insertion sort
        start = System.currentTimeMillis();

        InsertionSort.sort(ipAddressesInsertion);

        for(int b = 0; b < ipAddressesInsertion.length; b++){
            insertionFileWriter.write("\"" + ipAddressesInsertion[b].ipFrom + "\"," + "\"" + ipAddressesInsertion[b].ipTo + "\"," + "\"" + ipAddressesInsertion[b].countryCode + "\"," + "\"" + ipAddressesInsertion[b].countryName + "\"," + "\"" + ipAddressesInsertion[b].regionName + "\"," + "\"" + ipAddressesInsertion[b].cityName + "\n");
        }
        insertionFileWriter.close();
        System.out.println("Insertion sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");

        //Shell sort
        start = System.currentTimeMillis();

        ShellSort.sort(ipAddressesShell);

        for(int c = 0; c < ipAddressesShell.length; c++){
           shellFileWriter.write("\"" + ipAddressesShell[c].ipFrom + "\"," + "\"" + ipAddressesShell[c].ipTo + "\"," + "\"" + ipAddressesShell[c].countryCode + "\"," + "\"" + ipAddressesShell[c].countryName + "\"," + "\"" + ipAddressesShell[c].regionName + "\"," + "\"" + ipAddressesShell[c].cityName + "\n");
        }
        shellFileWriter.close();
        System.out.println("Shell sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");    }
}
