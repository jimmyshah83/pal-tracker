package io.pivotal.pal.k8s;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
