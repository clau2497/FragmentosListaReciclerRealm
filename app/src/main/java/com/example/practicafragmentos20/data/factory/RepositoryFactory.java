package com.example.practicafragmentos20.data.factory;


import com.example.practicafragmentos20.data.repository.ClientRepository;

public abstract class RepositoryFactory {

    public abstract ClientRepository createClientRepository();

}
