import java.util.ArrayList;
import java.util.Scanner;

public class SearchForMatch {

    public void searchMatch(String movie){
        String newMovie = movie.replaceAll(" ", "");
        newMovie = newMovie.replaceAll(":", "");
        newMovie = newMovie.replaceAll("-", "");
        char[] searchToArray = new char[newMovie.length()];
        char[] movieToArray = newMovie.toCharArray();

        for (int q = 0; q < newMovie.length(); q++) {
            searchToArray[q] = '_';
        }
        int count = 0;
        int wrongCount = 0;
        int wrongAnswer = 0;

        for (int j = 0; j < 20; j++ ){
            System.out.println();
            System.out.print("Please guess a letter(in lower case): ");
            Scanner scanner = new Scanner(System.in);
            String enterLetter = scanner.nextLine();
            char enterChar = enterLetter.charAt(0);
            if(!Character.isLowerCase(enterChar) && !Character.isDigit(enterChar)) {
                System.out.println("Invalid input. Please restart again.");
                break;
            }
            for (int i = 0;i < movieToArray.length; i++) {
                if (enterChar == Character.toLowerCase(movieToArray[i])) {
                    searchToArray[i] = movieToArray[i];
                }
                else wrongCount++;
            }
            System.out.println();
           // System.out.println(searchToArray.length);
            //System.out.println(wrongCount);

            if (wrongCount == searchToArray.length) wrongAnswer++;
            System.out.println("You've got " + wrongAnswer + " wrong answers.");
            wrongCount = 0;

            for (int m = 0; m < searchToArray.length; m++) {

                System.out.print(searchToArray[m]);
                if (searchToArray[m] != '_') count++;
            }
//            System.out.println();
//            System.out.println(count1);
//            System.out.println(searchToArray.length);
            if (count == searchToArray.length) {
                System.out.println("\nYou win!");
                break;
            }
            count = 0;
            if (j == 19) {
                System.out.println("You used out all your chances. You lose!");
                System.out.println(movie);
            }
        }

    }
}
