package beams.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column
    private String password;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private Player player;
}
