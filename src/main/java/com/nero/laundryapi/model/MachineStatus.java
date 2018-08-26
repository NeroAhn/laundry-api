package com.nero.laundryapi.model;

import lombok.Getter;

@Getter
public enum MachineStatus {
    EMPTY,          // 빈상태
    LAUNDRY,        // 세탁
    RINSING,        // 헹굼
    DEHYDRATION,    // 탈수
    COMPLETE        // 완료
}
