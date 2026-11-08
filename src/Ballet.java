import java.util.ArrayList;

public class Ballet extends MusicalShow {
    Person choreographer;

    public Ballet(String title, int duration, Director director, ArrayList<Actor> listOfActors,
                  Person musicAuthor, String librettoText, Person choreographer) {
        super(title, duration,  director,  listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
    public Ballet(String title, int duration, Director director,
                  Person musicAuthor, String librettoText, Person choreographer) {
        super(title, duration,  director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}