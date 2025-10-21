package kr.bluenyang.practice.springbootsecure;

import kr.bluenyang.practice.springbootsecure.car.domain.Car;
import kr.bluenyang.practice.springbootsecure.car.domain.Owner;
import kr.bluenyang.practice.springbootsecure.car.repository.CarRepository;
import kr.bluenyang.practice.springbootsecure.car.repository.OwnerRepository;
import kr.bluenyang.practice.springbootsecure.user.domain.AppUser;
import kr.bluenyang.practice.springbootsecure.user.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootSecureApplication implements CommandLineRunner {
    private final CarRepository repository;
    // private final OwnerRepository ownerRepo;
    // private final AppUserRepository appUserRepo;
    // private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecureApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // // Add owner objects and save these to db
        // Owner owner1 = new Owner("John", "Johnson");
        // Owner owner2 = new Owner("Mary", "Robinson");
        // ownerRepo.saveAll(Arrays.asList(owner1, owner2));
        //
        // repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
        // repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
        // repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
        //
        // appUserRepo.save(new AppUser("user", passwordEncoder.encode("password"), "USER"));

        // Fetch all cars and log to console
        for (Car car : repository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }
    }
}
