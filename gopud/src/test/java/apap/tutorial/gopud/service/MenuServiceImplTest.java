package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();
    @InjectMocks
    RestoranService restoranService = new RestoranServiceImpl();
    @Mock
    MenuDb menuDb;
    @Mock
    RestoranDb restoranDb;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        RestoranModel newRestoran = new RestoranModel();
        newRestoran.setNama("mekdi");
        newRestoran.setAlamat("mipa");
        newRestoran.setNomorTelepon(14045);
        restoranService.addRestoran(newRestoran);
        
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("PaNas");
        newMenu.setHarga(BigInteger.ONE);
        newMenu.setDurasiMasak(3);
        newMenu.setDeskripsi("Enak");
        newMenu.setRestoran(newRestoran);
        menuService.addMenu(newMenu);
        verify(menuDb, times(1)).save(newMenu);
    }

    @Test
    public void whenGetMenuListCalledItShouldReturnAllMenuInRestoran() {
        RestoranModel resto = new RestoranModel();
        List<MenuModel> allMenu = new ArrayList<>();

        for (int loopTimes = 3; loopTimes > 0; loopTimes--){
            MenuModel newMenu = new MenuModel();
            newMenu.setRestoran(resto);
            allMenu.add(newMenu);
        }

        when (menuService.getListMenuOrderByHargaAsc(1L)).thenReturn(allMenu);

        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDb, times(1)).findByRestoranIdRestoranOrderByHarga(1L);
    }

    @Test
    public void whenGetMenyByIdCalledByExistingDataItShouldReturnCorrectData() {
        RestoranModel restoDummy = new RestoranModel();
        MenuModel returnedData = new MenuModel();
        returnedData.setNama("PaNas");
        returnedData.setDurasiMasak(1);
        returnedData.setDeskripsi("Enak");
        returnedData.setHarga(BigInteger.ONE);
        returnedData.setRestoran(restoDummy);
        returnedData.setId(1L);


        when(menuService.findMenuById(1L))
                .thenReturn(Optional.of(returnedData));
                
        Optional<MenuModel> dataFromServiceCall =
                menuService.findMenuById(1L);
        verify(menuDb, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());
        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("PaNas", dataFromOptional.getNama());
        assertEquals(Integer.valueOf(1), dataFromOptional.getDurasiMasak());
        assertEquals(BigInteger.ONE, dataFromOptional.getHarga());
        assertEquals("Enak", dataFromOptional.getDeskripsi());
        assertEquals((RestoranModel)restoDummy, dataFromOptional.getRestoran());
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        RestoranModel restoDummy = new RestoranModel();
        updatedData.setNama("PaNas");
        updatedData.setHarga(BigInteger.ONE);
        updatedData.setDurasiMasak(3);
        updatedData.setId(1L);
        updatedData.setRestoran(restoDummy);
        updatedData.setDeskripsi("Enak");

        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        
        assertEquals("PaNas", dataFromServiceCall.getNama());
        assertEquals(BigInteger.ONE, dataFromServiceCall.getHarga());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
        assertEquals(Integer.valueOf(3), dataFromServiceCall.getDurasiMasak());
        assertEquals("Enak", dataFromServiceCall.getDeskripsi());
        assertEquals((RestoranModel)restoDummy, dataFromServiceCall.getRestoran());
    }

    // @Test
    // public void whenMenuDeletedItShouldReturnNumber() {
    //     when(menuDb.deleteByIdMenu(1L)).thenReturn(Long.valueOf(1));
    //     Long delete = menuService.deleteMenu(1L);
    //     assertEquals(Long.valueOf(1), delete);
    // }

    @Test
    public void whenFindAllMenuByIdRestoranShouldRetrieveMenuList() {
        RestoranModel resto = new RestoranModel();
        resto.setIdRestoran(1L);

        List<MenuModel> allMenu = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            MenuModel newMenu = new MenuModel();
            newMenu.setRestoran(resto);
            allMenu.add(newMenu);
        }
        resto.setListMenu(allMenu);

        when(menuDb.findByRestoranIdRestoran(1L)).thenReturn(resto.getListMenu());

        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDb, times(1)).findByRestoranIdRestoran(1L);
    }
}