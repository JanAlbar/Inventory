package com.inventory.service;

import com.inventory.model.User;
import com.inventory.model.user.UserCreateDTO;
import com.inventory.model.user.UserResponseDTO;
import com.inventory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO createUser(UserCreateDTO userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    public List<UserResponseDTO> getAllUser() {
        return mapToDtoList(userRepository.findAll());
    }

    private List<UserResponseDTO> mapToDtoList(List<User> userList) {
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRole()).toUpperCase())
                .build();
    }
}
