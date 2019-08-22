package hello;

public class Person {
    private String name = "";
    private String desc = "";

    public Person() {
    }

    public Person(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }


    public String toString() {
        return String.format("[Name : %s, Desc: %s]", name, desc);
    }

}