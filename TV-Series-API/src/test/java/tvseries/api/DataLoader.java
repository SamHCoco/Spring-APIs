package tvseries.api;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {

    /**
     * Reads "tv-shows.txt" file and returns all the TV series listed
     * in the file. To be used to load test data for unit testing of controller.
     * A single TV series in the text file has the format:
     * "title
     * year
     * genre
     * description
     * ------------"
     * @return All TV series in the "tv-shows.txt" file.
     */
    public static List<TVSeries> loadTVSeries(){
        try(Scanner scanner = new Scanner(new FileReader("src\\main\\resources\\data\\tv-shows.txt"))){
            List<TVSeries> tvSeries = new ArrayList<>();
            int id = 1;
            String title;
            int year = 0;
            String genre;
            String summary;

            while(scanner.hasNextLine()){
                title = scanner.nextLine();
                if(title.charAt(0) == '-'){
                    continue;
                } else {
                    year = Integer.valueOf(scanner.nextLine());
                    genre = scanner.nextLine();
                    summary = scanner.nextLine();
                }
                tvSeries.add(new TVSeries(id, title, year, genre, summary));
                id++;
            }
            return tvSeries;
        } catch(IOException e){
            System.out.println("ERROR IN OPENING TV SERIES TEST DATA FILE: " + e.getMessage());
        }
        return null;
    }
}
