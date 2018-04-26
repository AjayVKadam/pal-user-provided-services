package io.pivotal.pal.paluserprovidedservices;

public class Cohort {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    String name;
    String nickname;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
