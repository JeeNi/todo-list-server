package hello;

public class UpdateRequest
{
    private String title;
    private String content;
    private int index;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }
    
    public String getContent() {
        return content;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return String.format("[Update Request Object. {title : %s, content: %s, index: %d}]", this.title, this.content, this.index);
    }
}