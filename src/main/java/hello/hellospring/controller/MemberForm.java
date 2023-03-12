package hello.hellospring.controller;

public class MemberForm {

    private String name;

    public String getName() {
        return name; //template에 members에 createMemberForm에 있는 name이랑 매치가 되어서 들어온다.
    }

    public void setName(String name) {
        this.name = name;
    }

}
