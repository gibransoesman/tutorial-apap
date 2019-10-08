package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranService{
        void addRestoran(RestoranModel restoran);
        List<RestoranModel> getRestoranList();
        RestoranModel getRestoranByIdRestoran(Long idRestoran);
        RestoranModel changeRestoran(RestoranModel restoranModel);
        void deleteRestoran(Long idRestoran);
        
}
// public interface RestoranService {
//     void addRestoran(RestoranModel restoran);
//     List<RestoranModel> getRestoranList();
//     RestoranModel getRestoranByIdRestoran(String idRestoran);
//     RestoranModel getRestoranByIdNama(String nama);
//     RestoranModel deleteRestoranByIdRestoran(String idRestoran);
//     RestoranModel updateRestoranNomorTelepon(String idRestoran, Integer nomorTelepon);

// }