import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    List<Employee> employees = new ArrayList<>();

    public void setUp(){
        Employee employee1 = new Employee("Honkytonk", "Cumbercooch", 25, List.of("Java", "JavaScript", "Python"));
        Employee employee2 = new Employee("Brewery", "Chickenstrips", 31, List.of("C#"));
        Employee employee3 = new Employee("Beetlejuice", "Snugglesnatch", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Boobytrap", "Humperdinck", 42, List.of("PHP","JavaScript", "React", "Angular"));
        Employee employee5 = new Employee("Buttermilk", "Bumbersplat", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Rinkydink", "Curdlesnoot", 30, List.of("C", "C++"));
        Employee employee7 = new Employee("Cogglesnatch", "Splishnsplash", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Tiddleywomp", "Charmander", 51, List.of("Java", "Spring", "Hibernate", "Java"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
    }
    public static void main(String[] args){
        StreamsExample streamsExample = new StreamsExample();
        streamsExample.setUp();

        streamsExample.reduceOperation();

    }

     public void mapOperation() {
         employees.stream()
                 .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                 .forEach(System.out::println);
     }

     public void flatMapOperation(){
         List<List<String>> allSkills = employees.stream()
                 .map(Employee::getSkills)
                 .collect(Collectors.toList());

         System.out.println(allSkills);

         List<String> allSkills2 = employees.stream()
                 .map(Employee::getSkills)
                 .flatMap(list -> list.stream())
                 .distinct()
                 .collect(Collectors.toList());

         System.out.println(allSkills2);
     }


     public void filterOperation(){
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .forEach(System.out::println);
     }

     public void sortedOperation(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
     }

     public void limitOperation(){
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getSkills().size()))
                .limit(2)
                .forEach(System.out::println);
     }

     public void skipOperation(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .skip(2)
                .forEach(System.out::println);
     }

     public void countOperation(){
         long numberOfEmpoyees = employees.stream()
                 .filter(employee -> employee.getFirstName().startsWith("B"))
                 .count();

         System.out.println(numberOfEmpoyees);

//         employees.stream()
//                 .sorted(Comparator.comparing(Employee::getAge))
//                 .skip(numberOfEmpoyees - 2)
//                 .forEach(System.out::println);

     }

     public void minMaxOperation(){
         Employee oldestEmployee = employees.stream()
                 .max(Comparator.comparing(Employee::getAge))
                 .get();

         System.out.println(oldestEmployee);
     }

     public void findAnyFindFirstOperation(){
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .findFirst().get();
     }

     public void matchOperations(){
         boolean b = employees.stream()
                 .anyMatch(employee -> employee.getFirstName().contains("a"));

         System.out.println(b);
     }

     public void reduceOperation(){
         Integer sumOfAllAges = employees.stream()
                 .map(Employee::getAge)
                 .reduce((age1, age2) -> age1 + age2)
                 .get();

         System.out.println(sumOfAllAges);
     }
}
