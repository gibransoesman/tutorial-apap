package apap.tutorial.gopud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Indexed;

@Entity
@Table(name="restoran")
public class RestoranModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestoran;

    @NotNull
    @Size(max=20)
    @Column(name="nama", nullable=false)
    private String nama;

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable=false)
    private String alamat;    

    @NotNull
    @Column(name="nomorTelepon", nullable=false)
    private Integer nomorTelepon;

    @NotNull
    @Column(name="rating", nullable=false)
    private Integer rating = 0;

    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MenuModel> listMenu;


    public RestoranModel() {
    }

    public RestoranModel(Long idRestoran, String nama, String alamat, Integer nomorTelepon, Integer rating, List<MenuModel> listMenu) {
        this.idRestoran = idRestoran;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.rating = rating;
        this.listMenu = listMenu;
    }

    public Long getIdRestoran() {
        return this.idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return this.nomorTelepon;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<MenuModel> getListMenu() {
        return this.listMenu;
    }

    public void setListMenu(List<MenuModel> listMenu) {
        this.listMenu = listMenu;
    }

    public RestoranModel idRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
        return this;
    }

    public RestoranModel nama(String nama) {
        this.nama = nama;
        return this;
    }

    public RestoranModel alamat(String alamat) {
        this.alamat = alamat;
        return this;
    }

    public RestoranModel nomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
        return this;
    }

    public RestoranModel rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public RestoranModel listMenu(List<MenuModel> listMenu) {
        this.listMenu = listMenu;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idRestoran='" + getIdRestoran() + "'" +
            ", nama='" + getNama() + "'" +
            ", alamat='" + getAlamat() + "'" +
            ", nomorTelepon='" + getNomorTelepon() + "'" +
            ", rating='" + getRating() + "'" +
            ", listMenu='" + getListMenu() + "'" +
            "}";
    }
}

// public class RestoranModel {
//     private String idRestoran;
//     private String nama;
//     private String alamat;
//     private Integer nomorTelepon;
// 	public Object getIdRestoran;

//     public RestoranModel(String idRestoran, String nama, String alamat, Integer nomorTelepon) {
//         this.idRestoran = idRestoran;
//         this.nama = nama;
//         this.alamat = alamat;
//         this.nomorTelepon = nomorTelepon;
//     }

//     public String getIdRestoran() {
//         return this.idRestoran;
//     }

//     public void setIdRestoran(String idRestoran) {
//         this.idRestoran = idRestoran;
//     }

//     public String getNama() {
//         return this.nama;
//     }

//     public void setNama(String nama) {
//         this.nama = nama;
//     }

//     public String getAlamat() {
//         return this.alamat;
//     }

//     public void setAlamat(String alamat) {
//         this.alamat = alamat;
//     }

//     public Integer getNomorTelepon() {
//         return this.nomorTelepon;
//     }

//     public void setNomorTelepon(Integer nomorTelepon) {
//         this.nomorTelepon = nomorTelepon;
//     }

//     public RestoranModel idRestoran(String idRestoran) {
//         this.idRestoran = idRestoran;
//         return this;
//     }

//     public RestoranModel nama(String nama) {
//         this.nama = nama;
//         return this;
//     }

//     public RestoranModel alamat(String alamat) {
//         this.alamat = alamat;
//         return this;
//     }

//     public RestoranModel nomorTelepon(Integer nomorTelepon) {
//         this.nomorTelepon = nomorTelepon;
//         return this;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (o == this)
//             return true;
//         if (!(o instanceof RestoranModel)) {
//             return false;
//         }
//         RestoranModel restoranModel = (RestoranModel) o;
//         return Objects.equals(idRestoran, restoranModel.idRestoran) && Objects.equals(nama, restoranModel.nama) && Objects.equals(alamat, restoranModel.alamat) && Objects.equals(nomorTelepon, restoranModel.nomorTelepon);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(idRestoran, nama, alamat, nomorTelepon);
//     }

//     @Override
//     public String toString() {
//         return "{" +
//             " idRestoran='" + getIdRestoran() + "'" +
//             ", nama='" + getNama() + "'" +
//             ", alamat='" + getAlamat() + "'" +
//             ", nomorTelepon='" + getNomorTelepon() + "'" +
//             "}";
//     }
// }
