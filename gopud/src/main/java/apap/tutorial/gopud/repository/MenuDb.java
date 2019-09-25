package apap.tutorial.gopud.repository;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import apap.tutorial.gopud.model.MenuModel;

@Repository
public interface MenuDb extends JpaRepository<MenuModel, Long>{
    List<MenuModel> findByRestoranIdRestoran(Long restoranId);
}