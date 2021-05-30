package io.lightfeather.notifier.services.impl;

import io.lightfeather.notifier.models.ManagerDTO;
import io.lightfeather.notifier.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URI = "https://609aae2c0f5a13001721bb02.mockapi.io/lightfeather/managers";

    @Override
    public List<ManagerDTO> getManagers() {
        ManagerDTO[] managerArray = restTemplate.getForObject(URI, ManagerDTO[].class);
        if (Objects.nonNull(managerArray) && managerArray.length > 0) {
            return Arrays.stream(managerArray)
                    .filter(e -> Character.isLetter(e.getJurisdiction().charAt(0)))
                    .peek((e) -> e.setSupervisorDetails(e.getJurisdiction() + " - " + e.getLastName() + ", " + e.getFirstName()))
                    .sorted(Comparator.comparing(ManagerDTO::getSupervisorDetails))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
