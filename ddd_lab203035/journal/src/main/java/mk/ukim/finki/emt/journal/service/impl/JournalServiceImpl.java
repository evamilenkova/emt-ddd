package mk.ukim.finki.emt.journal.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.journal.domain.models.Food;
import mk.ukim.finki.emt.journal.domain.models.FoodId;
import mk.ukim.finki.emt.journal.domain.models.Journal;
import mk.ukim.finki.emt.journal.domain.models.JournalId;
import mk.ukim.finki.emt.journal.domain.models.exceptions.FoodDoesNotExistException;
import mk.ukim.finki.emt.journal.domain.models.exceptions.JournalDoesNotExistException;
import mk.ukim.finki.emt.journal.domain.repository.FoodRepository;
import mk.ukim.finki.emt.journal.domain.repository.JournalRepository;
import mk.ukim.finki.emt.journal.service.JournalService;
import mk.ukim.finki.emt.sharedkernel.domain.Number;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JournalServiceImpl implements JournalService {

    private final JournalRepository journalRepository;
    private final FoodRepository foodRepository;
    @Override
    public Number calculateRequiredCalories() {
        return null;
    }

    @Override
    public Optional<Journal> findById(JournalId journalId) {
        return this.journalRepository.findById(journalId);
    }

    @Override
    public void addFood(JournalId journalId, FoodId fId) throws JournalDoesNotExistException {
        Journal journal=this.findById(journalId).orElseThrow(JournalDoesNotExistException::new);
        Food food=this.foodRepository.findById(fId).orElseThrow(FoodDoesNotExistException::new);
        journal.addFood(food);
        this.journalRepository.saveAndFlush(journal);
    }


    @Override
    public void deleteFood(JournalId journalId,FoodId foodId) {
        Journal journal=this.findById(journalId).orElseThrow(JournalDoesNotExistException::new);
        journal.deleteFood(foodId);
        this.journalRepository.saveAndFlush(journal);
    }

    @Override
    public Number calculateCalories(JournalId journalId) {
        Journal journal=this.findById(journalId).orElseThrow(JournalDoesNotExistException::new);
        return journal.calculateCalories();
    }

    @Override
    public List<Food> getFoods(JournalId journalId) {
        Journal journal=this.findById(journalId).orElseThrow(JournalDoesNotExistException::new);
        return journal.getFoods();
    }

    @Override
    public Number totalIntake(JournalId journalId) {
        Journal journal=this.findById(journalId).orElseThrow(JournalDoesNotExistException::new);
        return journal.intakeCalories();
    }
}
