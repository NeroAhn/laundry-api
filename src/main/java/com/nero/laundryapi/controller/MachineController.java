package com.nero.laundryapi.controller;

import com.nero.laundryapi.model.Machine;
import com.nero.laundryapi.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Api(value = "machine")
@Slf4j
public class MachineController {

    private final RedisService redisService;

    @Autowired
    public MachineController(RedisService redisService) {
        this.redisService = redisService;
    }

    @ApiOperation(value = "machine 상태 변경")
    @PutMapping(value = "/machines/{machineId}")
    public void setMachine(@PathVariable Long machineId, @Valid @RequestBody Machine machine) {
        machine.setId(machineId);
        log.info("machine : " + machine);
        redisService.publish(machine);
    }
}
