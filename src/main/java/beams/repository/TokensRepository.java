package beams.repository;

import beams.entity.Tokens;
import beams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokensRepository extends JpaRepository<Tokens,Long> {

}
