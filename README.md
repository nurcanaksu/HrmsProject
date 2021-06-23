# HrmsProject
 Human Resources Management System
 
 
 “HRMS” stands for Human Resources Management System.

--

1.AŞAMA
Spring Boot ile hrms isimli proje oluşturuldu,
Katmanları yazıldı,
Sistemde bulunan genel iş pozisyonlarını listeleyecek api yazıldı.

2.AŞAMA

Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.

Req 2 : İş verenler sisteme kayıt olabilmelidir.

Kabul Kriterleri:

Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

Req 3 : Sisteme genel iş pozisyonu isimleri eklenebilir. Örneğin Software Developer, Software Architect.

Kabul Kriterleri:

Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.
Req 4 : İş verenler listelendi. (Sadece tüm liste)

Req 5 : İş arayanlar listelendi. (Sadece tüm liste)

Req 6 : İş pozisyonları listelendi. (Sadece tüm liste)


Req 7 : İş verenler sisteme iş ilanı ekleyebilir.

İş ilanı formunda;
İş tanımı girişi yapılabiliyor. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)
Maaş skalası için min-max girişi yapılabiliyor. (Opsiyonel)
Açık pozisyon adedi girişi yapılabiliyor. (Zorunlu)
Son başvuru tarihi girişi yapılabiliyorr.
Req 8 : Sistemdeki tüm aktif iş ilanları listelenebiliyor.

Liste, tablo formunda geliyor.
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri bulunuyor.
Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebiliyor.

Liste, tablo formunda .
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri yer alıyor.
Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebiliyor.

Liste, tablo formunda .
Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri yer alıyor.
Req 11 : İş verenler sistemdeki bir ilanı kapatabiliyor. (Pasif ilan)
