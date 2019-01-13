package pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
public class User {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String first_name;

    @Getter @Setter
    private String last_name;

    @Getter @Setter
    private String avatar;

}
