package biztechi.aic.service.member;

import biztechi.aic.domain.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Long save(Member member);
}
