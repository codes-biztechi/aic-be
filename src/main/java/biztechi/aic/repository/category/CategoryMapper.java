package biztechi.aic.repository.category;

import biztechi.aic.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> findCategoriesByUsage(@Param("usage") boolean usage);
}
