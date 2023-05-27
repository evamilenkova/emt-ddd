package mk.ukim.finki.emt.journal.service;

import mk.ukim.finki.emt.journal.domain.models.User;
import mk.ukim.finki.emt.journal.domain.models.UserId;
import mk.ukim.finki.emt.journal.service.forms.UserForm;

import java.util.List;

public interface UserService {


        List<User> listAll();

        User findById(UserId userId);

        User createUser(UserForm userForm);

        User updateUser(UserId userId, UserForm userForm);

        void deleteUser(UserId userId);


}
