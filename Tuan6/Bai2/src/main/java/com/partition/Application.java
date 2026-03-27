package com.partition;

import com.partition.entity.*;
import com.partition.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserMaleRepository userMaleRepo,
                          UserFemaleRepository userFemaleRepo,
                          UserProfileRepository profileRepo,
                          UserDetailRepository detailRepo,
                          UserActiveRepository activeRepo,
                          UserInactiveRepository inactiveRepo,
                          UserSuspendedRepository suspendedRepo) {
        return args -> {
            // Horizontal Partitioning Data
            userMaleRepo.save(new UserMale("Nguyễn Văn A", "a@example.com"));
            userMaleRepo.save(new UserMale("Trần Văn B", "b@example.com"));
            userMaleRepo.save(new UserMale("Phạm Văn C", "c@example.com"));

            userFemaleRepo.save(new UserFemale("Hoàng Thị D", "d@example.com"));
            userFemaleRepo.save(new UserFemale("Lê Thị E", "e@example.com"));
            userFemaleRepo.save(new UserFemale("Võ Thị F", "f@example.com"));

            // Vertical Partitioning Data
            UserProfile p1 = profileRepo.save(new UserProfile("Nguyễn A", "a@example.com"));
            UserProfile p2 = profileRepo.save(new UserProfile("Hoàng B", "b@example.com"));
            UserProfile p3 = profileRepo.save(new UserProfile("Trần C", "c@example.com"));

            detailRepo.save(new UserDetail(p1.getId(), "0981234567", "123 Nguyễn Huệ, HN"));
            detailRepo.save(new UserDetail(p2.getId(), "0982345678", "456 Lê Lợi, HCMC"));
            detailRepo.save(new UserDetail(p3.getId(), "0983456789", "789 Võ Văn Kiệt, DN"));

            // Function-based Partitioning Data
            activeRepo.save(new UserActive("User A", "2026-03-27"));
            activeRepo.save(new UserActive("User B", "2026-03-26"));

            inactiveRepo.save(new UserInactive("User C", "2026-02-01"));

            suspendedRepo.save(new UserSuspended("User D", "2026-01-15"));

            System.out.println("\n✅ Database Partitioning Demo - Sample data loaded!");
        };
    }
}
