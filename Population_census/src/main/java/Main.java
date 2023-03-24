import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> minors = persons.stream();
        minors.filter(x -> x.getAge() < 18)
                .count();

        Stream<Person> conscript = persons.stream();
        conscript.filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .filter(x -> x.getSex().equals(Sex.MAN))
                .map(Person::getFamily)
                .collect(Collectors.toList());

        Stream<Person> higherEducation = persons.stream();
        higherEducation.filter(x -> x.getSex().equals(Sex.WOMAN) ? x.getAge() >= 21 : x.getAge() < 60)
                .filter(x -> x.getSex().equals(Sex.MAN) ? x.getAge() >= 21 : x.getAge() < 65)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
