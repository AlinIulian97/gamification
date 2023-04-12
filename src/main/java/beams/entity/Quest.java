package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @Column(name = "answer_a")
    @NotNull
    private String answerA;

    @NotNull
    @Column(name = "answer_b")
    private String answerB;

    @NotNull
    @Column(name = "answer_c")
    private String answerC;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tokens tokens;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

}
