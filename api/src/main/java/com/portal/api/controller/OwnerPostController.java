package com.portal.api.controller;

import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.impl.OwnerPostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostServiceImpl ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO){
        LOG.info("Producer CarPost information: {}", ownerPostDTO);
        ownerPostService.createOwnerCar(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
