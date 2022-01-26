package randomTitle;

import java.util.*;

public class Song {

    private final String delim = " ";
    private String lyric = "";
    private final ArrayList<String> words = new ArrayList<>();
    private String title  = "";



    public Song(String songLyric) {
        this.lyric = songLyric;
    }



    public void tokenize() {

        System.out.println("Tokenizing...\n\n");

        cleanLyric();
        StringTokenizer st = new StringTokenizer(this.lyric, this.delim);

        while (st.hasMoreTokens()) {

            this.words.add(st.nextToken());
        }
        System.out.println(this.words.size() + " words are in this song's lyric");
    }



    public void generateRandomTitle() {

        tokenize();

        Random randomNumber = new Random();
        ArrayList<String> newTitle = new ArrayList<>();
        Integer randomIndex;
        Integer randomLength;

        randomLength = randomNumber.nextInt(this.words.size() <= 10 ? this.words.size() - 1 : 10) + 1;
        randomIndex = randomNumber.nextInt(this.words.size() - randomLength);

        for (int i = randomIndex; i < randomIndex + randomLength; i++) {

            newTitle.add(this.words.get(i));
        }

        setTitle(String.join(" ", newTitle));
    }



    public void cleanLyric() {

        String cleanSong = this.lyric.replace("(", " ");
        cleanSong = cleanSong.replace(")", " ");
        cleanSong = cleanSong.replace(",", " ");
        cleanSong = cleanSong.replace(".", " ");

        this.lyric = cleanSong;
    }



    public String getRandomTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }
}
