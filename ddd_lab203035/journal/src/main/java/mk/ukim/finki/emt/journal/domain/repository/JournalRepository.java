package mk.ukim.finki.emt.journal.domain.repository;

import mk.ukim.finki.emt.journal.domain.models.Journal;
import mk.ukim.finki.emt.journal.domain.models.JournalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, JournalId> {
}
