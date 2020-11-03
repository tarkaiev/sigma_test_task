package sigma.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String about;
    private String address;

}
