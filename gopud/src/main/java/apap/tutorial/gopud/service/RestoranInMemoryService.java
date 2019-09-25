package apap.tutorial.gopud.service;
import java.text.BreakIterator;
import java.util.*;

import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

@Service
public class RestoranInMemoryService implements RestoranService, MenuService {
    private List<RestoranModel> listRestoran;
    private List<MenuModel> listMenu;

    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
        listMenu = new ArrayList<>();
    }

     @Override
     public void addRestoran(RestoranModel restoran) {
         listRestoran.add(restoran);
     }

     @Override
     public List<RestoranModel> getRestoranList() {
         return listRestoran;
     }

    // @Override
    // public RestoranModel getRestoranByIdRestoran(String idRestoran) {
    //     for (RestoranModel count : listRestoran) {
    //         if (count.getIdRestoran().equals(idRestoran)) {
    //             return count;
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public RestoranModel getRestoranByIdNama(String nama) {
    //     for (RestoranModel count : listRestoran) {
    //         if (count.getNama().equals(nama)) {
    //             return count;
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public RestoranModel updateRestoranNomorTelepon(String idRestoran, Integer nomorTelepon) {
    //     for (RestoranModel count : listRestoran) {
    //         if (count.getIdRestoran().equals(idRestoran)) {
    //             count.setNomorTelepon(nomorTelepon);
    //             return count;
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public RestoranModel deleteRestoranByIdRestoran(String idRestoran) {
    //     for (RestoranModel count : listRestoran) {
    //         if (count.getIdRestoran().equals(idRestoran)) {
    //             listRestoran.remove(count);
    //             return count;
    //         }
    //     }
    //     return null;
    // }

    @Override
    public void addMenu(MenuModel menu) {
        listMenu.add(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(long idRestoran) {
        for (RestoranModel count : listRestoran){
            if (count.getIdRestoran().equals(idRestoran)){
                return count.getListMenu();
            }
        }
        return null;
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        // nanti bikin
        return null;
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        // TODO Auto-generated method stub
        return null;
    }
}

