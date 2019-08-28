package hello;

public class Person {
    private String title = "";
    private String content = "";

    public Person() {
    }

    public Person(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return String.format("[Title : %s, Content: %s]", title, content);
    }
}