package umc.study.converter;

import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.apiPayload.code.StoreResponseDTO;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request, RegionRepository regionRepository) {
        Region region = regionRepository.findById(Long.valueOf(request.getRegion()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid region ID"));

        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(region)
                .build();
    }
}