package kr.bluenyang.practice.springbootsecure.car.repository;

import kr.bluenyang.practice.springbootseure.car.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}