package mk.ukim.finki.emt.journal.domain.models;


import jakarta.persistence.*;

import mk.ukim.finki.emt.journal.domain.models.enums.ActivityLevel;
import mk.ukim.finki.emt.journal.domain.models.enums.Goal;
import mk.ukim.finki.emt.sharedkernel.domain.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Journal extends AbstractEntity<JournalId> {
  @Embedded
  @AttributeOverride(name="number", column = @Column(name="weight"))
    private Number weight;
  @Embedded
  @AttributeOverride(name="number", column = @Column(name="height"))
    private Number height;
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;
    @Enumerated(EnumType.STRING)
    private Goal goal;
    @ManyToMany(fetch=FetchType.EAGER)
  private List<Food> foods;
  @OneToOne
  private User user;


    public Journal(){
      this.foods=new ArrayList<>();
    }

    public void addFood(Food f){
      Objects.requireNonNull(f,"food must not be null");
      this.foods.add(f);
    }
    public void deleteFood(FoodId fId){
      this.foods.removeIf(i->i.getId().equals(fId));
    }
    public List<Food> getFoods(){
      return this.foods;
    }

    public Number intakeCalories(){
      return new Number(this.foods.stream().mapToDouble(i->i.getCalories().getNumber()).sum());
    }

    public Number calculateCalories(){
      int age=this.user.getAge();

      double calories = 0.0;
      if (Objects.equals(user.getGender().toString(), "FEMALE")) {
        calories = 655 + (9.6 * this.weight.getNumber()) + (1.8 * this.height.getNumber()) - (4.7 * age);
        if (this.goal.toString() == "GAIN") {
          calories = calories + 300;
        }
        else if (this.goal.toString() == "LOSE_WEIGHT") {
          calories = calories - 300;
        }
      }
      else {
        calories = 66 + (13.7 * this.weight.getNumber()) + (5 * this.height.getNumber()) - (6.8 * age);
        if (this.goal.toString() == "GAIN") {
          calories = calories + 500;
        }
        else if (this.goal.toString() == "LOSE_WEIGHT") {
          calories = calories - 500;
        }

      }

      if (this.activityLevel.toString() == "LIGHT") {
        calories = calories * 1.375;
      }
      else if (this.activityLevel.toString() == "MODERATE") {
        calories = calories * 1.55;
      }
      else if (this.activityLevel.toString() == "ACTIVE") {
        calories = calories * 1.725;
      }
      return new Number(calories);
    }



    


}