package apap.tutorial.gopud.model;
import java.util.Objects;

public class RestoranModel {
    private String idRestoran;
    private String nama;
    private String alamat;
    private Integer nomorTelepon;
	public Object getIdRestoran;

    public RestoranModel() {
    }

    public RestoranModel(String idRestoran, String nama, String alamat, Integer nomorTelepon) {
        this.idRestoran = idRestoran;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdRestoran() {
        return this.idRestoran;
    }

    public void setIdRestoran(String idRestoran) {
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

    public RestoranModel idRestoran(String idRestoran) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RestoranModel)) {
            return false;
        }
        RestoranModel restoranModel = (RestoranModel) o;
        return Objects.equals(idRestoran, restoranModel.idRestoran) && Objects.equals(nama, restoranModel.nama) && Objects.equals(alamat, restoranModel.alamat) && Objects.equals(nomorTelepon, restoranModel.nomorTelepon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRestoran, nama, alamat, nomorTelepon);
    }

    @Override
    public String toString() {
        return "{" +
            " idRestoran='" + getIdRestoran() + "'" +
            ", nama='" + getNama() + "'" +
            ", alamat='" + getAlamat() + "'" +
            ", nomorTelepon='" + getNomorTelepon() + "'" +
            "}";
    }
}
