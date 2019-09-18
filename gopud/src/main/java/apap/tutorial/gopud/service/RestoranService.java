package apap.tutorial.gopud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranService {
    void addRestoran(RestoranModel restoran);
    List<RestoranModel> getRestoranList();
    RestoranModel getRestoranByIdRestoran(String idRestoran);
}