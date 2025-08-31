package com.inventory.service;

import com.inventory.model.User;
import com.inventory.model.user.UserCreateDTO;
import com.inventory.model.user.UserResponseDTO;
import com.inventory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponseDTO createUser(UserCreateDTO userDto) {
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
}
