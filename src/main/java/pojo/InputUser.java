package pojo;

import lombok.*;


@ToString
@AllArgsConstructor
public class InputUser {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String job;
}
