import java.util.List;

import enums.DeviceType;
import enums.Visibility;
import facades.AudioEngine;
import models.Playlist;
import models.Song;
import strategies.CustomStrategy;
import strategies.RandomStrategy;
import strategies.SequentialStrategy;

public class Main {
    public static void main(String[] args) {
        AudioEngine engine = AudioEngine.getInstance();

        Song s1 = new Song("Dior", "Subh", "https://dior/subh");
        Song s2 = new Song("Finding Her", "Kushagra", "https://finding-her/kushagra");
        Song s3 = new Song("Zarorat Se Zyada", "Arijit Singh", "https://zarorat-se-jyada/arijit-singh");
        Song s4 = new Song("Tum Se Hi", "Mohit Chauhan", "https://tum-se-hi/mohit-chauhan");
        Song s5 = new Song("Channa Mereya", "Arijit Singh", "https://channa-mereya/arijit-singh");
        Song s6 = new Song("Bekhayali", "Sachet Tandon", "https://bekhayali/sachet-tandon");
        Song s7 = new Song("Ik Vaari Aa", "Arijit Singh", "https://ik-vaari-aa/arijit-singh");

        Playlist p1 = new Playlist("My Playlist", Visibility.PRIVATE);
        p1.addSong(s1);
        p1.addSong(s2);
        p1.addSong(s3);
        p1.addSong(s4);
        p1.addSong(s5);
        p1.addSong(s6);
        p1.addSong(s7);

        engine.connect(DeviceType.BLUETOOTH);

        // play single song
        engine.play(s3);
        engine.stop();

        // play Playlist in sequential strategy
        engine.setStrategy(new SequentialStrategy());
        engine.play(p1);

        engine.next();
        engine.pause();
        engine.prev();

        //random strategy
        engine.setStrategy(new RandomStrategy());
        engine.next();
        engine.next();
        
        // custom strategy
        List<Song> customOrder = List.of(s5, s3, s7, s1);
        engine.setStrategy(new CustomStrategy(customOrder));
        engine.play(p1);
        engine.next();
        engine.next();
        engine.next();
        
        engine.stop();
    }
}
