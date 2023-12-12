package com.ratingservices.services.implementation;



import com.ratingservices.dto.RatingDto;
import com.ratingservices.entity.Rating;
import com.ratingservices.repository.RatingRepository;
import com.ratingservices.services.RatingService;
import com.ratingservices.singleproductmgmtservicedata.SingleProductMgmtServiceData;
import com.ratingservices.usermgmtservicedata.SingleUserManagementServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class RatingServiceImplementation implements RatingService {

    private final SingleUserManagementServiceData singleUserManagementServiceData;
    private final SingleProductMgmtServiceData singleProductMgmtServiceData;
    private final RatingRepository ratingRepository;
    @Override
    public Rating Create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> GetAll() {
        return ratingRepository.findAll();
    }

    @Override
    public RatingDto GetById(Long id) {
        Rating r = ratingRepository.findById(id).orElse(null);
        if (r==null){
            return null;
        }

        RatingDto.RatingDtoBuilder dto = RatingDto.builder();

        dto.productName(singleProductMgmtServiceData.getSingleProductById(r.getProductId()));
        dto.userName1(singleUserManagementServiceData.getSingleUserById(r.getUserId()));
        dto.rating(r.getRating());
        dto.description(r.getFeedback());
        return dto
                .build();

    }

    @Override
    public Rating GetRatingByUserId(Long userId) {
        return ratingRepository.findById(userId).orElse(null);
    }

    @Override
    public Rating GetAllRatingByProduct(Long productId) {
        return ratingRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }




}
