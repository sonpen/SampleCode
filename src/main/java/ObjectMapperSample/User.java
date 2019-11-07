package ObjectMapperSample;

import java.util.List;

/**
 * Created by 1109806 on 2019-10-31.
 */
public class User {
    private String name;
    private int age;
    private List<String> message;

    public User() {

    }

    public User(String name, int age, List<String> message){
        this.name = name;
        this.age = age;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
