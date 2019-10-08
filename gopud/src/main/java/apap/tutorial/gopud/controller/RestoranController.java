package apap.tutorial.gopud.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;
import apap.tutorial.gopud.service.MenuService;

@Controller
public class RestoranController{
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String home(Model model) { 
        model.addAttribute("title", "Home");
        return "home"; 
    }

    @RequestMapping( value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage (Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        model.addAttribute("title", "Tambah Restoran");
        return "form-add-restoran";
    }
    @RequestMapping( value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit (@ModelAttribute RestoranModel restoran,Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        model.addAttribute("title", "Tambah Restoran");
        return "add-restoran";
    }
    @RequestMapping( path = "/restoran/view", method = RequestMethod.GET)
    public String view (@RequestParam(value = "idRestoran") Long idRestoran, Model model){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        restoran.setListMenu(menuList);
        model.addAttribute("resto", restoran);
        model.addAttribute("title", "Daftar Restoran");
        return "view-restoran";
    }

    @RequestMapping( value = "/restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage (@PathVariable Long idRestoran, Model model){
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran);
        model.addAttribute("restoran", existingRestoran);
        model.addAttribute("title", "Ubah Restoran");
        return "form-change-restoran";
    }

    @RequestMapping( value = "/restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSumbit (@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model){
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        model.addAttribute("title", "Ubah Restoran");
        return "change-restoran";
    }
    @RequestMapping("/restoran/view-all")
    public String viewall (Model model){
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        model.addAttribute("restoList", listRestoran);
        model.addAttribute("title", "Liat Semua Restoran");
        return "viewall-restoran";
    }

    
    @RequestMapping("/restoran/delete/{idRestoran}")
    public String delete(@PathVariable(value = "idRestoran") Long idRestoran, Model model){
        restoranService.deleteRestoran(idRestoran);
        model.addAttribute("title", "Delete  Restoran");
        return "delete-restoran";
}

}

// @Controller
// public class RestoranController {
//     @Autowired
//     private RestoranService restoranService;

//     @RequestMapping("/restoran/add")
//     public String add(
//         @RequestParam(value = "idRestoran", required = true) String idRestoran,
//         @RequestParam(value = "nama", required = true) String nama,
//         @RequestParam(value = "alamat", required = true) String alamat,
//         @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
//         Model model) {
//             RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);
//             restoranService.addRestoran(restoran);
//             model.addAttribute("namaResto", nama);
//             return "add-restoran";
//         }
    
//     @RequestMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
//     public String update(
//         @PathVariable(value = "idRestoran", required = true) String idRestoran,
//         @PathVariable(value = "nomorTelepon", required = true) Integer nomorTelepon,
//         Model model) {
//             RestoranModel restoran = restoranService.updateRestoranNomorTelepon(idRestoran, nomorTelepon);
//             model.addAttribute("resto", restoran);
//             return "update-restoran";
//         }

// @RequestMapping("/restoran/view")
// public String view(@RequestParam(value = "idRestoran") String idRestoran, Model model){
//     RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//     model.addAttribute("resto", restoran);
//     return "view-restoran";
// }

// @RequestMapping("/restoran/view/id-restoran/{idRestoran}")
// public String viewLatihan(@PathVariable(value = "idRestoran") String idRestoran, Model model){
//     RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//     model.addAttribute("resto", restoran);
//     return "view-restoran";
// }
// }