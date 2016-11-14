# Pop Web Service
*A complicated one*

**Luangkan waktu untuk membaca spek ini sampai selesai. Kerjakan hal yang perlu saja.**

## Anggota Tim

Chalvin | Malvin | Taufic

### Arsitektur Umum Server
![Gambar Arsitektur Umum Server](http://gitlab.informatika.org/IF3110_WebBasedDevelopment_2016/TugasBesar2_JavaAndWebService/raw/3747ba2499396d04f742a589a024876964383159/arsitektur_umum.png)

Tugas 2 ini terdiri dari berberapa komponen yang harus dibuat:
* `Web app`: digunakan untuk menangani HTTP request dari web browser dan menghasilkan HTTP response. Bagian yang diimplementasi dengan JSP ini juga bertugas untuk meng-generate tampilan web layaknya PHP. Bagian ini wajib dibuat dengan **Java + Java Server Pages**. Maka dari itu, konversi seluruh kode PHP pada tugas 1 menjadi kode JSP.
* `Marketplace Web Service`: digunakan sebagai interface yang dipanggil oleh aplikasi melalui protokol SOAP. melakukan query ke database, operasi insert, dan operasi update untuk entitas User, Question, dan Answer. Webservice ini akan dipanggil oleh aplikasi dengan menggunakan SOAP. Webservice ini wajib dibuat dengan **JAX-WS dengan protokol SOAP atau Webservice lain** yang basisnya menggunakan **SOAP dan Java**.
* `Identity service`: dipanggil oleh aplikasi untuk menerima email (sebagai username) dan password pengguna, dan menghasilkan *access token*. Identity Service juga dipanggil oleh *marketplace web service* untuk melakukan validasi terhadap *access token* yang sedang dipegang oleh *web app*. Service ini dibuat menggunakan REST. Identity service ini wajib dibuat dengan menggunakan **Java Servlet**.
* `Database`: pisahkan basis data yang telah Anda buat pada tugas 1 menjadi basis data khusus manajemen *account* (menyimpan username, password, dkk) dan basis data marketplace tanpa manajemen *account*. Basis data *account* digunakan secara khusus oleh Identity Service. **Marketplace Web Service tidak boleh secara langsung mengakses basis data account untuk melakukan validasi token** (harus melalui Identity Service).

Perhatikan bahwa Anda tidak perlu menggunakan banyak mesin untuk membuat aplikasi ini. Contohnya, pada satu mesin anda bisa menggunakan port 8000 untuk JSP, port 8001 untuk identity service, dan port 8002 untuk marketplace web service.

### Deskripsi Tugas

Anda diminta untuk membuat marketplace sederhana seperti tugas 1.  Kebutuhan fungsional dan non-fungsional tugas yang harus dibuat adalah sebagai berikut.

1. Halaman registrasi, login, catalog, purchase confirmation, your products, add product, edit product, sales, dan purchases seperti pada tugas 1.
2. Marketplace web service dengan fungsi-fungsi sesuai kebutuhan sistem dalam mengakses data (kecuali login, register, dan logout).
3. Identity service yang menangani manajemen *account* seperti login dan register, serta validasi access token.
4. Fitur like tidak perlu diimplementasikan dengan menggunakan AJAX.
3. Tidak perlu melakukan validasi javascript.
4. Tampilan pada tugas ini **tidak akan dinilai**. Sangat disarankan untuk menggunakan asset dan tampilan dari tugas sebelumnya. Boleh menggunakan CSS framework seperti Bootstrap atau javascript library seperti jQuery.
5. Tidak perlu memperhatikan aspek keamanan dan etika penyimpanan data.


### Skenario

#### Login
1. Pengguna mengakses halaman login, contoh: `/login.jsp` dan mengisi form.
2. JSP akan membuka HTTP request ke Identity Service, contoh `POST /login` dengan body data email dan password.
3. Identity service akan melakukan query ke DB untuk mengetahui apakah email dan password tersebut valid.
4. Identity service akan memberikan HTTP response `access token` dan `expiry time` jika email dan password ada di dalam DB, atau error jika tidak ditemukan data. Silakan definisikan `expiry time` yang menurut Anda sesuai.
5. Access token ini digunakan sebagai representasi state dari session pengguna dan harus dikirimkan ketika pengguna ingin melakukan semua aktivitas, kecuali search (catalog), login, register, dan logout. 
6. Access token dibangkitkan secara random. Silakan definisikan sendiri panjang tokennya.
7. Cara penyimpanan access token dibebaskan.
6. Silakan definisikan format request dan response sesuai kebutuhan anda. Anda dapat menggunakan JSON atau XML untuk REST.

#### Register
1. Pengguna mengakses halaman register, contoh: `/register.jsp` dan mengisi form.
2. JSP akan melakukan HTTP request ke Identity Service, contoh `POST /register` dengan body data yang dibutuhkan untuk registrasi.
3. Identity service akan query DB untuk melakukan validasi bahwa email dan username belum pernah terdaftar sebelumnya.
4. Identity service akan menambahkan user ke DB bila validasi berhasil, atau memberi HTTP response error jika username sudah ada atau confirm password salah.
4. Identity service akan memberikan HTTP response `access token` dan `expiry time` dan user akan ter-login ke halaman catalog.
6. Silakan definisikan format request dan response sesuai kebutuhan anda. Anda dapat menggunakan JSON atau XML untuk REST.

#### Logout
1. Pengguna menekan tombol logout.
2. JSP akan melakukan HTTP request ke Identity Service, contoh `POST /logout` dengan body data yang dibutuhkan.
3. Identity service akan menghapus atau melakukan invalidasi terhadap access token yang diberikan.
4. Identity service akan mengembalikan HTTP response berhasil.
5. Halaman di-*redirect* ke halaman login.

#### Add Product, Search Product, Purchase Product dll
1. Pengguna mengakses halaman add product, misal `/add-product.jsp` dan mengisi form.
2. JSP akan memanggil fungsi pada *marketplace web service* dengan SOAP, misalnya `addProduct(access_token, name, description, price, image)`. Contohnya, dapat dilihat pada
[link berikut](http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/)
Perhatikan pemanggilan pada contoh ini seperti melakukan remote procedure call.
3. Fungsi tersebut akan melakukan HTTP request ke Identity Service, untuk mengenali user dengan `access_token` yang diberikan.
    - Jika `access_token` **kadaluarsa**, maka `addProduct` akan memberikan response expired token.
    - Jika `access_token` **tidak valid**, maka `addProduct` akan memberikan response error ke JSP.
    - Jika `access_token` **valid**, maka `addProduct` akan memasukan produk ke DB, dan memberikan response kesuksesan ke JSP.
4. Jika `access_token` sudah kadaluarsa atau tidak valid (yang diketahui dari response error marketplace web service), sistem akan me-redirect user ke halaman login.
4. Untuk purchase product, like product, unlike product, edit product, delete product, get purchased products, get sold products kira-kira memiliki mekanisme yang sama dengan add product di atas.
5. Silakan definisikan format object request dan response sesuai kebutuhan anda.

#### Bonus
Anda tidak dituntut untuk mengerjakan ini. Tetapi bila Anda cukup dewa (baca=tertantang) silakan selesaikan permasalahan berikut:
- Mekanisme *auto-renew* access token yang tepat sehingga user tidak ter-logout secara paksa saat melakukan serangkaian aktivitas pada sistem dalam waktu yang cukup lama. Access token dapat di generate kembali ketika lifetime dari token tersebut habis. Cara implementasi dibebaskan.

Fokus terlebih dahulu menyelesaikan semua spesifikasi yang ada sebelum memikirkan bonus.

## Penjelasan
### Basis Data

![](/db.PNG)

### Shared Session dengan REST
Konsep dari shared session adalah sebagai developer web app, kita tidak lagi perlu memikirkan masalah session karena semua proses credential sudah diurus oleh domain SSO(single sign on). WebApp hanya menyimpan token yang nantinya digunakan untuk validasi keabsahan credential. 
Selain tidak direpotkan lagi oleh masalah login, webapp juga menjadi lebih aman karena webapp tidak lagi menyimpan data crucial. 

### Token dan expire_time
Pada tugas ini kami menambah 2 kolom pada database user yaitu kolom token dan kolom expire_date atau expire timenya. 
Ketika seorang user melakukan login halaman login atau register pada halaman register, idendity service akan me-generate token user dan expire_time tyang kemudian akan di-update pada **database user**. 
Token akan expire setelah 10 menit.

### Kelebihan dan Kekurangan
#### Kelebihan
1. Lebih aman karena permintaan di-request dari server berbeda
2. Lebih mudah untuk dikembangkan karena tingaal memanggil servicenya
3. Pengaturan session dan cookies lebih mudah

#### Kekurangan
1. Web service lebih susah dikembangkan
2. Membutuhkan request ke berbagai server sehingga **response time** dari sebuah request lebih lama

## Pembagian Tugas

REST :
1. Generate token : 13513044
2. Validasi token : 13514044, 13514032
3. Login : 13513044
4. Register : 13514075
5. Confirm Purchase Information : 13514044

SOAP :
1. Add Product : 13513032
2. View Katalog : 13513075
3. Search Katalog : 13514075
4. Edit Product : 13514032
5. Like/Dislike : 13514044
6. Delete Product : 13514044
7. Get your Product : 13514075
7. Get Purchase : 13514075
8. Get Sales : 13514075
9. Purchase product : 13514032
10. Request Validate Token : 13514032

Web app (JSP) :
1. Halaman Login : 13514044
2. Halaman Register : 13514044
3. Halaman ViewKatalog : 13514032
4. Halaman EditProduct : 13514032
5. Halaman AddProduct : 13514032
6. Halaman YourProduct : 13514044
7. Halaman YourPurchases : 13514075
8. Halaman YourSales : 13514075
9. Halaman Header : 13514075

## About

Asisten IF3110 2016

Adin | Chairuni | David | Natan | Nilta | Tifani | Wawan | William

Dosen : Yudistira Dwi Wardhana | Riza Satria Perdana
