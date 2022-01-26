package randomTitle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String songLyric;
        System.out.println("Input the song's lyrics (all in one line): ");
        songLyric = input.nextLine();
        input.close();

        Song song = new Song(songLyric);
        song.generateRandomTitle();

        System.out.println(song.getRandomTitle());
    }
}
