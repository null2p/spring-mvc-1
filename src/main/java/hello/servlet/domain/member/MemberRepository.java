package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제 때문에 실무에서는 ConcurrentHashMap, AtomicLong 사용
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        // new ArrayList를 새로 만들어서 반환하면 이 값을 조작해도 store 조작이 불가능하기 떄문
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
