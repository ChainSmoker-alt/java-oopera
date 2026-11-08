import java.util.Scanner;
import java.util.ArrayList;

public class Theatre {
    static Scanner in = new Scanner(System.in);

    static ArrayList<Director> directors = new ArrayList<>();
    static ArrayList<Actor> actors = new ArrayList<>();
    static ArrayList<Person> choreographers = new ArrayList<>();
    static ArrayList<Person> musicAuthors = new ArrayList<>();
    static ArrayList<Show> shows = new ArrayList<>();
    static ArrayList<Ballet> ballets = new ArrayList<>();
    static ArrayList<Opera> operas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String comand = in.nextLine();
            int cmd = 8;
            if ("1".equals(comand)||"2".equals(comand)||"3".equals(comand)||"4".equals(comand)||"5".equals(comand)
                    ||"6".equals(comand)||"7".equals(comand)){
                cmd = Integer.parseInt(comand);
            }

            switch (cmd) {
                case 1 -> addPersonMenu();
                case 2 -> createShowMenu();
                case 3 -> addActorMenu();
                case 4 -> printActorList();
                case 5 -> changeActorMenu();
                case 6 -> printLibretto();
                case 7 -> {
                    return;
                }
                case 8 -> System.out.println("Такой команды нет! Введите цифру от 1 до 7");

            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить актера, режиссёра, хореографа или автора музыки");
        System.out.println("2. Создать спектакль");
        System.out.println("3. Добавить актера в спектакль");
        System.out.println("4. Вывести список актеров спектакля");
        System.out.println("5. Заменить актера в спектакле");
        System.out.println("6. Вывести текст либретто");
        System.out.println("7. Выход");
    }

    static void addPersonMenu() {
        System.out.println("Кого вы хотите добавить (актер, режиссёр, хореограф, автор музыки)?");
        String person = in.nextLine();
        switch (person) {
            case "хореограф" -> addChoreographer();
            case "автор музыки" -> addMusicAuthor();
            case "режиссёр", "режиссер" -> addDirector();
            case "актер", "актёр" -> addActor();
            default ->
                    System.out.println("Неверный ввод. Допустимые варианты: актер, режиссёр, хореограф, автор музыки");
        }
    }

    public static void addChoreographer() {
        Person choreographer;
        System.out.println("Введите имя");
        String choreographerName = in.nextLine();
        System.out.println("Введите фамилию");
        String choreographerSurname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String choreographerGender = in.nextLine();
        if (choreographerGender.equals("муж")) {
            choreographer = new Person(choreographerName, choreographerSurname, Person.Gender.MALE);
            choreographers.add(choreographer);
            System.out.println("Хореограф добавлен");
        } else if (choreographerGender.equals("жен")) {
            choreographer = new Person(choreographerName, choreographerSurname, Person.Gender.FEMALE);
            choreographers.add(choreographer);
            System.out.println("Хореограф добавлен");
        } else System.out.println("Введено неверное значение");
    }

    public static void addMusicAuthor() {
        Person musicAuthor;
        System.out.println("Введите имя");
        String musicAuthorName = in.nextLine();
        System.out.println("Введите фамилию");
        String musicAuthorSurname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String musicAuthorGender = in.nextLine();
        if (musicAuthorGender.equals("муж")) {
            musicAuthor = new Person(musicAuthorName, musicAuthorSurname, Person.Gender.MALE);
            musicAuthors.add(musicAuthor);
            System.out.println("Автор музыки добавлен");
        } else if (musicAuthorGender.equals("жен")) {
            musicAuthor = new Person(musicAuthorName, musicAuthorSurname, Person.Gender.FEMALE);
            musicAuthors.add(musicAuthor);
            System.out.println("Автор музыки добавлен");
        } else System.out.println("Введено неверное значение");
    }

    public static void addDirector() {
        Director director;
        System.out.println("Введите имя режиссёра");
        String directorName = in.nextLine();
        System.out.println("Введите фамилию режиссёра");
        String directorSurname = in.nextLine();
        System.out.println("Введите пол режиссёра (муж, жен)");
        String directorGender = in.nextLine();
        System.out.println("Введите количество поставленных спектаклей");
        String number = in.nextLine();
        int numberOfShows = Integer.parseInt(number);
        if (directorGender.equals("муж")) {
            director = new Director(directorName, directorSurname, Person.Gender.MALE, numberOfShows);
            directors.add(director);
            System.out.println("Режиссёр добавлен");
        } else if (directorGender.equals("жен")) {
            director = new Director(directorName, directorSurname, Person.Gender.FEMALE, numberOfShows);
            directors.add(director);
            System.out.println("Режиссёр добавлен");
        } else System.out.println("Введено неверное значение");
    }

    public static void addActor() {
        Actor actor;
        System.out.println("Введите имя");
        String actorName = in.nextLine();
        System.out.println("Введите фамилию");
        String actorSurname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String actorGender = in.nextLine();
        System.out.println("Введите рост");
        String height = in.nextLine();
        int heightToInt = Integer.parseInt(height);
        if (actorGender.equals("муж")) {
            actor = new Actor(actorName, actorSurname, Person.Gender.MALE, heightToInt);
            actors.add(actor);
            System.out.println("Актер добавлен");
        } else if (actorGender.equals("жен")) {
            actor = new Actor(actorName, actorSurname, Person.Gender.FEMALE, heightToInt);
            actors.add(actor);
            System.out.println("Актер добавлен");
        } else System.out.println("Введено неверное значение");
    }

    static void createShowMenu() {
        System.out.println("Какой спектакль вы хотите создать (обычный, оперный, балет)?");
        String which = in.nextLine().trim().toLowerCase();
        switch (which) {
            case "обычный":
                createShow();
                break;
            case "оперный":
                createOpera();
                break;
            case "балет":
                createBallet();
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    static void createShow() {
        System.out.println("Введите название: ");
        String title = in.nextLine();
        System.out.println("Введите продолжительность (мин): ");
        String durationString = in.nextLine();
        int duration = Integer.parseInt(durationString);
        Director director = findDirector();
        if (director == null) return;
        Show show = new Show(title, duration, director);
        shows.add(show);
        System.out.println("Спектакль создан.");
    }

    private static Director findDirector() {
        System.out.println("Введите имя режиссёра: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию режиссёра: ");
        String surname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String genderInString = in.nextLine();
        Person.Gender gender = null;
        if (genderInString.equals("муж")) {
            gender = Person.Gender.MALE;
        } else if (genderInString.equals("жен")) {
            gender = Person.Gender.FEMALE;
        } else {
            System.out.println("Введено неверное значение");
        }
        System.out.println("Введите количество поставленных спектаклей");
        String numberOfShowsInString = in.nextLine();
        int numberOfShows = Integer.parseInt(numberOfShowsInString);
        for (Director d : directors) {
            if (d.name.equals(name) && d.surname.equals(surname) && d.gender == gender &&
                    d.numberOfShows == numberOfShows) {
                return d;
            }
        }
        System.out.println("Такого режиссёра нет в списке. Сначала добавьте его (пункт 1).");
        return null;
    }

    private static Person findMusicAuthor() {
        System.out.println("Введите имя автора музыки: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию автора музыки: ");
        String surname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String genderInString = in.nextLine();
        Person.Gender gender = null;
        if (genderInString.equals("муж")) {
            gender = Person.Gender.MALE;
        } else if (genderInString.equals("жен")) {
            gender = Person.Gender.FEMALE;
        } else {
            System.out.println("Введено неверное значение");
        }
        for (Person m : musicAuthors) {
            if (m.name.equals(name) && m.surname.equals(surname) && m.gender == gender) {
                return m;
            }
        }
        System.out.println("Такого автора музыки нет в списке. Сначала добавьте его (пункт 1).");
        return null;
    }

    private static Person findChoreographer() {
        System.out.println("Введите имя хореографа: ");
        String name = in.nextLine();
        System.out.println("Введите фамилию хореографа: ");
        String surname = in.nextLine();
        System.out.println("Введите пол (муж, жен)");
        String genderInString = in.nextLine();
        Person.Gender gender = null;
        if (genderInString.equals("муж")) {
            gender = Person.Gender.MALE;
        } else if (genderInString.equals("жен")) {
            gender = Person.Gender.FEMALE;
        } else {
            System.out.println("Введено неверное значение");
        }
        for (Person ch : choreographers) {
            if (ch.name.equals(name) && ch.surname.equals(surname) && ch.gender == gender) {
                return ch;
            }
        }
        System.out.println("Такого режиссёра нет в списке. Сначала добавьте его (пункт 1).");
        return null;
    }

    static void createOpera() {
        System.out.println("Введите название: ");
        String title = in.nextLine();
        System.out.println("Введите продолжительность (мин): ");
        String durationString = in.nextLine();
        int duration = Integer.parseInt(durationString);
        System.out.println("Введите размер хора");
        String choirSizeInString = in.nextLine();
        int choirSize = Integer.parseInt(choirSizeInString);
        System.out.println("Введите либретто");
        String libretto = in.nextLine();
        Director director = findDirector();
        if (director == null) return;
        Person musicAuthor = findMusicAuthor();
        if (musicAuthor == null) return;
        Opera opera = new Opera(title, duration, director, musicAuthor, libretto, choirSize);
        operas.add(opera);
        System.out.println("Спектакль создан.");
    }

    static void createBallet() {
        System.out.println("Введите название: ");
        String title = in.nextLine();
        System.out.println("Введите продолжительность (мин): ");
        String durationString = in.nextLine();
        int duration = Integer.parseInt(durationString);
        System.out.println("Введите либретто");
        String libretto = in.nextLine();
        Director director = findDirector();
        if (director == null) return;
        Person musicAuthor = findMusicAuthor();
        if (musicAuthor == null) return;
        Person choreographer = findChoreographer();
        Ballet ballet = new Ballet(title, duration, director, musicAuthor, libretto, choreographer);
        ballets.add(ballet);
        System.out.println("Спектакль создан.");
    }

    static void addActorMenu() {
        System.out.println("В какой спектакль вы хотите добавить актера (обычный, оперный, балет)?");
        String which = in.nextLine();
        switch (which) {
            case "обычный":
                System.out.println("Введите название спектакля, в которое хотите добавить актера");
                String title = in.nextLine();
                boolean isFoundShow = false;
                for (Show sh : shows){
                    if (sh.title.equals(title)){
                        addActorInShow(sh);
                        isFoundShow = true;
                        break;
                    }
                }
                if (!isFoundShow) {
                    System.out.println("спектакль под таким названием не найден");
                }
                break;
            case "оперный":
                System.out.println("Введите название оперы, в которую хотите добавить актера");
                String operaTitle = in.nextLine();
                boolean isFoundOpera = false;
                for (Opera o : operas){
                    if (o.title.equals(operaTitle)){
                        addActorInOpera(o);
                        isFoundOpera = true;
                        break;
                    }
                }
                if (!isFoundOpera) {
                    System.out.println("спектакль под таким названием не найден");
                }
                break;
            case "балет":
                System.out.println("Введите название балета, в которое хотите добавить актера");
                String balletTitle = in.nextLine();
                boolean isFoundBallet = false;
                for (Ballet b : ballets){
                    if (b.title.equals(balletTitle)){
                        addActorInBallet(b);
                        isFoundBallet = true;
                        break;
                    }
                }
                if (!isFoundBallet) {
                    System.out.println("спектакль под таким названием не найден");
                }
                break;
            default:
                System.out.println("Неверный ввод.");

        }
    }
    static void addActorInShow(Show show){
        System.out.println("Введите имя, фамилию и рост актера, которого хотите добавить");
        String name = in.nextLine();
        String surname = in.nextLine();
        String heightInString = in.nextLine();
        int height = Integer.parseInt(heightInString);
        boolean isfound = false;
        for (Actor a : actors) {
            if (a.name.equals(name) && a.surname.equals(surname) && a.height == height) {
                show.addActor(a);
                isfound = true;
                break;
            }
        }
        if (!isfound) {
            System.out.println("Такого актера нет в списке");
        }
    }
    static void addActorInOpera(Opera opera){
        System.out.println("Введите имя, фамилию и рост актера, которого хотите добавить");
        String name = in.nextLine();
        String surname = in.nextLine();
        String heightInString = in.nextLine();
        int height = Integer.parseInt(heightInString);
        boolean isfound = false;
        for (Actor a : actors) {
            if (a.name.equals(name) && a.surname.equals(surname) && a.height == height) {
                opera.addActor(a);
                isfound = true;
                break;
            }
        }
        if (!isfound) {
            System.out.println("Такого актера нет в списке");
        }
    }
    static void addActorInBallet(Ballet ballet){
        System.out.println("Введите имя, фамилию и рост актера, которого хотите добавить");
        String name = in.nextLine();
        String surname = in.nextLine();
        String heightInString = in.nextLine();
        int height = Integer.parseInt(heightInString);
        boolean isfound = false;
        for (Actor a : actors) {
            if (a.name.equals(name) && a.surname.equals(surname) && a.height == height) {
                ballet.addActor(a);
                isfound = true;
                break;
            }
        }
        if (!isfound) {
            System.out.println("Такого актера нет в списке");
        }
    }

    static void changeActorMenu(){
        System.out.println("Введите спектакль, в котором хотите заменить актера (обычный, оперный, балет)");
        String which = in.nextLine();
        switch (which) {
            case "обычный": changeActorInShow();
                break;
            case "оперный":
                changeActorInOpera();
                break;
            case "балет":
                changeActorInBallet();
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    static void printActorList(){
        System.out.println("Введите тип спектакля (обычный, оперный, балет), список актеров которого вы хотите увидеть");
        String which = in.nextLine();
        switch (which) {
            case "обычный":
                System.out.println("Введите название спектакля");
                String title = in.nextLine();
                boolean isFoundShow = false;
                for (Show sh : shows){
                    if (sh.title.equals(title)){
                        sh.printActors();
                        isFoundShow = true;
                        break;
                    }
                }
                if (!isFoundShow) {
                    System.out.println("Спектакль под таким названием не найден");
                }
                break;
            case "оперный":
                System.out.println("Введите название спектакля");
                String operaTitle = in.nextLine();
                boolean isFoundOpera = false;
                for (Opera o : operas){
                    if (o.title.equals(operaTitle)){
                        o.printActors();
                        isFoundOpera = true;
                        break;
                    }
                }
                if (!isFoundOpera) {
                    System.out.println("Спектакль под таким названием не найден");
                }
                break;
            case "балет":
                System.out.println("Введите название спектакля");
                String balletTitle = in.nextLine();
                boolean isFoundBallet = false;
                for (Ballet b : ballets){
                    if (b.title.equals(balletTitle)){
                        b.printActors();
                        isFoundBallet = true;
                        break;
                    }
                }
                if (!isFoundBallet) {
                    System.out.println("Спектакль под таким названием не найден");
                }
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    static void printLibretto() {
        System.out.println("Введите тип спектакля (оперный, балет)");
        String which = in.nextLine();
        switch (which) {
            case "оперный":
                System.out.println("Введите название спектакля");
                String title = in.nextLine();
                boolean isFoundOpera = false;
                for (Opera o : operas){
                    if (o.title.equals(title)){
                        System.out.println(o.librettoText);
                        isFoundOpera = true;
                        break;
                    }
                }
                if (!isFoundOpera) {
                    System.out.println("Спектакль под таким названием не найден");
                }
                break;
            case "балет":
                System.out.println("Введите название спектакля");
                String balletTitle = in.nextLine();
                boolean isFoundBallet = false;
                for (Ballet b : ballets){
                    if (b.title.equals(balletTitle)){
                        System.out.println(b.librettoText);
                        isFoundBallet = true;
                        break;
                    }
                }
                if (!isFoundBallet) {
                    System.out.println("Спектакль под таким названием не найден");
                }
                break;
            default:
                System.out.println("Неверный ввод.");
        }
    }

    static void changeActorInShow(){
        System.out.println("Введите название спектакля");
        String title = in.nextLine();
        boolean isShowFound = false;
        for (Show sh : shows){
            if (sh.title.equals(title)){
                isShowFound = true;
                System.out.println("Введите имя, фамилию и рост актера которого хотите заменить");
                String name = in.nextLine();
                String surname = in.nextLine();
                String heightInString = in.nextLine();
                int height = Integer.parseInt(heightInString);
                boolean isActorToRemoveFound = false;
                for (Actor actorToRemove : actors) {
                    if (actorToRemove.name.equals(name) && actorToRemove.surname.equals(surname) &&
                            actorToRemove.height == height) {
                        isActorToRemoveFound = true;
                        System.out.println("Введите имя, фамилию и рост нового актера");
                        String newName = in.nextLine();
                        String newSurname = in.nextLine();
                        String newHeightInString = in.nextLine();
                        int newHeight = Integer.parseInt(newHeightInString);
                        boolean isNewActorFound = false;
                        for (Actor newActor : actors) {
                            if (newActor.name.equals(newName) && newActor.surname.equals(newSurname) &&
                                    newActor.height == newHeight) {
                                sh.changeActor(actorToRemove, newActor);
                                isNewActorFound = true;
                            }
                        }
                        if (!isNewActorFound) System.out.println("Такого актера нет в списке");
                    }
                }
                if (!isActorToRemoveFound) System.out.println("Такого актера нет в списке");
            }
        }
        if (!isShowFound) System.out.println("спектакль под таким названием не найден");
    }

    static void changeActorInOpera(){
        System.out.println("Введите название спектакля");
        String title = in.nextLine();
        boolean isOperaFound = false;
        for (Opera o : operas){
            if (o.title.equals(title)){
                isOperaFound = true;
                System.out.println("Введите имя, фамилию и рост актера которого хотите заменить");
                String name = in.nextLine();
                String surname = in.nextLine();
                String heightInString = in.nextLine();
                int height = Integer.parseInt(heightInString);
                boolean isActorToRemoveFound = false;
                for (Actor actorToRemove : actors) {
                    if (actorToRemove.name.equals(name) && actorToRemove.surname.equals(surname) && actorToRemove.height == height) {
                        isActorToRemoveFound = true;
                        System.out.println("Введите имя, фамилию и рост нового актера");
                        String newName = in.nextLine();
                        String newSurname = in.nextLine();
                        String newHeightInString = in.nextLine();
                        int newHeight = Integer.parseInt(newHeightInString);
                        boolean isNewActorFound = false;
                        for (Actor newActor : actors) {
                            if (newActor.name.equals(newName) && newActor.surname.equals(newSurname) && newActor.height == newHeight) {
                                o.changeActor(actorToRemove, newActor);
                                isNewActorFound = true;
                            }
                        }
                        if(!isNewActorFound) System.out.println("Такого актера нет в списке");
                    }
                }
                if (!isActorToRemoveFound) System.out.println("Такого актера нет в списке");
            }
        }
        if (!isOperaFound) System.out.println("спектакль под таким названием не найден");
    }

    static void changeActorInBallet(){
        System.out.println("Введите название спектакля");
        String title = in.nextLine();
        boolean isBalletFound = false;
        for (Ballet ball : ballets){
            if (ball.title.equals(title)){
                isBalletFound = true;
                System.out.println("Введите имя, фамилию и рост актера которого хотите заменить");
                String name = in.nextLine();
                String surname = in.nextLine();
                String heightInString = in.nextLine();
                int height = Integer.parseInt(heightInString);
                boolean isActorToRemoveFound = false;
                for (Actor actorToRemove : actors) {
                    if (actorToRemove.name.equals(name) && actorToRemove.surname.equals(surname) && actorToRemove.height == height) {
                        isActorToRemoveFound = true;
                        System.out.println("Введите имя, фамилию и рост нового актера");
                        String newName = in.nextLine();
                        String newSurname = in.nextLine();
                        String newHeightInString = in.nextLine();
                        int newHeight = Integer.parseInt(newHeightInString);
                        boolean isNewActorFound = false;
                        for (Actor newActor : actors) {
                            if (newActor.name.equals(newName) && newActor.surname.equals(newSurname) && newActor.height == newHeight) {
                                ball.changeActor(actorToRemove, newActor);
                                isNewActorFound = true;
                            }
                        }
                        if(!isNewActorFound) System.out.println("Такого актера нет в списке");
                    }
                }
                if (!isActorToRemoveFound) System.out.println("Такого актера нет в списке");
            }
        }
        if (!isBalletFound) System.out.println("спектакль под таким названием не найден");
    }
}