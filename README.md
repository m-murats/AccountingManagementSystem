# 💰 Accounting Management System (Muhasebe Yönetim Sistemi)

Bu proje, Programming II dersi kapsamında geliştirilmiş, Java Swing arayüzüne ve veritabanı bağlantısına sahip kapsamlı bir finansal takip sistemidir. 
Kullanıcıların gelir-gider takibi yapmasını, finansal raporlar oluşturmasını ve yetki bazlı (Admin/User) işlem yapmasını sağlar.

## 📋 Proje Özellikleri

Proje, Admin ve Kullanıcı olmak üzere iki temel rol üzerine kurulmuştur.

### 🔐 Kimlik Doğrulama ve Yetkilendirme
* **Admin:** Tüm kayıtları yönetebilir, yeni kullanıcı ekleyebilir/silebilir/düzenleyebilir.
* **Accountant/User:** Sadece kendi işlemlerini (gelir/gider) ekleyebilir ve görüntüleyebilir. Kullanıcı yönetimine erişimi yoktur.

### 💸 İşlem (Transaction) Yönetimi
Her işlem şu detaylarla veritabanında saklanır.
* **Otomatik Veriler:** İşlem ID, Tarih (Sistem saati), Ekleyen Kullanıcı.
* **Kullanıcı Girişleri:** Tür (Gelir/Gider), Kategori (Kira, Maaş, Fatura vb.), Tutar, Açıklama, Para Birimi (TL, USD, EURO).
* **Fonksiyonlar:** Ekleme, Silme, Güncelleme ve Listeleme (CRUD).

### 📊 Raporlama
* Aylık toplam gelir, gider ve net bakiye hesaplaması.
* Raporların PDF, Excel veya TXT formatında dışa aktarılması.

## 🛠️ Kullanılan Teknolojiler ve Teknik Gereksinimler

Bu proje aşağıdaki teknik isterleri karşılayacak şekilde tasarlanmıştır:

* **Dil:** Java (JDK 17+)
* **Arayüz:** Java Swing (Panel, Tabbed Pane, Split Pane, JTable, JSpinner vb.).
* **Veritabanı:** MySQL / SQLite / PostgreSQL (JDBC ile bağlantı).
* **OOP Prensipleri:** Kalıtım (Inheritance), Metot Aşırı Yükleme (Overload) ve Ezme (Override).
* **İleri Seviye Java:**
    * **Generics:** Veritabanı işlemleri için jenerik sınıflar.
    * **Regex:** Giriş validasyonları (Email, Tutar, Şifre vb.).
    * **Graphics:** 3 farklı çerçevede özel grafik çizimleri.

## 🚀 Kurulum

1. **Veritabanı Kurulumu:**
   * Proje klasöründeki `database_setup.sql` dosyasını veritabanı yönetim sisteminizde çalıştırın.
   * `DatabaseConnection.java` dosyasındaki kullanıcı adı ve şifre alanlarını kendi yerel ayarlarınıza göre güncelleyin.

2. **Çalıştırma:**
   * Projeyi IDE (IntelliJ, Eclipse veya NetBeans) ile açın.
   * `Main.java` (veya `LoginFrame.java`) dosyasını çalıştırın.
   * **Varsayılan Admin:** `admin` / `1234`
