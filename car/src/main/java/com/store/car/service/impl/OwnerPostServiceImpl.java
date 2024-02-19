package com.store.car.service.impl;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPostEntity = mapOwnerConvertDTOToEntity(ownerPostDTO);
        ownerPostRepository.save(ownerPostEntity);
    }

    private OwnerPostEntity mapOwnerConvertDTOToEntity(OwnerPostDTO ownerPostDTO){
        OwnerPostEntity ownerPostEntity =  new OwnerPostEntity();
        ownerPostEntity.setName(ownerPostDTO.getName());
        ownerPostEntity.setType(ownerPostDTO.getType());
        ownerPostEntity.setContactNumber(ownerPostDTO.getContactNumber());
        return ownerPostEntity;
    }
}
