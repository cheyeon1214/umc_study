package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDto request) {

        Store newStore = StoreConverter.toStore(request, regionRepository);

        return storeRepository.save(newStore);
    }
}
