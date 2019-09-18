package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;

    @RequestMapping("/restoran/add")
    public String add(
        @RequestParam(value = "idRestoran", required = true) String idRestoran,
        @RequestParam(value = "nama", required = true) String nama,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
        Model model) {
            System.out.println("hehe");
            RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);
            restoranService.addRestoran(restoran);
            model.addAttribute("namaResto", nama);
            return "add-restoran";
        }

@RequestMapping("/restoran/view")
public String view(@RequestParam(value = "idRestoran") String idRestoran, Model model){
    RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
    model.addAttribute("resto", restoran);
    return "view-restoran";
}

@RequestMapping("/restoran/viewall")
public String viewall (Model model){
    List<RestoranModel> listRestoran = restoranService.getRestoranList();
    model.addAttribute("restoList", listRestoran);
    return "viewall-restoran";
}

}