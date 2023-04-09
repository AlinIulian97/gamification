package beams.repository;

import beams.entity.Player;
import beams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {

}
