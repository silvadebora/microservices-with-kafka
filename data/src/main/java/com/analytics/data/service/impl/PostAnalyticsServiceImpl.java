package com.analytics.data.service.impl;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarModelPriceRepository;
import com.analytics.data.service.PostAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {


    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
    }

    private void saveBrandAnalytics(String brand){
        BrandAnalyticsEntity brandAnalytics = new BrandAnalyticsEntity();
        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item ->
        {
            item.setPosts(item.getPosts() + 1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            brandAnalytics.setBrand(brand);
            brandAnalytics.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalytics);
                }
        );
    }

    private void saveCarModelAnalytics(String carModel){
        CarModelAnalyticsEntity carModelAnalytics = new CarModelAnalyticsEntity();
        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item ->
        {
            item.setPosts(item.getPosts() + 1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            carModelAnalytics.setModel(carModel);
            carModelAnalytics.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalytics);
                }
        );
    }

    private void saveCarModelPriceAnalytics(String carModel, Double price){
        CarModelPriceEntity carModelPrice = new CarModelPriceEntity();
        carModelPrice.setModel(carModel);
        carModelPrice.setPrice(price);
        carModelPriceRepository.save(carModelPrice);
    }
}
