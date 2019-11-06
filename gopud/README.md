# Tutorial APAP 2
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*

Pertanyaan 1
    Keluar error karena controller akan mengeluarkan restoran add, tetapi file html nya belum dibuat sehingga tidak keluar

Pertanyaan 2
    Keluar error dikarenakan fungsi add restoran meminta id, nama, alamat, dan nomor telepon. pada link tersebut tidak ada nomor telepon.

pertanyaan 3
    jika kita telah menyimpan PanyuFC, maka kita akan mengakses dengan ID
    localhost:8080/restoran/view?idRestoran=1

pertanyaan 4
    yang akan ditampilkan adalah semua restoran yang terdaftar.

    ![SS dari viewall](https://ibb.co/dJdtNnJ)


# Tutorial APAP 3
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*

Pertanyaan 1
untuk menemukan restoran berdasarkan id restoran tersebut

Pertanyaan 2
restoran form page akan mengeluarkan form dan restoransubmit akan keluar ketika input berhasil disimpan di db.

pertanyaan 3
untuk bisa link dengan db

pertanyaan 4
di bagian OneToMany pada restoranmodel dan menumodel

pertanyaan 5
untuk menjelaskan type db dan foreign key dapa menumodel

# Tutorial APAP 4
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*

Pertanyaan 1
Yang dilakukan pada soal nomor 2 adalah mengubah text dengan cara dinamis. cara saya menyelesaikan tugasnya adalah dengan membuat th:text pada tag yang ingin dinamis, lalu membuat addAtribute di setiap class controller yang mereturn halaman.

Pertanyaan 2
Yang dilakukan pada soal nomor 2 adalah membuat table dinamis. cara saya menyelesaikan tugasnya adalah membuat class dicontroller untuk membuat fungsi addRow, deleteRow dan sumbit dan juga mengubah pada class addmenu dengan membuat arrayList, nantinya yang akan disimpan setiap diinput ada pada arrayList. Lalu membuat tampilan html seperti tutorial, tetapi sedikit berbeda karena menggunakan form.

Pertanyaan 3
include akan memasukkan kedalam tag, kalau replace mengganti tag

Pertanyaan 4
Mendeklarasi objek untuk form data


# Tutorial APAP 5
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*

- Untuk screenshot dari latihan nomor 1 yaitu coverage dari view sebelum dibuat test dan sesudah terlampir di folder img yang sejajar dengan file README.md

1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and
then.
 Pada bagian given, sebuah instance dari object yang akan ditest operationnya akan dibuat. Simplenya, given adalah initial context yang berada pada awal skenario. When adalah dimana sebuah event akan mentrigger sebuah skenario dan then adalah expected outcomenya.


    public void whenViewRestoranGetId() throws Exception{
        // Given
        RestoranModel dummy = generateDummyRestoranModel(1);
        // When
        when(restoranService.getRestoranByIdRestoran(1L)).thenReturn(Optional.of(dummy));
        mockMvc.perform(get("/restoran/view").param("idRestoran","1"))
        // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("resto", hasProperty("nama", is("dummy 1"))))
                .andExpect(model().attribute("resto", hasProperty("alamat", is("alamat 1"))))
                .andExpect(model().attribute("resto", hasProperty("idRestoran", is(1L))))
                .andExpect(model().attribute("resto", hasProperty("nomorTelepon", is(14000))));
    }

2. Jelaskan perbedaan line coverage dan logic coverage.
- Line Coverage adalah seberapa banyak statements/line of code yang di test run.
- Logic Coverage berhubungan dengan struktur internal dari sebuah code, yang memastikan bahwa test tidak hanya mencapai sebuah tujuan tertentu
tetapi juga memberi efek pada struktur internal kode dengan mencoba beberapa combination of truth assignments ke expressions-nya.
Biasanya logic coverage diadopsi oleh aplikasi software yang kritis terhadap keselamatan seperti pada aplikasi penerbangan.

3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa
seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin
terjadi?
- Pada keadaan ideal, sebaiknya membuat unit test terlebih dahulu setelah itu barulah membuat code atau biasa disebut dengan Test Driven Development(TDD).
Test Driven Development adalah pengembangan yang disetir oleh Test. Mudahnya, kita wajib menuliskan test terlebih dahulu baru production code.
Dalam pemrograman komputer, unit testing adalah metode pengujian software yang dengannya setiap unit source code diuji untuk menentukan apakah mereka cocok untuk digunakan.
Unit adalah komponen perangkat lunak terkecil yang dapat diuji. Tujuan unit testing adalah untuk memisahkan setiap bagian dari program dan menguji apakah masing-masing bagian bekerja dengan benar.
Satu unit kecil, sehingga lebih mudah untuk merancang, mengeksekusi, merekam, dan menganalisis hasil pengujian daripada potongan code yang lebih besar.
Cacat yang diungkapkan oleh unit test mudah ditemukan dan relatif mudah diperbaiki.
- Jika urutan dibalik, muncul beberapa resiko, yaitu:
    - Over-engineering : setelah menuliskan test, kita baru sadar kalau implementasi yang kita tulis lebih kompleks dari yang seharusnya.
    - Kode yang kita tulis sulit untuk di tes, membuat kita harus menyesuaikan kode yang telah kita buat agar dapat di tes oleh automated test.
    - No Test at All : Kita jadi malas untuk menulis automated test karena implementasi production code sudah selesai dan sudah berjalan dengan baik (untuk saat ini).

4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam
perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari
perhitungan code coverage.
Karena main class method merupakan class yang tidak dihitung coverage nya, sehingga akan mengganggu skor akhir dari penghitungan coverage.
Hal-hal yang dapat menyebabkan di exlude antara lain file built-in , file yang mempunyai code coverage rendah dan akan menimbukan kerusakan coverage secara keseluruhan dan serta file configurasi yang tidak terdapat bisnis proses didalamnya.


# Tutorial APAP 6
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*
1. Apa itu postman? Apa kegunaan dari postman?
- Postman adalah sebuah aplikasi (berupa plugin) untuk browser chrome sebagai REST Client atau istilahnya adalah aplikasi yang digunakan untuk melakukan uji coba REST API yang telah kita buat.
- Postman ini merupakan tool wajib bagi para developer yang berkutat pada pembuatan API, fungsi utama postman ini adalah sebagai GUI API Caller namun sekarang postman juga menyadiakan fitur lain yaitu Sharing Collection API for Documentation (free), Testing API (free), Realtime Collaboration Team (paid), Monitoring API (paid), Integration (paid).
- Pertama kali postman muncul sebagai add on dari Chrome namun sekarang sudah menjadi aplikasi native.
- Jika sedang mendevelop API sangat direkomendasikan untuk menggunakan Postman.

2. Apa kegunaan dari annotation @JsonIgnoreProperties?
- Anotasi yang dapat digunakan untuk menekan serialisasi properti (selama serialisasi), atau mengabaikan pemrosesan properti JSON yang dibaca (saat deserialisasi).

3. Apa itu ResponseEntity dan apa kegunaannya?
- ResponseEntity mewakili seluruh respons HTTP: kode status, header, dan body. Karena itu, kita dapat menggunakannya untuk mengkonfigurasi respons HTTP sepenuhnya.

     