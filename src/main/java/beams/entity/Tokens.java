package beams.entity;

import beams.entity.enums.EnumDifficulty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="tokens_number")
    private int tokensNumbers;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private EnumDifficulty enumDifficulty;


    @OneToMany(mappedBy = "tokens" , cascade = CascadeType.ALL )
    private final List<Quest> questList = new ArrayList<>();
}
