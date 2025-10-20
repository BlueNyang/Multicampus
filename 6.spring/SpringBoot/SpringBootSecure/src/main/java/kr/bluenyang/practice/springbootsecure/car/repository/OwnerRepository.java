package kr.bluenyang.practice.springbootsecure.car.repository;

import kr.bluenyang.practice.springbootseure.car.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}