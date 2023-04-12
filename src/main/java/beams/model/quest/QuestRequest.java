package beams.model.quest;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class QuestRequest {

    private Long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private Long tokensId;
    private Long playerId;
}
