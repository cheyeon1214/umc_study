package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.ReviewRequestDTO;
import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review review(ReviewRequestDTO.ReviewDto request) {

        Review newReview = ReviewConverter.toReview(request, memberRepository, storeRepository);

        return reviewRepository.save(newReview);
    }
}
