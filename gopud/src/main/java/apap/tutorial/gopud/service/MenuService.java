package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;

public interface MenuService {
    void addMenu(MenuModel menu);
    
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);

    MenuModel findMenuById(Long idMenu);

    MenuModel changeMenu(MenuModel restoran);

    void deleteMenu(MenuModel menu);
}