package mid_project.lombokDemo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class PersonLomboked {

    private String name;
    private String surname;

    private int age;

}
