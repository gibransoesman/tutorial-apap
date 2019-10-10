package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);
    
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);

    Optional<MenuModel> findMenuById(Long idMenu);

    MenuModel changeMenu(MenuModel restoran);

    long deleteMenu(Long idMenu);

    List<MenuModel> getListMenuOrderByHargaAsc(long idRestoran);
}