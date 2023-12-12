package com.ratingservices.services;



import com.ratingservices.dto.RatingDto;
import com.ratingservices.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    public Rating Create(Rating rating);
    public List<Rating> GetAll();
 public RatingDto GetById(Long id);
    public Rating GetRatingByUserId(Long userId);
    public Rating GetAllRatingByProduct(Long productId);

    public List<Rating> getRatingsByUserId(Long userId) ;


}
