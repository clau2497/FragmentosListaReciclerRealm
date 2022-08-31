package com.example.practicafragmentos20.database.converter;
import com.example.practicafragmentos20.data.entity.ClientEntity;
import com.example.practicafragmentos20.database.model.ClientModel;

import java.util.ArrayList;
import java.util.List;

public class ClientModelConverter {
    public static ClientEntity convertFromModel(ClientModel clientModel) {
        ClientEntity clientEntity;
        clientEntity = new ClientEntity();
        clientEntity.setFatherLastName(clientModel.getFatherLastName());
        clientEntity.setFullName(clientModel.getFullName());
        clientEntity.setMotherLastName(clientModel.getMotherLastName());
        clientEntity.setName(clientModel.getName());
        return clientEntity;
    }

    public static ClientModel convertFromEntity(ClientEntity clientEntity) {
        ClientModel clientModel;
        clientModel = new ClientModel();
        clientModel.setFatherLastName(clientEntity.getFatherLastName());
        clientModel.setMotherLastName(clientEntity.getMotherLastName());
        clientModel.setName(clientEntity.getName());

        return clientModel;
    }

    public static List<ClientEntity> convertFromModels(List<ClientModel> clientModels) {
        List<ClientEntity> clientEntities;
        clientEntities = new ArrayList<>();

        for (ClientModel clientModel : clientModels) {
            clientEntities.add(convertFromModel(clientModel));
        }

        return clientEntities;
    }

    public static List<ClientModel> convertFromEntities(List<ClientEntity> clientEntities) {
        List<ClientModel> clientModels;
        clientModels = new ArrayList<>();

        for (ClientEntity clientEntity : clientEntities) {
            clientModels.add(convertFromEntity(clientEntity));
        }

        return clientModels;
    }
}
