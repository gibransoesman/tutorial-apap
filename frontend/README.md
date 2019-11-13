# Tutorial APAP 8
## Authors
* **Gibran Gifari Soesman** - *1606876462* - *B*

1. Untuk soal nomor 1, saya menggunakan type ada Items.js pada checkbox nya dengan type={checked ? 'checkbox' : 'hidden'}, sehingga dia muncul ketika kotak telah ditekan dan muncul di favorit

2. Untuk soal nomor dua, saya membuat fungsi baru untuk delete. sehingga saat clik di menu hanya add ke list dan untuk fungsi delete untuk slice pada list

3. untuk soal nomor 3, saya fungsi handleChange yang berfungsi untuk show and hide. lalu saya membuat const content untuk menampilkan list apabila checkbox true

4. untuk soal nomor 4, saya membuat component baru EmptyState berupa tulisan belum ada menu favorit dan merujuk soal nomor 3, content itu default EmptyState, apabila favItems lebih dari 0, maka dia berganti kembali ke soal nomor 3.