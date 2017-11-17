import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviePickUp {



    private String randomMovie() throws Exception {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        ArrayList<String> movie = new ArrayList<String>();

        while(fileScanner.hasNextLine())
            movie.add(fileScanner.nextLine());

        int size = movie.size();
        int randomLine = (int) (Math.random() * size);
        return movie.get(randomLine);

    }

    private void convertToUnderscore(String movie) {
        int count = 0;
        System.out.println("Please guess the movie name:");
        for (int i = 0; i < movie.length(); i++) {
            if(!Character.isLetter(movie.charAt(i)))
                continue;
            System.out.print("_ ");
            count++;
        }
        System.out.println("\nThe movie name has " + count + " letters.");
        System.out.println("\nYou have 20 chances! " +
                "\nThe number of underscores shows above is a hint of real letters in the movie name.");
        System.out.println();


    }

    public static void main(String[] args) throws Exception {
        MoviePickUp pick = new MoviePickUp();
        String movie = pick.randomMovie();
        //System.out.println(movie);
        pick.convertToUnderscore(movie);
        SearchForMatch newGame = new SearchForMatch();
        newGame.searchMatch(movie);
    }
}
