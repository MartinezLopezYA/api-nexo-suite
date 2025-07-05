package com.websolutions.ns.service;

import com.websolutions.ns.dto.UserRequestDTO;
import com.websolutions.ns.dto.UserResponseDTO;
import com.websolutions.ns.exception.entities.BusinessException;
import com.websolutions.ns.exception.entities.ResourceNotFoundException;
import com.websolutions.ns.model.User;
import com.websolutions.ns.model.mapper.UserMapper;
import com.websolutions.ns.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO dto) {
        if (userRepository.existsByUserEmail(dto.getUserEmail())) {
            throw new BusinessException("Email already exists", "USER_001");
        }
        User user = UserMapper.toEntity(dto);
        return UserMapper.toDTO(userRepository.save(user));
    }

    public UserResponseDTO getUserById(UUID uuid) {
        User user = userRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("User", uuid.toString()));
        return UserMapper.toDTO(user);
    }

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .toList();
    }

}
