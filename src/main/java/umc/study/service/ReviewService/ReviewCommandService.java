package umc.study.service.ReviewService;

import umc.study.apiPayload.code.ReviewRequestDTO;
import umc.study.domain.Review;

public interface ReviewCommandService {
    Review review(ReviewRequestDTO.ReviewDto request);
}
