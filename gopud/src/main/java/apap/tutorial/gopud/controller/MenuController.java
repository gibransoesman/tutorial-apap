package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        MenuModel menu = new MenuModel();
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        menu.setRestoran(restoran);
        model.addAttribute("menu", menu);
        return "form-add-menu";
    }

    @RequestMapping(value = "menu/add", method = RequestMethod.POST)
    private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
        menuService.addMenu(menu);
        model.addAttribute("nama", menu.getNama());
        return "add-menu";
    }

    @RequestMapping(value = "/menu/change/{idRestoran}/{id}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long idRestoran, Long id, Model model) {;
        List<MenuModel> existingMenu = menuService.findAllMenuByIdRestoran(idRestoran);
        model.addAttribute("menu", existingMenu);
        return "form-change-menu";
    }

    @RequestMapping( value = "/menu/change/{idRestoran}/{id}", method = RequestMethod.POST)
    public String changeMenuFormSumbit (@PathVariable Long idRestoran, Long id, @ModelAttribute MenuModel menu, Model model){
        MenuModel newMenuData = menuService.changeMenu(menu);
        newMenuData.setId(idRestoran);
        model.addAttribute("menu", newMenuData);
        return "change-menu";
    }

    @RequestMapping("/menu/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model){
        MenuModel menu = menuService.deleteMenuById(id);
        model.addAttribute("menu", menu);
        return "delete-menu";
}
}