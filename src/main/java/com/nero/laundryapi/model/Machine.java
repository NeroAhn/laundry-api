package com.nero.laundryapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("machine")
public class Machine {
    @Id
    private Long id;
    // 세탁기 상태
    private MachineStatus machineStatus;
    // 남은 시간
    private Integer remainingTime;

}
