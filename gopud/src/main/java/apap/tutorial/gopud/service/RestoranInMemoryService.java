package apap.tutorial.gopud.service;
import java.text.BreakIterator;
import java.util.*;

import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

@Service
public class RestoranInMemoryService implements RestoranService {
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


    @Override
    public void deleteRestoran(Long idRestoran) {
        // TODO Auto-generated method stub

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

}

