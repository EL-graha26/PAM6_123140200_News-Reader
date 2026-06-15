#Graha News

**Graha News** adalah aplikasi pembaca berita modern dan elegan yang dibangun menggunakan **Kotlin Multiplatform (KMP)** dan **Jetpack Compose**. Aplikasi ini didesain dengan antarmuka yang bersih (terinspirasi dari Apple iOS dan Samsung One UI) serta menampilkan berita-berita aktual dari portal terpercaya di Indonesia secara *real-time*.

---

##  Identitas Mahasiswa
**Tugas Mata Kuliah:** Tugas 6 Pengembangan Aplikasi Mobile  
**Nama:** Muhammad Piela Nugrhaa  
**NIM:** 123140200  

---

##Fitur Utama (Core Features)
Aplikasi ini memiliki 4 fitur pilar utama yang dapat diakses melalui *Bottom Navigation Bar*:

**Home (Beranda)**
   - Menampilkan *Breaking News* (Berita Utama) pada bagian atas (Hero Section).
   - Menyajikan daftar berita terbaru (Latest News) secara terstruktur.
   - Menggunakan *Pull-to-Refresh* untuk memperbarui data.
     **Explore (Eksplorasi)**
   - Kolom pencarian dinamis yang terhubung langsung dengan **NewsAPI**.
   - Pengguna dapat mencari topik berita apa saja secara *real-time*.
      **Trending**
   - Menampilkan artikel berita terpopuler saat ini.
   - Dilengkapi dengan *Chips* kategori topik hangat (misal: #Teknologi, #Ekonomi).
      **Bookmark (Tersimpan)**
   - Sistem penyimpanan artikel lokal tanpa memerlukan internet.
   - Pengguna dapat menyimpan artikel dari *Detail Screen* dan menghapusnya langsung dari halaman Bookmark.

**Fitur Tambahan:**
- **Detail Berita:** Menampilkan gambar ukuran penuh, rangkuman teks, dan tombol khusus "Baca Selengkapnya di Website" yang langsung membuka *Browser* ponsel ke URL asli berita.
- **Transisi Mulus:** Dilengkapi animasi *Crossfade* dan *Slide* antar halaman berkat pustaka navigasi **Voyager**.

---

##  Tampilan Layar (Screenshots)


<p align="center">
  <img width="180" height="400" alt="image" src="https://github.com/user-attachments/assets/9feea37c-2e50-42cf-8372-b03ab9e486de" />

  <img width="180" height="400" alt="image" src="https://github.com/user-attachments/assets/62c57710-1793-43c7-b55e-25a7aa0d658e" />

  <img width="180" height="400" alt="image" src="https://github.com/user-attachments/assets/e85fb1ae-50e2-4719-b14c-9273ead7047e" />
</p>

1. **Gambar 1:** Tampilan *Home Screen* dengan *Hero Card* dan daftar berita terbaru.
2. **Gambar 2:** Tampilan fitur *Explore* saat digunakan untuk mencari topik spesifik.
3. **Gambar 3:** Tampilan *News Detail* yang dilengkapi rangkuman dan tombol aksi ke website.

---

##  Video Demonstrasi



https://github.com/user-attachments/assets/f128f373-bd78-4f4b-bf01-91c22e725f1a


---

##  Teknologi yang Digunakan
Proyek ini mengimplementasikan konsep-konsep *Modern Android Development (MAD)*:
* **UI Framework:** Jetpack Compose Multiplatform
* **Architecture:** MVVM (Model-View-ViewModel) + Clean Architecture
* **Navigation:** [Voyager](https://voyager.adriel.cafe/) (Library navigasi modern khusus Compose/KMP)
* **Networking:** Ktor Client & Kotlinx Serialization
* **Image Loading:** Coil3 (Asynchronous Image Loading)
* **API:** [NewsAPI.org](https://newsapi.org/)

##  Cara Menjalankan Aplikasi
1. Lakukan *Clone* atau unduh *source code* proyek ini.
2. Buka proyek menggunakan **Android Studio** versi terbaru (Minimal versi Ladybug/Koala).
3. Tunggu hingga proses *Sync Gradle* selesai.
4. Pilih konfigurasi *Run* untuk modul **`composeApp`** pada perangkat Android (Emulator/Fisik).
5. Klik tombol ▶️ **Run** (Shift + F10).

---
