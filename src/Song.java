import java.util.*;

public class Song {

    private final String delim = " ";
    private String title  = "";



    public void generateRandomTitle(String lyrics) {
        Random randomNumber = new Random();
        ArrayList<String> newTitle = new ArrayList<>();
        Integer randomIndex;
        Integer randomLength;
        ArrayList<String> words = tokenize(lyrics);

        randomLength = randomNumber.nextInt(words.size() <= 10 ? words.size() - 1 : 10) + 1;
        randomIndex = randomNumber.nextInt(words.size() - randomLength);

        for (int i = randomIndex; i < randomIndex + randomLength; i++) {
            newTitle.add(words.get(i));
        }
        setTitle(String.join(" ", newTitle));
    }

    private ArrayList<String> tokenize(String lyrics) {
        ArrayList<String> words = new ArrayList<>();
        lyrics = cleanLyric(lyrics);

        System.out.println("Tokenizing...\n\n");
        StringTokenizer st = new StringTokenizer(lyrics, this.delim);

        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        System.out.println("There are " + words.size() + " words in this song");
        return words;
    }

    private String cleanLyric(String lyrics) {

        String cleanSong = lyrics.replace("(", " ");
        cleanSong = cleanSong.replace(")", " ");
        cleanSong = cleanSong.replace(",", " ");
        cleanSong = cleanSong.replace(".", " ");

        return cleanSong;
    }

    public String getRandomTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }
}
