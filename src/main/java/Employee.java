import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    int age;

    private List<String> skills;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Employee(String firstName, String lastName, int age, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;

    }

    public String getSkillsName(){
        String[] tmp = new String[4];
        int i = 0;
        for (String skill : skills) {
            tmp[i] = skill;
            i++;
        }
        String result = tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3];

        return result;
    }

    @Override
    public String toString(){
        String tmp = (firstName + "-" + lastName + "-" + age + "- {" + getSkillsName() + "}");
        return tmp;
    }
}
