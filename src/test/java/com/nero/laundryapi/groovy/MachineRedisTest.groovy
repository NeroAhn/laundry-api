package com.nero.laundryapi.groovy

import com.nero.laundryapi.model.Machine
import com.nero.laundryapi.model.MachineStatus
import com.nero.laundryapi.repository.MachineRedisRepository
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class MachineRedisTest extends Specification {

    @Autowired
    private MachineRedisRepository machineRedisRepository

    def "Redis 등록/조회 테스트"() {
//        given:
//        def id = 1L
//        Machine machine = new Machine()
//        machine.setId(id)
//        machine.setMachineStatus(MachineStatus.LAUNDRY)
//        machine.setRemainingTime(60000)
//
//        when:
//        machineRedisRepository.save(machine)
//
//        then:
//        Machine savedMachine = machineRedisRepository.findById(id).get()
//        savedMachine.getMachineStatus == MachineStatus.LAUNDRY
//        savedMachine.getRemainingTime == 60000
    }
}
