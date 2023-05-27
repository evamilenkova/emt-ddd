package mk.ukim.finki.emt.journal.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emt.journal.domain.models.enums.Gender;
import mk.ukim.finki.emt.sharedkernel.domain.AbstractEntity;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="fitness_user")
@Getter
@Setter
public class User extends AbstractEntity<UserId> {

    private String name;
    private String surname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    @OneToOne(mappedBy="user")
    private Journal journal;

    public User() {

    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public User(String name, String surname, String username, String password, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender);
        this.dateOfBirth = dateOfBirth;
        this.journal = new Journal();
    }


    public void updateUser(String name, String surname, String username, String password, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender);
        this.dateOfBirth = dateOfBirth;
    }


}
