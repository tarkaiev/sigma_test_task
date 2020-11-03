package sigma.model.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String about;
    private String address;

}
