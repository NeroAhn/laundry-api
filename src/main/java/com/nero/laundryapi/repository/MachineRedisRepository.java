package com.nero.laundryapi.repository;

import com.nero.laundryapi.model.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRedisRepository extends CrudRepository<Machine, Long> {
}
