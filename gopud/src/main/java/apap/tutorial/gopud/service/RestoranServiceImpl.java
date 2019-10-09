package apap.tutorial.gopud.service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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
    public List<RestoranModel> getRestoranList() { return restoranDb.findAllByOrderByNamaAsc();}

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        try{
            Optional<RestoranModel> restoran = restoranDb.findByIdRestoran(idRestoran);
            return restoranDb.findByIdRestoran(idRestoran);
        }catch (NoSuchElementException e) {
            throw e;
        }
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel){
        try{
            RestoranModel targetRestoran = restoranDb.findById(restoranModel.getIdRestoran()).get();
            targetRestoran.setNama(restoranModel.getNama());
            targetRestoran.setAlamat(restoranModel.getAlamat());
            targetRestoran.setNomorTelepon(restoranModel.getNomorTelepon());
            restoranDb.save(targetRestoran);
            return targetRestoran;
        } catch (NullPointerException nullException) {
            throw nullException;
        }
    }

    @Override
    public void deleteRestoran(Long idRestoran) {
        RestoranModel restoran = getRestoranByIdRestoran(idRestoran).get();
        if(restoran.getListMenu().size()==0){
            restoranDb.delete(restoran);
        }else{
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
}