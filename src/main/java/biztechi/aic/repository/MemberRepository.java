package biztechi.aic.repository;

import biztechi.aic.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberRepository {

    Optional<Member> findByUsername(@Param("username") String username);
}
