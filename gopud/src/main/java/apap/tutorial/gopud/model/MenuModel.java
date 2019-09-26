package apap.tutorial.gopud.model;

import apap.tutorial.gopud.model.RestoranModel;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "menu")
public class MenuModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "nama", nullable=false)
    private String nama;

    @NotNull
    @Column(name = "harga", nullable = false)
    private BigInteger harga;

    @NotNull
    @Column(name = "durasiMasak", nullable = false)
    private Integer durasiMasak;

    @NotNull
    @Size(max = 50)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restoranId", referencedColumnName = "idRestoran", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RestoranModel restoran;


    public MenuModel() {
    }

    public MenuModel(Long id, String nama, BigInteger harga, Integer durasiMasak, String deskripsi, RestoranModel restoran) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.durasiMasak = durasiMasak;
        this.deskripsi = deskripsi;
        this.restoran = restoran;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return this.harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public Integer getDurasiMasak() {
        return this.durasiMasak;
    }

    public void setDurasiMasak(Integer durasiMasak) {
        this.durasiMasak = durasiMasak;
    }

    public String getDeskripsi() {
        return this.deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public RestoranModel getRestoran() {
        return this.restoran;
    }

    public void setRestoran(RestoranModel restoran) {
        this.restoran = restoran;
    }

    public MenuModel id(Long id) {
        this.id = id;
        return this;
    }

    public MenuModel nama(String nama) {
        this.nama = nama;
        return this;
    }

    public MenuModel harga(BigInteger harga) {
        this.harga = harga;
        return this;
    }

    public MenuModel durasiMasak(Integer durasiMasak) {
        this.durasiMasak = durasiMasak;
        return this;
    }

    public MenuModel deskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    public MenuModel restoran(RestoranModel restoran) {
        this.restoran = restoran;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuModel)) {
            return false;
        }
        MenuModel menuModel = (MenuModel) o;
        return Objects.equals(id, menuModel.id) && Objects.equals(nama, menuModel.nama) && Objects.equals(harga, menuModel.harga) && Objects.equals(durasiMasak, menuModel.durasiMasak) && Objects.equals(deskripsi, menuModel.deskripsi) && Objects.equals(restoran, menuModel.restoran);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, harga, durasiMasak, deskripsi, restoran);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nama='" + getNama() + "'" +
            ", harga='" + getHarga() + "'" +
            ", durasiMasak='" + getDurasiMasak() + "'" +
            ", deskripsi='" + getDeskripsi() + "'" +
            ", restoran='" + getRestoran() + "'" +
            "}";
    }



}
