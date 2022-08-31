package com.example.practicafragmentos20.api.converter;

import com.example.practicafragmentos20.data.entity.SearchClientEntity;
import com.example.practicafragmentos20.domain.dto.SearchClientDto;


public class SearchClientConverter {
    public static SearchClientEntity convertFromDto(SearchClientDto searchClientDto) {
        SearchClientEntity searchClientEntity;
        searchClientEntity = new SearchClientEntity();
        searchClientEntity.setAccountNumber(searchClientDto.getAccountNumber());
        searchClientEntity.setCurp(searchClientDto.getCurp());
        searchClientEntity.setNss(searchClientDto.getNss());

        return searchClientEntity;
    }
}
