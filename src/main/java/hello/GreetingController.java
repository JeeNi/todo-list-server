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
    List<Person> persons = new ArrayList<Person>();
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController() {
        persons.add(new Person("은진", "아오..."));
        persons.add(new Person("한울", "하하하하하 나도 아마존.."));
    }

    @CrossOrigin("*")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @CrossOrigin("*")
    @RequestMapping(value="/persons", method = RequestMethod.GET)
    public List<Person> greeting() {
        return persons;
    }

    @CrossOrigin("*")
    @RequestMapping(value="/persons", method = RequestMethod.POST)
    public String addPerson(@RequestBody Person person) {
        System.out.println(person.toString());
        this.persons.add(person);
        return "Success";
    }
}