package umc.study.apiPayload.code;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDto{
        @NotBlank
        String title;
        Float score;
        Long member;
        Long store;

    }
}
