package beams.repository;

import beams.entity.Quest;
import beams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest,Long> {

}
