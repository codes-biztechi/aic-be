package biztechi.aic.repository.member;

import biztechi.aic.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Long> findNextId();

    Optional<Member> findByUsername(String username);
}
