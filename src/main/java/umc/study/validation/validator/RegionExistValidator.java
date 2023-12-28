package umc.study.validation.validator;

import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.RegionRepository;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class RegionExistValidator implements ConstraintValidator<ExistRegion, Integer> {

    private final RegionRepository regionRepository;

    public RegionExistValidator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = regionRepository.existsById(Long.valueOf(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
