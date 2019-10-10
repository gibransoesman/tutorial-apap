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
    public Optional<MenuModel> findMenuById(Long idMenu) {
        return menuDb.findById(idMenu);
    }

    @Override
    public List<MenuModel> getListMenuOrderByHargaAsc(long idRestoran) {
        return menuDb.findByRestoranIdRestoranOrderByHarga(idRestoran);
    }

    @Override
    public MenuModel changeMenu(MenuModel menu) {
        MenuModel targetMenu = menuDb.findById(menu.getId()).get();
        targetMenu.setNama(menu.getNama());
        targetMenu.setHarga(menu.getHarga());
        targetMenu.setDurasiMasak(menu.getDurasiMasak());
        targetMenu.setDeskripsi(menu.getDeskripsi());
        menuDb.save(targetMenu);
        return targetMenu;
    }

    @Override
    public long deleteMenu(Long idMenu) {
        return menuDb.deleteByIdMenu(idMenu);
    }
}