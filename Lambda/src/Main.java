import academit.kashirin.lambda.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList();

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

        System.out.println("Список уникальных имен: " + people.stream().map(p -> p.getName()).distinct().collect(Collectors.joining(", ")));
        System.out.println("Список людей младше 18: " + people.stream().filter(p -> p.getAge() < 18).map(p -> p.getName()).collect(Collectors.joining(", ")));
        System.out.println("Средний возраст людей младше 18 = " + people.stream().filter(p -> p.getAge() < 18).mapToDouble(p -> p.getAge()).average().getAsDouble());

        Map<String, Double> personsByAge = people.stream().collect(Collectors.groupingBy(p->p.getName(), Collectors.averagingDouble(p->p.getAge())));
        personsByAge.forEach((p, age) -> System.out.printf("%s: %s%n", p, age));

        System.out.println("Возраст от 20 до 45 = " + people.stream().filter(p -> p.getAge() > 20 && p.getAge() < 45).sorted(Comparator.comparingInt((Person p)->p.getAge()).reversed()).map(p -> p.getName()).collect(Collectors.joining(", ")));

    }
}
