package io.lightfeather.notifier.services.impl;

import io.lightfeather.notifier.models.ManagerDTO;
import io.lightfeather.notifier.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URI = "https://609aae2c0f5a13001721bb02.mockapi.io/lightfeather/managers";

    @Override
    public List<String> getManagers() {
        ManagerDTO[] managerArray = restTemplate.getForObject(URI, ManagerDTO[].class);
        if (Objects.nonNull(managerArray) && managerArray.length > 0) {
            return Arrays.asList(managerArray).stream()
                    .map(e -> e.getJurisdiction() + " - " + e.getLastName() + ", " + e.getFirstName())
                    .filter(e -> Character.isLetter(e.charAt(0)))
                    .sorted()
                    .collect(Collectors.toList());
        }
        return null;
    }
}
