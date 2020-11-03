package sigma.model.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String about;
    private String address;
}
