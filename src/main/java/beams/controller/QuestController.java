package beams.controller;

import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import beams.model.quest.UpdateQuestion;
import beams.model.tokens.DifficultyUpdate;
import beams.model.tokens.TokensResponse;
import beams.service.PlayerService;
import beams.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quest")
public class QuestController {
    private final QuestService questService;

    @PostMapping("/createQuest")
    public QuestResponse createQuest(@RequestBody QuestRequest questRequest){
        return questService.createQuest(questRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteQuest(@PathVariable Long id) {
        questService.deleteQuest(id);
    }

    @GetMapping("/get/{id}")
    public QuestResponse getQuest(@PathVariable Long id) {
        return questService.getQuest(id);
    }

    @PatchMapping("/updateQuestion/{id}")
    public void updateQuestion(@PathVariable Long id, @RequestBody UpdateQuestion question) {
        questService.updateQuestion(id, question);
    }

    @GetMapping("/getAll")
    public List<QuestResponse> getAllQuest() {
        return questService.getAllQuest();
    }

}
