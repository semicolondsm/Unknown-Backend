package com.example.unknown.entity.repository;

import com.example.unknown.entity.Redis;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<Redis, String> {
}
