package io.lightfeather.notifier.controllers;

import io.lightfeather.notifier.models.ManagerDTO;
import io.lightfeather.notifier.models.UserDTO;
import io.lightfeather.notifier.services.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(value = "/api")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "/supervisors")
    public List<ManagerDTO> getSupervisors() {
        return managerService.getManagers();
    }

    @PostMapping(value = "/submit")
    public UserDTO submit(@Valid @RequestBody UserDTO userDto) {
        LOGGER.info("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        LOGGER.info(userDto.toString());
        LOGGER.info("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        return userDto;
    }
}
