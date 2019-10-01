package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu){
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);

    }

    @Override
    public List<MenuModel> getMenuById(Long id){
         //return menuDb.findById(id);
         return null;
    }

    @Override
    public MenuModel changeMenu(MenuModel menuModel) {
        // MenuModel targetMenu = (MenuModel) findAllMenuByIdRestoran(menuModel.getId());
        // try{
        //     targetMenu.setNama(menuModel.getNama());
        //     targetMenu.setHarga(menuModel.getHarga());
        //     targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
        //     targetMenu.setDeskripsi(menuModel.getDeskripsi());
        //     menuDb.save(targetMenu);
        //     return targetMenu;
        // } catch (NullPointerException nullException){
        //     return null;
        // }
        menuDb.save(menuModel);
        return null;
    }

    @Override
    public MenuModel deleteMenuById(Long id) {
        menuDb.deleteById(id);;
        return null;
    }

}