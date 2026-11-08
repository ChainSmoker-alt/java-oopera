public class Director extends Person{
    int numberOfShows;


    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString(){
        return "Director{" + "name='" + name + "', surname='" + surname + "', gender=" + gender + ", numberOfShows=" +
                numberOfShows + "}";
    }
}