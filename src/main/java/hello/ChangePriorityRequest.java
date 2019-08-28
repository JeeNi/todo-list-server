package hello;

public class ChangePriorityRequest
{
    private int from;
    private int to;

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to ) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }
    
    public int getTo() {
        return to;
    }

    public String toString() {
        return String.format("[Change Request Object. {from : %d, to: %d}]", this.from, this.to);
    }
}