package beams.mapper;

import beams.entity.Quest;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface QuestMapper {

    Quest map(QuestRequest questRequest);

    QuestResponse map(Quest quest);

    List<QuestResponse> map(List<Quest> quests);
}
