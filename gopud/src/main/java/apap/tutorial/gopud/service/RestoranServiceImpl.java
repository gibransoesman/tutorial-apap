package apap.tutorial.gopud.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.RestoranDb;

@Service
@Transactional
public class RestoranServiceImpl implements RestoranService{
    @Autowired
    private RestoranDb restoranDb;


    @Override
    public void addRestoran(RestoranModel restoran) { restoranDb.save(restoran);}

    @Override
    public List<RestoranModel> getRestoranList() { return restoranDb.findAll();}

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        return restoranDb.findByIdRestoran(idRestoran);
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel){
        RestoranModel targetRestoran = restoranDb.findById(restoranModel.getIdRestoran()).get();

        try{
            targetRestoran.setNama(restoranModel.getNama());
            targetRestoran.setAlamat(restoranModel.getAlamat());
            targetRestoran.setNomorTelepon(restoranModel.getNomorTelepon());
            restoranDb.save(targetRestoran);
            return targetRestoran;
        } catch (NullPointerException nullException){
            return null;
        }
    }

    @Override
    public RestoranModel deleteRestoranByIdRestoran(Long idRestoran) {
        restoranDb.deleteById(idRestoran);;
        return null;
    }
}