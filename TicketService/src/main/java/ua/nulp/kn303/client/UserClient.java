package ua.nulp.kn303.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.nulp.kn303.dto.UserDto;

@FeignClient(name = "users")
public interface UserClient {
    @GetMapping("/users/{id}")
    UserDto getUserById(@PathVariable Long id);
}
