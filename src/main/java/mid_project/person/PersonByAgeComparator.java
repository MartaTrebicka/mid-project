package mid_project.person;

import mid_project.log4jDemo.Log4jDemo;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class PersonByAgeComparator implements Comparator<Person> {
    private final static Logger LOGGER = Logger.getLogger(PersonByAgeComparator.class);

    @Override
    public int compare(Person first, Person second) {

        LOGGER.info("Comparing 2 people");
        return first.getAge() - second.getAge();
    }
}