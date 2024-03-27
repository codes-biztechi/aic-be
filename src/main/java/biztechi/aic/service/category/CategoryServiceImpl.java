package biztechi.aic.service.category;

import biztechi.aic.model.response.CategoryDto;
import biztechi.aic.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository dao;

    @Override
    public List<CategoryDto> getCategories() {
        return dao.findCategoriesByUsage(true).stream().map(category -> new CategoryDto(category.getCode(), category.getLabel())).toList();
    }
}
