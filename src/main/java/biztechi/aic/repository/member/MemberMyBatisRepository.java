package biztechi.aic.repository.member;

import biztechi.aic.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberMyBatisRepository implements MemberRepository{

    private final MemberMapper mapper;

    @Override
    public void save(Member member) {
        mapper.save(member);
    }

    @Override
    public Optional<Long> findNextId() {
        return mapper.findNextId();
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return mapper.findByUsername(username);
    }
}
