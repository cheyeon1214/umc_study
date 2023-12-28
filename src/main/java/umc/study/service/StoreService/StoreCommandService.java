package umc.study.service.StoreService;

import umc.study.apiPayload.code.StoreRequestDTO;
import umc.study.domain.Member;
import umc.study.domain.Store;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.JoinDto request);
}
