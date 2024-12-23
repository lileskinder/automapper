package io.github.lileskinder.automapper;

public class UserDTO {
    private String name;
    private Integer age;

    public UserDTO() {}

    public UserDTO(String name) {
        this.name = name;
    }

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
