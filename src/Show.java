import java.util.ArrayList;
import java.util.Objects;

public class Show {
    String title;
    int duration;
    Director director;
    ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = (listOfActors != null) ? listOfActors : new ArrayList<>();
    }

    public Show(String title, int duration, Director director) {
        this(title, duration, director, new ArrayList<>());
    }

    public void addActor(Actor actor) {
        if (!listOfActors.contains(actor)) {
            listOfActors.add(actor);
            System.out.println("Актер добавлен в спектакль");
        } else {
            System.out.println("Данный актер уже есть в списке");
        }
    }

    public void printActors() {
        if (listOfActors.isEmpty()) {
            System.out.println("Список актеров пуст");
            return;
        }
        for (Actor a : listOfActors) {
            System.out.println(a);
        }
    }

    public void changeActor(Actor actorToRemove, Actor newActor) {
        int idx = listOfActors.indexOf(actorToRemove);
        if (idx == -1) {
            System.out.println("Актера, которого вы хотите заменить, нет в списке");
            return;
        }
        listOfActors.set(idx, newActor);
        System.out.println("Актер заменён");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(title, show.title) && Objects.equals(director, show.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director);
    }

    @Override
    public String toString() {
        return "Show{title='" + title + "', duration=" + duration + ", director=" + director + "}";
    }
}