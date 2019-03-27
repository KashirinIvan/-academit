import academit.kashirin.lambda.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Иван", 27));
        people.add(new Person("Денис", 25));
        people.add(new Person("Иван", 42));
        people.add(new Person("Роман", 27));
        people.add(new Person("Дмитрий", 2));
        people.add(new Person("Алексей", 65));
        people.add(new Person("Константин", 70));
        people.add(new Person("Александр", 6));
        people.add(new Person("Валерий", 12));
        people.add(new Person("Олег", 35));
        people.add(new Person("Петр", 7));
        people.add(new Person("Никита", 16));

        System.out.println(people.toString());

        System.out.println("Список уникальных имен: " + people.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ")));

        System.out.println("Список людей младше 18: " + people.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.joining(", ")));

        OptionalDouble temp = people.stream()
                .filter(p -> p.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average();
        if (temp.isPresent()) {
            System.out.println("Средний возраст людей младше 18 = " + temp.getAsDouble());
        } else {
            System.out.println("Средний возраст людей младше 18 не посчитан");
        }

        Map<String, Double> personsByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        personsByAge.forEach((p, age) -> System.out.printf("%s: %s%n", p, age));

        System.out.println("Возраст от 20 до 45 = " + people.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.joining(", ")));
    }
}
