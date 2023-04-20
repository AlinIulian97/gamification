package beams.service;

import beams.entity.Player;
import beams.entity.Quest;
import beams.exception.BusinessException;
import beams.mapper.QuestMapper;
import beams.model.player.PlayerResponse;
import beams.model.player.UpdatePlayerName;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import beams.model.quest.UpdateQuestion;
import beams.repository.PlayerRepository;
import beams.repository.QuestRepository;
import beams.repository.TokensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class QuestService {

    public final QuestRepository questRepository;
    public final QuestMapper questMapper;
    public final TokensRepository tokensRepository;
    public final PlayerRepository playerRepository;

    public QuestResponse createQuest(QuestRequest questRequest){
        Quest createQuest = questMapper.map(questRequest);
        createQuest.setPlayer(playerRepository.findById(questRequest.getPlayerId()).orElseThrow(
                ()-> new BusinessException("Player is not found")));
        createQuest.setTokens(tokensRepository.findById(questRequest.getTokensId()).orElseThrow(
                ()-> new BusinessException("Token is not found")));
        questRepository.save(createQuest);
        return questMapper.map(createQuest);
    }

    public void deleteQuest(Long id) {
        Quest deleteQuest = questRepository.findById(id).orElseThrow(
                () -> new BusinessException("Quest is not found"));
        questRepository.delete(deleteQuest);
    }

    public QuestResponse getQuest(Long id) {
        return questMapper.map(questRepository.findById(id).orElseThrow(
                () -> new BusinessException("Quest is not found")));
    }

    public List<QuestResponse> getAllQuest() {
        return questMapper.map(questRepository.findAll());
    }

    public void updateQuestion(Long id , UpdateQuestion question){
        Quest updateQuestion = questRepository.findById(id).orElseThrow(
                () -> new BusinessException("Quest is not found"));
        updateQuestion.setQuestion(question.getQuestion());
        questRepository.save(updateQuestion);
    }
}
