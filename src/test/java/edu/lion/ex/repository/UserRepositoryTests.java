package edu.lion.ex.repository;

import edu.lion.ex.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Test Method 순서를 위해 추가
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void SaveTest() {
        User user = new User();
        user.setUsername("kim ori");
        userRepository.save(user);

        user = new User();
        user.setUsername("lee ori");
        userRepository.save(user);

        user = new User();
        user.setUsername("kim ental");
        userRepository.save(user);

        user = new User();
        user.setUsername("lee ental");
        userRepository.save(user);

        user = new User();
        user.setUsername("kim samuel");
        userRepository.save(user);

    }

    @Test
    @Order(2)
    void select() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다.
        List<User> userList = userRepository.findAll();
        for (User u : userList) log.info("[FindAll]: " + u.getId() + " | " + u.getUsername());
    }

    /*
        1. assertEquals(a, b): a와 b의 값이 동일한지 확인
        2. assertSame(a, b): a와 b의 객체가 동일한지 확인
        3. assertNull(a): a가 null인지 확인
        4. assertNotNull(a): a가 null이 아닌지 확인
        5. assertTrue(a): a가 true인지 확인
        6. assertFalse(a): a가 false인지 확인
    */

    @Test
    @Order(3)
    void select2() { // Like 검색으로 2개만 값을 가져오는 내가 작성한 명령을 실행해본다.
        List<User> userList = userRepository.findFirst2ByUsernameLikeOrderByIdDesc("kim%");

        for (User user : userList) {
            log.info("[FindSome]: " + user.getId() + " | " + user.getUsername());
        }
    }


}