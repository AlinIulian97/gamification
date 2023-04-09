package beams.entity;

import beams.entity.enums.EnumGender;
import beams.entity.enums.EnumRank;
import jdk.jfr.Name;
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

    @Enumerated(EnumType.STRING)
    private EnumGender gender;

    @Enumerated(EnumType.STRING )
    private EnumRank playerRank;

    @Column
    private int score;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Badges badges ;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private User user;

}
