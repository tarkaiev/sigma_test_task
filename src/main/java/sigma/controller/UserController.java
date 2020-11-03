package sigma.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sigma.model.dto.UserRequestDto;
import sigma.model.dto.UserResponseDto;
import sigma.service.UserService;
import sigma.service.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserRequestDto dto) {
        userService.add(userMapper.fromRequestDto(dto));
    }

    @PostMapping("/edit")
    public void editUser(@RequestBody UserRequestDto dto) {
        userService.update(userMapper.fromRequestDto(dto));
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody UserRequestDto dto) {
        userService.delete(userMapper.fromRequestDto(dto));
    }

    @GetMapping("/by-login")
    public UserResponseDto getByLogin(@RequestParam String login) {
        return userMapper.toResponseDto(userService.findByLogin(login));
    }
}
