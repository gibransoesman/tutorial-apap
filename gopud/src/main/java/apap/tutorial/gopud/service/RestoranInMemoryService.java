package apap.tutorial.gopud.service;
import java.text.BreakIterator;
import java.util.*;

import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.RestoranModel;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }
    @Override
    public void addRestoran(RestoranModel restoran){
        listRestoran.add(restoran);
    }
    @Override
    public List<RestoranModel> getRestoranList(){
        return listRestoran;
    }

    @Override
    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        for (RestoranModel count:listRestoran){
            if (count.getIdRestoran().equals(idRestoran)){
                return count;
            }
        }
        return null;
    }

    @Override
    public RestoranModel getRestoranByIdNama(String nama) {
        for (RestoranModel count:listRestoran){
            if (count.getNama().equals(nama)){
                return count;
            }
        }
        return null;
    }

    @Override
    public RestoranModel updateRestoranNomorTelepon(String idRestoran, Integer nomorTelepon) {
        for (RestoranModel count:listRestoran){
            if (count.getIdRestoran().equals(idRestoran)){
                count.setNomorTelepon(nomorTelepon);
                return count;
            }
        }
        return null;
    }

    @Override
    public RestoranModel deleteRestoranByIdRestoran(String idRestoran) {
        for (RestoranModel count:listRestoran){
            if (count.getIdRestoran().equals(idRestoran)){
                listRestoran.remove(count);
                return count;
            }
        }
        return null;
    }
}
