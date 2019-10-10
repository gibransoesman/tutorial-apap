package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;

import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranService{
        void addRestoran(RestoranModel restoran);
        List<RestoranModel> getRestoranList();
        Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran);
        RestoranModel changeRestoran(RestoranModel restoranModel);
        Long deleteRestoran(Long idRestoran);
        
}