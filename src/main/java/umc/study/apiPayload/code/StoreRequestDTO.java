package umc.study.apiPayload.code;

import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @ExistRegion
        Integer region;
        @Size(min = 5, max = 12)
        String address;

    }
}
