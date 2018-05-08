package hg;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Andreea on 06.05.2018.
 */
public interface PropertyRepository extends JpaRepository <Property, Long> {
    List<Property> findPropertyByPriceAndLvlAndPropTypeAndConstructionYear(double price, int lvl, String PropType, int constructionYear);
    List<Property> findPropertyByUserId(Long id);
}
