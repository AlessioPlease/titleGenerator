import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input the song's lyrics (all in one line): ");
        String songLyrics = input.nextLine();
        input.close();

        Song song = new Song();
        song.generateRandomTitle(songLyrics);

        System.out.println(song.getRandomTitle());
    }
}
