package biztechi.aic.service.category;

import biztechi.aic.model.response.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories();
}
