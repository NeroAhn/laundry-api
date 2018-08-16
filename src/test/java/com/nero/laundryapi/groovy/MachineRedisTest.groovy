package com.nero.laundryapi.groovy

import com.nero.laundryapi.service.RedisMessagePublisher
import com.nero.laundryapi.service.RedisMessageSubscriber
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

    @Autowired
    RedisMessagePublisher redisMessagePublisher

    @Autowired
    RedisMessageSubscriber redisMessageSubscriber

    def "Redis 등록/조회 테스트"() {
        given:
        def key = "key:springboot"
        def value = "hello"

        when:
        redisService.set(key, value)

        then:
        value == redisService.get(key)
    }

    def "Redis message publish 테스트"() {
        given:
        def message = "message publish test " + UUID.randomUUID()

        when:
        redisMessagePublisher.publish(message)

        then:
        redisMessageSubscriber.messageList.get(0).contains(message)
    }
}
