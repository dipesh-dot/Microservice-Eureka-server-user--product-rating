package com.ratingservices.controller;

import com.ratingservices.dto.RatingDto;
import com.ratingservices.entity.Rating;
import com.ratingservices.repository.RatingRepository;
import com.ratingservices.services.RatingService;
import com.ratingservices.singleproductmgmtservicedata.SingleProductMgmtServiceData;
import com.ratingservices.usermgmtservicedata.SingleUserManagementServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rating-service")
public class RatingController {


    private final RatingRepository ratingRepository;
    private final SingleProductMgmtServiceData singleProductMgmtServiceData;
    private final SingleUserManagementServiceData singleUserManagementServiceData;

    private final RatingService ratingService;


    @PostMapping("/save")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.ok().body(ratingService.Create(rating));

    }


    @GetMapping("rating/{id}")
    public RatingDto getRating(@PathVariable Long id) {
        Rating r = ratingRepository.findById(id).orElse(null);

        if (r == null) {
            return null; // Handle the case when the rating with the given ID is not found
        }

        return RatingDto.builder()
                .productName(singleProductMgmtServiceData.getSingleProductById(r.getProductId()))
                .userName1(singleUserManagementServiceData.getSingleUserById(r.getUserId()))
                .rating(r.getRating())
                .description(r.getFeedback())
                .build();
    }

    @GetMapping("rating/{id}")
    public ResponseEntity<RatingDto> getRatingDetailsOfProduct(@PathVariable Long id) {


        return ResponseEntity.ok().body(ratingService.GetById(id));
    }


    @GetMapping("/get-all")
    public ResponseEntity<Rating> getAllRatings() {
        return ResponseEntity.ok().body((Rating) ratingService.GetAll());

    }


}


