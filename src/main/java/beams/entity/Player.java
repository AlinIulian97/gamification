package beams.entity;

import beams.entity.enums.EnumGender;
import beams.entity.enums.EnumRank;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private EnumRank playerRank;

    @Column
    private int score;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Badge badge;

    @OneToOne()
    @JoinColumn(name = "user_id" , unique = true)
    private User user;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "player")
    private final List<Quest> quests = new ArrayList<>();

}
