package ibu.edu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String newPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\Sorted IPs.csv";

        File file = new File(path);
        File newFile = new File(newPath);
        Scanner input = new Scanner(file);

        FileWriter fileWriter = new FileWriter(newFile);

        String[] ips;
        IPAddress[] ipAddresses = new IPAddress[30];

        int i = 0;
        while(input.hasNextLine() && i < 30){

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddresses[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //sort

        for(int a = 0; a < ipAddresses.length; a++){
            fileWriter.write("\"" + ipAddresses[a].ipFrom + "\"," + "\"" + ipAddresses[a].ipTo + "\"," + "\"" + ipAddresses[a].countryCode + "\"," + "\"" + ipAddresses[a].countryName + "\"," + "\"" + ipAddresses[a].regionName + "\"," + "\"" + ipAddresses[a].cityName + "\n");
        }
        fileWriter.close();


    }
}
