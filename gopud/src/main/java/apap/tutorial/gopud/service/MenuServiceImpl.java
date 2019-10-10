package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public MenuModel findMenuById(Long idMenu) {
        Optional<MenuModel> menu = menuDb.findById(idMenu);
        return menu.get();
    }

    @Override
    public MenuModel changeMenu(MenuModel menu) {
        MenuModel targetMenu = findMenuById(menu.getId());
        targetMenu.setNama(menu.getNama());
        targetMenu.setHarga(menu.getHarga());
        targetMenu.setDurasiMasak(menu.getDurasiMasak());
        targetMenu.setDeskripsi(menu.getDeskripsi());
        menuDb.save(targetMenu);
        return targetMenu;
    }

    @Override
    public void deleteMenu(MenuModel menu) {
        menuDb.delete(menu);

    }
}