# 📰 Graha News

**Graha News** adalah aplikasi pembaca berita modern dan elegan yang dibangun menggunakan **Kotlin Multiplatform (KMP)** dan **Jetpack Compose**. Aplikasi ini didesain dengan antarmuka yang bersih (terinspirasi dari Apple iOS dan Samsung One UI) serta menampilkan berita-berita aktual dari portal terpercaya di Indonesia secara *real-time*.

---

## 👨‍💻 Identitas Mahasiswa
**Tugas Mata Kuliah:** Pengembangan Aplikasi Mobile  
**Nama:** Muhammad Piela Nugrhaa  
**NIM:** 123140200  

---

## ✨ Fitur Utama (Core Features)
Aplikasi ini memiliki 4 fitur pilar utama yang dapat diakses melalui *Bottom Navigation Bar*:

1. 🏠 **Home (Beranda)**
   - Menampilkan *Breaking News* (Berita Utama) pada bagian atas (Hero Section).
   - Menyajikan daftar berita terbaru (Latest News) secara terstruktur.
   - Menggunakan *Pull-to-Refresh* untuk memperbarui data.
2. 🔍 **Explore (Eksplorasi)**
   - Kolom pencarian dinamis yang terhubung langsung dengan **NewsAPI**.
   - Pengguna dapat mencari topik berita apa saja secara *real-time*.
3. 📈 **Trending**
   - Menampilkan artikel berita terpopuler saat ini.
   - Dilengkapi dengan *Chips* kategori topik hangat (misal: #Teknologi, #Ekonomi).
4. 🔖 **Bookmark (Tersimpan)**
   - Sistem penyimpanan artikel lokal tanpa memerlukan internet.
   - Pengguna dapat menyimpan artikel dari *Detail Screen* dan menghapusnya langsung dari halaman Bookmark.

**Fitur Tambahan:**
- **Detail Berita:** Menampilkan gambar ukuran penuh, rangkuman teks, dan tombol khusus "Baca Selengkapnya di Website" yang langsung membuka *Browser* ponsel ke URL asli berita.
- **Transisi Mulus:** Dilengkapi animasi *Crossfade* dan *Slide* antar halaman berkat pustaka navigasi **Voyager**.

---

## 📸 Tampilan Layar (Screenshots)

> **Catatan:** Ganti teks dan tautan di bawah ini dengan tangkapan layar (Screenshot) asli aplikasi saat Anda jalankan di Emulator/HP Anda.

<p align="center">
  <img src="https://via.placeholder.com/250x500.png?text=Screenshot+Home" width="250" title="Home Screen">
  <img src="https://via.placeholder.com/250x500.png?text=Screenshot+Explore" width="250" title="Explore Screen">
  <img src="https://via.placeholder.com/250x500.png?text=Screenshot+Detail" width="250" title="Detail Screen">
</p>

1. **Gambar 1:** Tampilan *Home Screen* dengan *Hero Card* dan daftar berita terbaru.
2. **Gambar 2:** Tampilan fitur *Explore* saat digunakan untuk mencari topik spesifik.
3. **Gambar 3:** Tampilan *News Detail* yang dilengkapi rangkuman dan tombol aksi ke website.

---

## 🎥 Video Demonstrasi

> **Catatan:** Silakan rekam layar HP/Emulator Anda saat menjalankan keempat fitur di atas, unggah ke YouTube/Google Drive, lalu letakkan *link*-nya di bawah ini.

[![Tonton Video Demo](https://img.youtube.com/vi/ID_VIDEO_YOUTUBE/0.jpg)](https://www.youtube.com/watch?v=ID_VIDEO_YOUTUBE)
*(Klik gambar di atas untuk menonton video demo aplikasi)*

---

## 🛠️ Teknologi yang Digunakan
Proyek ini mengimplementasikan konsep-konsep *Modern Android Development (MAD)*:
* **UI Framework:** Jetpack Compose Multiplatform
* **Architecture:** MVVM (Model-View-ViewModel) + Clean Architecture
* **Navigation:** [Voyager](https://voyager.adriel.cafe/) (Library navigasi modern khusus Compose/KMP)
* **Networking:** Ktor Client & Kotlinx Serialization
* **Image Loading:** Coil3 (Asynchronous Image Loading)
* **API:** [NewsAPI.org](https://newsapi.org/)

## 🚀 Cara Menjalankan Aplikasi
1. Lakukan *Clone* atau unduh *source code* proyek ini.
2. Buka proyek menggunakan **Android Studio** versi terbaru (Minimal versi Ladybug/Koala).
3. Tunggu hingga proses *Sync Gradle* selesai.
4. Pilih konfigurasi *Run* untuk modul **`composeApp`** pada perangkat Android (Emulator/Fisik).
5. Klik tombol ▶️ **Run** (Shift + F10).

---
*Dibuat untuk memenuhi tugas akhir / evaluasi mata kuliah Pengembangan Aplikasi Mobile.*