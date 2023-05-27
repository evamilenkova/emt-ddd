package mk.ukim.finki.emt.journal.service.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserForm {
    @NotNull
    public String username;
    @NotNull
    public String name;
    @NotNull
    public String surname;
    @NotNull
    private String password;
    @NotNull
    private String gender;
    @NotNull
    private LocalDate dateOfBirth;
}
