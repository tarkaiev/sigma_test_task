package sigma.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String about;
    private String address;
}
