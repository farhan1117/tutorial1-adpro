Reflections Tutorial1

Reflections1

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
