package mk.ukim.finki.emt.journal.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.DomainObject;
import mk.ukim.finki.emt.sharedkernel.domain.Number;

@Entity
@Getter
public class Food extends AbstractEntity<FoodId> {

    private String name;
    @Embedded
    @AttributeOverride(name="number", column = @Column(name="calories"))
    private Number calories;
    @Embedded
    @AttributeOverride(name="number", column = @Column(name="carbohydrates"))
    private Number carbohydrates;
    @Embedded
    @AttributeOverride(name="number", column = @Column(name="fats"))
    private Number fats;
    @AttributeOverride(name="number", column = @Column(name="proteins"))
    private Number proteins;


}
