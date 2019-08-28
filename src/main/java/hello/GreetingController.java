package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class GreetingController {
    ArrayList<Person> persons = new ArrayList<Person>();
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController() {
        persons.add(new Person("은진", "아오..."));
        persons.add(new Person("한울", "하하하하하 나도 아마존.."));
        persons.add(new Person("구절", "똥싸개"));
    }

    @CrossOrigin("*")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="title", defaultValue="World") String title) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, title));
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> greeting() {
        return persons;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public String addPerson(@RequestBody Person person) {
        // System.out.println(person.toString());
        this.persons.add(person);
        return "Success";
    }

    @CrossOrigin("*")
    @RequestMapping(value =  "/persons/change", method = RequestMethod.PUT)
    public String changeOrder(@RequestBody ChangePriorityRequest changeRequest) {
        
        int from = changeRequest.getFrom();
        int to = changeRequest.getTo();
        System.out.println(String.format("from %d to %d", from, to));
        Person p = persons.get(from);
        persons.remove(from);

        if ( from  < to) {
            persons.add(to -1, p);
        } else {
            persons.add(to, p);
        }
       
        System.out.println(changeRequest);
        return "Change";
    }
    
    @CrossOrigin("*")
    @RequestMapping(value = "/persons/update", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody UpdateRequest update) {

        String title = update.getTitle();
        String content = update.getContent();
        int index = update.getIndex();

        System.out.println(update.toString());

        Person p = persons.get(index);
        p.setContent(content);
        p.setTitle(title);

        return "Update";
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/persons/remove", method = RequestMethod.PUT)
    public String removeOrder(@RequestBody RemoveRequest remove) {
        
        int index = remove.getIndex();

        System.out.println(remove.toString());

        Person p = persons.get(index);
       
        persons.remove(index);
        
        return "Remove";
    }
}