package beams.mapper;

import beams.entity.Quest;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface QuestMapper {

    Quest map(QuestRequest questRequest);

    @Mapping(source = "player.id", target = "playerId")
    @Mapping(source = "tokens.id", target = "tokensId")
    QuestResponse map(Quest quest);

    List<QuestResponse> map(List<Quest> quests);
}
