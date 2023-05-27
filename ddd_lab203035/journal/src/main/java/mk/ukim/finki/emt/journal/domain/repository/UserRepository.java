package mk.ukim.finki.emt.journal.domain.repository;

import mk.ukim.finki.emt.journal.domain.models.User;
import mk.ukim.finki.emt.journal.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
