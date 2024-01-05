package umc.study.converter;

import umc.study.apiPayload.code.ReviewRequestDTO;
import umc.study.apiPayload.code.ReviewResponseDTO;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDto request, MemberRepository memberRepository, StoreRepository storeRepository) {
        Member member = memberRepository.findById(Long.valueOf(request.getMember()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Member ID"));

        Store store = storeRepository.findById(Long.valueOf(request.getStore()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Store ID"));


        return Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }
}