package com.example.demo.mapper;
import com.example.demo.dto.UserDTO;




public class UserMapper {

    // =========================
    // ENTITY → DTO
    // =========================
    public static UserDTO toDTO(UserDTO user) {
        if (user == null) {
            return null;
        }

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    // =========================
    // DTO → ENTITY
    // =========================
    public static UserDTO toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        UserDTO user = new UserDTO();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return user;
    }
}
