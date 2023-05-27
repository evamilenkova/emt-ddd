package mk.ukim.finki.emt.journal.service;

import mk.ukim.finki.emt.journal.domain.models.Food;
import mk.ukim.finki.emt.journal.domain.models.FoodId;
import mk.ukim.finki.emt.journal.domain.models.Journal;
import mk.ukim.finki.emt.journal.domain.models.JournalId;
import mk.ukim.finki.emt.journal.domain.models.exceptions.FoodDoesNotExistException;
import mk.ukim.finki.emt.sharedkernel.domain.Number;

import java.util.List;
import java.util.Optional;

public interface JournalService {


     Number calculateRequiredCalories();
    Optional<Journal> findById(JournalId journalId);
    void addFood(JournalId journalId,FoodId foodId) throws FoodDoesNotExistException;
    void deleteFood(JournalId journalId,FoodId foodId);
    Number calculateCalories(JournalId journalId);
    List<Food> getFoods(JournalId journalId);
    Number totalIntake(JournalId journalId);


}
