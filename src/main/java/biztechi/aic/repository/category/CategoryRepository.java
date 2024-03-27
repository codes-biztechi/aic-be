package biztechi.aic.repository.category;

import biztechi.aic.domain.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> findCategoriesByUsage(boolean usage);
}
