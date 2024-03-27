package biztechi.aic.repository.member;

import biztechi.aic.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Optional<Long> findNextId();

    Optional<Member> findByUsername(@Param("username") String username);
}
