package com.sotckSystem.Stock.mapper;

import com.sotckSystem.Stock.model.DTO.StockDTO;
import com.sotckSystem.Stock.model.Stock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockMapper {

    public StockDTO toDto(Stock entity){
        StockDTO dto = new StockDTO();

        dto.setDate(entity.getDate());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setVariation(entity.getVariation());

        return dto;
    }
    public Stock toEntity(StockDTO dto){
        Stock entity = new Stock();
        entity.setDono(dto.getDono());
        entity.setDate(dto.getDate());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setVariation(dto.getVariation());

        return entity;
    }

    public List<StockDTO> toDtoAll(List<Stock> stocks){
        List<StockDTO> dtos = new ArrayList<>();
        for (Stock stock: stocks) {
            dtos.add(this.toDto(stock));
        }
        return dtos;
    }
}
