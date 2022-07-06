import java.util.*;

public class Song {

    private final String delim = " ";



    public String generateRandomTitle(String lyrics) {
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
        return String.join(" ", newTitle);
    }

    public String scramble(String lyrics) {
        Random numberGenerator = new Random();
        HashSet<Integer> takenIndexes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> words = tokenize(lyrics);
        boolean finished = false;

        while (! finished) {
            int randomNumber = numberGenerator.nextInt(words.size());

            if (! takenIndexes.contains(randomNumber)) {
                takenIndexes.add(randomNumber);
                sb.append(words.get(randomNumber)).append(" ");
            }
            if (takenIndexes.size() == words.size()) {
                finished = true;
            }
        }
        return String.valueOf(sb);
    }

    private ArrayList<String> tokenize(String lyrics) {
        ArrayList<String> words = new ArrayList<>();
        lyrics = cleanLyric(lyrics);
        StringTokenizer st = new StringTokenizer(lyrics, this.delim);

        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        return words;
    }

    private String cleanLyric(String lyrics) {
        String cleanSong = lyrics.replace("(", " ");
        cleanSong = cleanSong.replace(")", " ");
        cleanSong = cleanSong.replace(",", " ");
        cleanSong = cleanSong.replace(".", " ");
        return cleanSong;
    }
}
