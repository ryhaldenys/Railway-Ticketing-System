package ua.nulp.kn303.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nulp.kn303.dto.UserDto;
import ua.nulp.kn303.exeption.UserAlreadyExistException;
import ua.nulp.kn303.exeption.UserNotFoundException;
import ua.nulp.kn303.model.User;
import ua.nulp.kn303.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;


    public UserDto getUserById(Long id){
        return getUser(id);
    }

    private UserDto getUser(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(()->new UserNotFoundException("User with id: "+ id+" is not found"));
    }

    @Transactional
    public void createUser(User user){
        checkIsUserAlreadyExist(user);
        create(user);
    }

    private void checkIsUserAlreadyExist(User user) {
        var isPresent = userRepository.findByEmail(user.getEmail()).isPresent();
        if(isPresent)
            throw new UserAlreadyExistException("User with email: "+ user.getEmail() +" already exist");
    }
    private void create(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void removeUser(Long id){
        checkIsUser(id);
        remove(id);
        userRepository.deleteById(id);
    }

    private void checkIsUser(Long id) {
        var isAbsent = userRepository.findById(id).isEmpty();
        if (isAbsent)
            throwsNotUserNotFoundException(id);
    }
    private void remove(Long id) {
        userRepository.deleteById(id);
    }


    private void throwsNotUserNotFoundException(Long id){
        throw new UserNotFoundException("User with id: "+ id+" is not found");
    }
}
