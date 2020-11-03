package sigma.service.mapper;

import org.springframework.stereotype.Component;
import sigma.model.User;
import sigma.model.dto.UserRequestDto;
import sigma.model.dto.UserResponseDto;

@Component
public class UserMapper {
    public User fromRequestDto(UserRequestDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setAbout(dto.getAbout());
        user.setAddress(dto.getAddress());
        return user;
    }

    public UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setLogin(user.getLogin());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setAbout(user.getAbout());
        dto.setAddress(user.getAddress());
        return dto;
    }
}
