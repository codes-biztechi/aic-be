package biztechi.aic.repository.category;

import biztechi.aic.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryMyBatisRepository implements CategoryRepository {

    private final CategoryMapper mapper;

    @Override
    public List<Category> findCategoriesByUsage(boolean usage) {
        return mapper.findCategoriesByUsage(usage);
    }
}
