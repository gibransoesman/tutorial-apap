package apap.tutorial.gopud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
    private String addMenuFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        MenuModel menu = new MenuModel();
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        ArrayList<MenuModel> listMenu = new ArrayList<>();
        listMenu.add(menu);
        restoran.setListMenu(listMenu);

        menu.setRestoran(restoran);
        model.addAttribute("resto", restoran);
        model.addAttribute("listMenu", menu);
        model.addAttribute("title", "Tambah Menu");
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@ModelAttribute RestoranModel restoran, BindingResult bindingResult, Model model) {
        if (restoran.getListMenu() == null){
            restoran.setListMenu(new ArrayList<MenuModel>());
        }

        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("resto", restoran);
        model.addAttribute("title", "Tambah Menu");
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"deleteRow"})
    private String deleteRow(@ModelAttribute RestoranModel restoran, BindingResult bindingResult, Model model, HttpServletRequest req) {
        Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
        restoran.getListMenu().remove(rowId.intValue()); 
        model.addAttribute("resto", restoran);
        model.addAttribute("title", "Tambah Menu");
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"submit"})
    private String sumbitMenu(@ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel resto = restoranService.getRestoranByIdRestoran(restoran.getIdRestoran()).get();
        for (MenuModel menu : restoran.getListMenu()){
            menu.setRestoran(resto);
            menuService.addMenu(menu);
        }
        model.addAttribute("title", "Tambah Menu");
        return "add-menu";
    }

    // @RequestMapping(value = "menu/add", method = RequestMethod.POST)
    // private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
    //     menuService.addMenu(menu);
    //     model.addAttribute("nama", menu.getNama());
    //     return "add-menu";
    // }
    
    @RequestMapping(value = "/menu/change/{idMenu}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long idRestoran, Optional<Long> idMenu, Model model) {;
        if (idMenu.isPresent()) {

            model.addAttribute("id", idMenu.get());
            Optional<MenuModel> existingMenuOptional = menuService.findMenuById(idMenu.get());
            if (existingMenuOptional.isPresent()) {
                MenuModel existingMenu = existingMenuOptional.get();
                model.addAttribute("menu", existingMenu);
            }
        }
        model.addAttribute("title", "Ubah Menu");
        return "form-change-menu";
    }

    @RequestMapping( value = "/menu/change/{idMenu}", method = RequestMethod.POST)
    public String changeMenuFormSumbit (@PathVariable Long idRestoran, Long idMenu, @ModelAttribute MenuModel menu, Model model){
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenuData);
        model.addAttribute("title", "Ubah Menu");
        return "change-menu";
    }

    @RequestMapping(value= "/menu/delete", method=RequestMethod.POST)
    public String delete(@ModelAttribute RestoranModel restoran, Model model){
        for (MenuModel menu : restoran.getListMenu()){
            menuService.deleteMenu(menu.getId());
        }
        model.addAttribute("title", "Delete Menu");
        return "delete-menu";
}
}
