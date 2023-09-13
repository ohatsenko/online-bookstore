package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.UserRegistrationRequestDto;
import com.example.onlinebookstore.dto.UserRegistrationResponseDto;
import com.example.onlinebookstore.exception.RegistrationException;
import com.example.onlinebookstore.mapper.UserMapper;
import com.example.onlinebookstore.model.Role;
import com.example.onlinebookstore.model.User;
import com.example.onlinebookstore.repository.RoleRepository;
import com.example.onlinebookstore.repository.UserRepository;
import com.example.onlinebookstore.service.UserService;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    @Override
    public UserRegistrationResponseDto register(UserRegistrationRequestDto request)
            throws RegistrationException {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException("Unable to complete registration");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setShippingAddress(request.getShippingAddress());

        Set<Role> roles = new HashSet<>();
        Role defaultRole = roleRepository.findByName(Role.RoleName.ROLE_USER).orElseThrow(
                () -> new RegistrationException("Can't find a role: "
                        + Role.RoleName.ROLE_USER));
        roles.add(defaultRole);
        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }
}
