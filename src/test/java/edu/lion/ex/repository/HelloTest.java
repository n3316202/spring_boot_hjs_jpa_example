package edu.lion.ex.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.lion.ex.entity.Hello;
import edu.lion.ex.entity.Member;
import edu.lion.ex.entity.QHello;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
@Transactional
class HelloTest {

    @PersistenceContext
    private  EntityManager em;

    @Test
    @DisplayName("헬로우 쿼리 테스트")
    void HelloQuerydslTest() {

        Hello hello = new Hello("TEST");

        em.persist(hello);

        em.flush();
        em.clear();

        QHello h = new QHello("m"); // variable -> 별칭
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        Hello data = queryFactory
                .selectFrom(h)
                .fetchOne();

        assertThat(data.getName()).isEqualTo("TEST");
    }

    @Test
    @Transactional
    @DisplayName("멤버 저장 테스트")
    void MemberSaveTest() {

        Member member = new Member();

        member.setUsername("홍길동");
        em.persist(member);

        em.flush();
        //em.clear();

        Member findMember =  em.find(Member.class, member.getId());

        System.out.println( findMember.getId() + "==========" + findMember.getUsername());

        if(findMember  == member){
            System.out.println("야 ~ 두 주소가 같다. 이것을 보고 동일성 보장 이다.");
        }
    }

    @Test
    @DisplayName("멤버 저장된거 불러오기")
    void MemberGetTest() {
        Member member =  em.find(Member.class,2L);

        System.out.println(member.getUsername());

    }


    @Transactional
    @Test
    @DisplayName("멤버 업데이트 테스트")
    void MemberUpdateTest() {
        Member member = new Member();
        member.setUsername("홍길동");
        em.persist(member);
        em.flush();
    }




}