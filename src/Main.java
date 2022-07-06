import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input the song's lyrics (all in one line): ");
        String songLyrics = input.nextLine();
        input.close();

        Song song = new Song();
        System.out.println("RANDOM TITLE:");
        System.out.println(song.generateRandomTitle(songLyrics));
        System.out.println("\nSCRAMBLED WORDS:");
        System.out.println(song.scramble(songLyrics));

    }
}
