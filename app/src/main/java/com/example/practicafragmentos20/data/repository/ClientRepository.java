package com.example.practicafragmentos20.data.repository;

import com.example.practicafragmentos20.data.entity.ClientEntity;


import java.util.List;

public interface ClientRepository {
    ClientEntity getSelected();
    ClientEntity update(ClientEntity clientEntity);
    List<ClientEntity> addAll(List<ClientEntity> clientEntities);
    List<ClientEntity> getAll();
    void clear();
}
