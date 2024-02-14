# Reflections

Muhammad Farhan Ramadhan </br>
1906306155</br>
Adpro C

## Reflections Tutorial1

### Reflections1

Tutorial yang dibuat untuk pembuatan aplikasi eshop ini cukup membantu untuk pembuatan dasar aplikasi. 
Fitur untuk menampilkan data, dengan nama dan jumlah dari produk dapat terlihat dengan jelas. 
Lalu fitur sederhana untuk membuat dan menambahkan produk ke dalam list tersebut.

Pada bagian excersice1 diminta untuk membuat 2 fitur tambahan, yaitu untuk edit produk dan delete produk.
Awalnya saya butuh membaca ulang code-code yang berperan pada aplikasi tersebut.
Lalu mencoba untuk membuat fitur edit produk, membuat halaman html baru untuk mengubah nama produk dan jumlah produk.
Menambahkan function edit baru di dalam ProductService, ProductServiceImpl, ProductController, dan juga ProductRepository untuk mengakomodasi fitur edit tersebut.
Saya sempat terhambat dengan aplikasi jika saya menekan tombol edit yang sudah saya buat dimana menampilkan error bahwa halaman tidak bisa menampilkan produk dengan productId null.
Seketika saya sadar bahwa produk-produk yang dibuat oleh aplikasi belum menambahkan fitur untuk membuat productId untuk setiap produk. 
Jadi saya mencari bagaimana cara membuat productId secara acak terlebih dahulu dengan asumsi aplikasi tersebut akan membuatnya untuk data setiap produk.
Dengan referensi : https://www.baeldung.com/java-uuid. Saya mencoba untuk mengimplementasi java UUID untuk men-generate random produkId.
Ketika fitur edit berhasil, dengan menambahkan pengambilan id dari produk yang mau diedit. 
Selanjutnya fitur delete cukup mudah dengan menambahkan beberapa method pada productRepository, ProductService, 
dan ProductServiceImpl. Mengambil data dari List dan remove sesuai productId yang dimiliki.
Ketika fitur edit berhasil, dengan menambahkan pengambilan id dari produk yang mau diedit saya dapat menampilkan product yang mau diedit pada halaman EditProduct.
Halaman tersebut dapat mengubah Nama dan Jumlah dari produk yang sudah dipilih. 

### Reflections2

Setelah menulis unit test yang diminta dan mencoba beberapa yang cukup dasar, saya menyadari
bahwa banyaknya skenario untuk sebuah testing untuk mengecek jika suatu aplikasi berhasil menangkap
berbagai input dari user. Unit test dari sebuah fitur setidaknya dapat mengetes fungsi dasar terlebih dahulu,
layaknya suatu input, ada tidaknya input, jika input tidak memiliki data, dan selanjutnya. 
Selanjutnya saya mencoba untuk membuat functinal test dasar untuk halaman CreateProduct. 
Mengecek nama dari Page dan juga jika menerima input pada form, akan terlihat pada halaman ProductList.


## Reflections Tutorial2

Tutorial 2 ini lumayan menantang, dengan penambahannnya workflow pada aplikasi pemrograman tutorial1 kemarin.
Pada tutorial ini juga, diminta untuk mengecek code coverage pada unit test yang sudah dibuat dan menambahkannya lagi.
Lalu bagian yang sulit yaitu mengimplementasi sistem CI/CD. Saya sangat struggle pada saat mengikuti modul tutorial. 
Sistem yang cukup kompleks untuk digunakan untuk test dari aplikasi yang dibuat. Saya pun harus bertanya-tanya ke teman
saya dan meminta bantuan. Terutama ketika menambahkan SonarCloud yang dapat dilihat di channel discord, banyak juga yang
struggle menggunakannya. https://github.com/SonarSource/sonarcloud-github-action menggunakan ini sebagai referensi pun 
saya masih butuh bantuan, dimana butuhnya tambahan untuk memberikan access dari sonarcloud ke github melalui secret token.
Setelah itu juga perlu di modifikasi file build.gradle.kts untuk mengimplementasi sonar pada aplikasi, seperti pada
referensi ini, https://docs.sonarsource.com/sonarcloud/advanced-setup/ci-based-analysis/sonarscanner-for-gradle/. 
Setelah itu melakukan deployment menggunakan Dockerfile untuk membuat suatu Docker image yang akan di-deploy oleh web Koyeb.
Terakhir menurut saya aplikasi dan implementasi yang sudah saya buat pada tutorial ini lumayan membuka wawasan baru. 
Workflow yang saya sudah buat masih bisa diubah atau dimodifikasi untuk praktek selanjutnya. Dimana mungkin bisa menambahkan
dan mengganti code yang lebih baik lagi. Lalu membuat dan memenuhi coverage dari code tersebut. Namun dari modul tutorial 2 ini,
Code yang sudah dibuat sudah memenuhi dasar dari CI/CD, dengan menggunakan automation untuk test dan deployment ketika 
adanya perintah push dengan git ke github.
