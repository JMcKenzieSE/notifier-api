package io.lightfeather.notifier.services;

import io.lightfeather.notifier.models.ManagerDTO;

import java.util.List;

public interface ManagerService {
    List<ManagerDTO> getManagers();
}
