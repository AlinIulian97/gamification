package beams.controller;

import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import beams.service.PlayerService;
import beams.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quest")
public class QuestController {
    private final QuestService questService;

    @PostMapping("/createQuest")
    public QuestResponse createQuest(@RequestBody QuestRequest questRequest){
        return questService.createQuest(questRequest);
    }

}
