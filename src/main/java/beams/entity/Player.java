package beams.entity;

import beams.entity.enums.EnumGender;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated
    private EnumGender gender;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private User user;

}
