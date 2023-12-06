package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    // 싱글톤으로 설계했기 때문에 new로 인스턴스 선언하면 안되고 get으로 가져와야함
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void save() {
        //given
        Member member = new Member("park", 30);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member foundMember = memberRepository.findById(savedMember.getId());
        assertThat(foundMember).isEqualTo(savedMember);
    }
    @Test
    void findAll() {
        //given
        Member mem1 = new Member("mem1", 30);
        Member mem2 = new Member("mem2", 30);

        memberRepository.save(mem1);
        memberRepository.save(mem2);
        //when
        List<Member> all = memberRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(mem1, mem2);
    }
}