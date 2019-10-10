package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.math.BigInteger;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();
    @Mock
    MenuDb menuDb;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("mekdi");
        // newMenu.setHarga(30000);
        newMenu.setDurasiMasak(3);
        newMenu.setDeskripsi("Enak");
        menuService.addMenu(newMenu);
        verify(menuDb, times(1)).save(newMenu);
    }

    // @Test
    // public void whenGetRestoranListCalledItShouldReturnAllRestoran() {
    //     List<RestoranModel> allRestoranInDatabase = new ArrayList<>();
    //     for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
    //     allRestoranInDatabase.add(new RestoranModel());
    //     }
    //     when (restoranService.getRestoranList()).thenReturn(allRestoranInDatabase);
    //     List<RestoranModel> dataFromServiceCall = restoranService.getRestoranList();
    //     assertEquals(3, dataFromServiceCall.size());
    //     verify(restoranDb, times(1)).findAllByOrderByNamaAsc();
    // }

    // @Test
    // public void whenGetRestoranByIdCalledByExistingDataItShouldReturnCorrectData() {
    //     MenuModel returnedData = new MenuModel();

    //     returnedData.setNama("mekdi");
    //     returnedData.setHarga(30000);
    //     returnedData.setDurasiMasak(3);
    //     returnedData.setId((long)1);
    //     returnedData.setDeskripsi("Enak");


    //     when(MenuModel.findById(1L)).thenReturn(Optional.of(returnedData));
    //     List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
    //     verify(menuDb, times(1)).findById(1L);
    //     assertTrue(dataFromServiceCall.contains(1L));
    //     MenuModel dataFromOptional = dataFromServiceCall.get(0);
    //     assertEquals("mekdi", dataFromOptional.getNama());
    //     assertEquals(Integer.valueOf(30000), dataFromOptional.getHarga());
    //     assertEquals(Integer.valueOf(3), dataFromOptional.getDurasiMasak());
    //     assertEquals(Long.valueOf(1), dataFromOptional.getId());
    //     assertEquals("Enak", dataFromOptional.getDeskripsi());
    // }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("mekdi");
        // updatedData.setHarga(3000);
        updatedData.setDurasiMasak(3);
        updatedData.setId(1L);
        updatedData.setDeskripsi("Enak");
        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        assertEquals("mekdi", dataFromServiceCall.getNama());
        assertEquals(Integer.valueOf(3000), dataFromServiceCall.getHarga());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
        assertEquals(Integer.valueOf(3), dataFromServiceCall.getDurasiMasak());
        assertEquals("Enak", dataFromServiceCall.getDeskripsi());
    }
}