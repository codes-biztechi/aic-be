package biztechi.aic.service.member;

import biztechi.aic.domain.Member;
import biztechi.aic.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not a valid user"));
    }

    @Override
    public Long save(Member member) {
        Optional<Long> foundId = dao.findNextId();
        Long memberId = foundId.orElse(0L);
        member.setId(memberId);
        dao.save(member);
        return member.getId();
    }
}
