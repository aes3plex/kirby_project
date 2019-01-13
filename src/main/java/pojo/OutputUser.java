package pojo;

import lombok.*;

@ToString
@NoArgsConstructor
public class OutputUser {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String job;

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String createdAt;
}