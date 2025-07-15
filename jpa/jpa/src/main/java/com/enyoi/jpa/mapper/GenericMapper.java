package com.enyoi.jpa.mapper;

import java.util.ArrayList;
import java.util.List;

public interface GenericMapper<D, M> {

    D modelToDto(M model);
    M dtoToModel(D dto);

    default List<D> modelListToDtoList(List<M> modelList){
        List<D> dtoList = new ArrayList<>();
        for(M m: modelList){
            D dto = modelToDto(m);
            dtoList.add(dto);
        }
        return dtoList;
    }

    default List<M> dtoListToModelList(List<D> dtoList){
        List<M> modelList = new ArrayList<>();
        for(D dto: dtoList){
            M model = dtoToModel(dto);
            modelList.add(model);
        }
        return modelList;
    }


}
