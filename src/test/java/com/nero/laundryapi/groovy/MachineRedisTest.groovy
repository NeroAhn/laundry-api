package com.nero.laundryapi.groovy

import com.nero.laundryapi.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
class MachineRedisTest extends Specification {

    @Autowired
    RedisService redisService


    def "Redis 등록/조회 테스트"() {
        given:
        def key = "key:springboot"
        def value = "hello"

        when:
        redisService.set(key, value)

        then:
        value == redisService.get(key)
    }
}
