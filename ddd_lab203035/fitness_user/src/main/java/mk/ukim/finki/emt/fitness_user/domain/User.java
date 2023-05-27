package mk.ukim.finki.emt.fitness_user.domain;

import jakarta.persistence.*;
import mk.ukim.finki.emt.sharedkernel.domain.AbstractEntity;
import java.time.Period;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="fitness_user")
public class User extends AbstractEntity<UserId> {

    private String name;
    private String surname;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
 //   @Embedded
//    @AttributeOverride(name="id", column=@Column(name="journal_id"))
//    private JournalId journalId;

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

}
