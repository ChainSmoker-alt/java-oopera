import java.util.ArrayList;

public class MusicalShow extends Show {
    Person musicAuthor;
    String librettoText;

    public MusicalShow(String title, int duration, Director director, ArrayList<Actor> listOfActors,
                       Person musicAuthor, String librettoText) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public MusicalShow(String title, int duration, Director director, Person musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    @Override
    public String toString() {
        return "MusicalShow{" + super.toString() + "librettoText='" + librettoText + "'}";
    }
}
