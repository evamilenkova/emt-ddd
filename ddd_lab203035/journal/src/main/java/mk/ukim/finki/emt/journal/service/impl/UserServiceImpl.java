package mk.ukim.finki.emt.journal.service.impl;

import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.journal.domain.models.User;
import mk.ukim.finki.emt.journal.domain.models.UserId;
import mk.ukim.finki.emt.journal.domain.models.enums.Gender;
import mk.ukim.finki.emt.journal.domain.models.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.journal.domain.repository.UserRepository;
import mk.ukim.finki.emt.journal.service.UserService;
import mk.ukim.finki.emt.journal.service.forms.UserForm;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Validator validator;
    @Override
    public List<User> listAll() {
       return this.userRepository.findAll();
    }

    @Override
    public User findById(UserId userId) {
        return this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(UserForm userForm) {
        var violations = validator.validate(userForm);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid client data");
        }

        var c = new User(userForm.getName(), userForm.getSurname(), userForm.getUsername(), userForm.getPassword(), userForm.getGender(), userForm.getDateOfBirth());

        return userRepository.saveAndFlush(c);
    }


    @Override
    public User updateUser(UserId userId, UserForm userForm) {
        var user = findById(userId);

        user.setUsername(userForm.getUsername());
        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setGender(Gender.valueOf(userForm.getGender()));
        user.setPassword(userForm.getPassword());
        user.setDateOfBirth(userForm.getDateOfBirth());

        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepository.deleteById(userId);
    }
}
