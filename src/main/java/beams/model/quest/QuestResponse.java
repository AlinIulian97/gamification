package beams.model.quest;

import lombok.Data;

@Data
public class QuestResponse {

    private Long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private Long tokensId;
    private Long playerId;
}
