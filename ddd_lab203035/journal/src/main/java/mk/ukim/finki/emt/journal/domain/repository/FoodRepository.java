package mk.ukim.finki.emt.journal.domain.repository;

import mk.ukim.finki.emt.journal.domain.models.Food;
import mk.ukim.finki.emt.journal.domain.models.FoodId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, FoodId> {
}
