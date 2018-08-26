package com.nero.laundryapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RedisHash("machine")
@ToString
public class Machine {
    @Id
    private Long id;

    // 세탁기 상태
    @NotNull
    private MachineStatus machineStatus;

    // 남은 시간
    private Integer remainingTime;

    // 물 온도
    private Integer temperature;

    @AssertTrue(message = "반드시 값이 있어야 합니다.")
    public boolean isRemainingTime() {
        if (this.machineStatus != MachineStatus.EMPTY) {
            return this.remainingTime != null;
        }

        return true;
    }

}
