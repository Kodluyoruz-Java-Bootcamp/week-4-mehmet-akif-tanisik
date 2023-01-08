<!-- ABOUT THE PROJECT -->
## Emlakcepte Projesi

## Proje Konusu:
Derslerde yapılan EmlakCepte uygulamasının devamı olacak şekilde
kullanıcıların kullanacağı ekranların API’lerinin yazılması gereklidir.


Kullanıcılar, bu sistem üzerinden ilan oluşturabilir, düzenleyebilir, silebilir
ve detaylarına ulaşabilir. Kendi ilanlarını aktif ve pasif duruma getirebilir ve paket
satın alıp kendi ilanları için kullanabilir.


Ürün: İlan Yayınlama Hakkı


Paket, 10 Adet ilan yayınlama hakkı içerir, bir aylık geçerlilik süresi vardır.
Paketi olmayan veya paketin geçerlilik süresi bitmiş kullanıcılar ilan
yayınlayamazlar. Kullanıcılar paket geçerliliği dolmadan yeni paket alabilir. Bu
durumda yeni geçerlilik tarihi, kalan geçerlilik tarihinin üzerine bir ay olarak
eklenerek bulunmalıdır.

## Gereksinimler;
Kullanıcılar aşağıdaki işlemleri gerçekleştirebilmelidir.


- İlan yayınlama sadece sisteme giriş yapan kullanıcı yapabilmeli
- Aktif ilanlarını görüntüleyebilmeli
- Pasif ilanlarını görüntüleyebilmeli
- Satın aldıkları paketleri(ürünleri) görebilmeli
- Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilmeli
- Kullancıların aldıkları ürünler ödeme işlemi başarılı olduktan sonra
tanımlanmalı ve bu işlem asenkron yapılmalı

## Kullanılacak Teknolojiler;
- Java 8
- JUnit 5
- Spring Boot
- Restfull
- MySQL / Postgre / MongoDb
- RabbitMQ
- Microservice mimarisi
 
## Sistem Kabulleri;
1. Ürünler, yukarıda belirtilen şekilde sistemde hali hazırda tanımlıdır. Ürün oluşturmak için yeni bir servis yazımına gerek yoktur. Sistem içerisinde tanımlanmaları yeterlidir.
2. Ürünler adet bazlı satılmaktadır.
3. Ürünler 10’ar adet olarak satın alınabilmektedir.
4. Ürünün geçerlilik 1 ay yani 30 gün ile sınırlıdır.
5. Ödeme işlemi için sisteme gerekli kayıtların yazılması yeterlidir.
6. Ödeme işlemi senkron yapılmalıdır.
7. İlanlar varsayılan olarak kaydedildiğinde IN_REVIEW statüsündedir. Asenkron
   olarak başka bir servis ACTIVE olarak değiştirmelidir.
8. Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilir.

### İlanın statüleri;
- ACTIVE
- PASSIVE
- IN_REVIEW


## Proje Değerlendirmesi;
- Backend projesinin belirtilen kurallara göre doğru çalışır olmalı (20 puan)
- Mikroservis mimarisi, pratiklerini ve teknolojileri doğru yansıtıyor olmalı. (20
puan)
- Unit Test coverage oranı proje bazlı en az %90 olmalıdır. Coverage oranlarını
dökümana ekleyin.(Model, DTO hariç)(15 puan)
- NoSQL, RDBMS(ORM) ve Hibernate (JPA) gibi teknolojilerin kullanımı (10
puan)
- Loglama ve Exception Handling mekanizmasının kurulması (10 puan)
- Servisler yetkili kullanıcılar tarafından kullanılmalıdır. (10 puan)
- Kodun kalitesine (Clean Code), yapılandırılmasına (Structure) dikkat edilmesi,
yeni özellikler için geliştirmeye açık olması ve anlaşılabilir olması. Desing
- Pattern kullanımı(10 puan)
- Dokümantasyon (UML diagramı, Readme, Postman sorguları, Swagger) (5
puan)
- Loglama sisteminin polimorfik davranış sergilemeli. Sistemin farklı log
kaydetme ihtiyaçlarını karşılayabilmelidir. (DB, Text dosyası, RabbitMQ
kayıtlar atılabilmelidir.) (Bonus 10 Puan)


<!-- TECHNOLOGIES -->
### Technologies


<a href="https://www.java.com/" target="_blank"><img src="outputImages/logos/java.svg" alt="Java" height="80" /></a>  


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.




<!-- CONTACT -->
## Contact

### Mehmet Akif Tanisik 

<a href="https://github.com/mehmet-akif-tanisik" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:matnsk@outlook.com?subject = Feedback&body = Message">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=microsoftoutlook style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/mehmet-akif-tanisik" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  
<a href="https://twitter.com/makiftanisik" target="_blank">
<img src=https://img.shields.io/badge/twitter-%2300acee.svg?&style=for-the-badge&logo=twitter&logoColor=white alt=twitter style="margin-bottom: 20px; margin-left:20px" />
</a>

<!-- PROJECT-BOOTCAMP-PRACTICUM PART -->
<br />

## Java Bootcamp - Kodluyoruz & Solmaz
<div align="center">
  <a href="https://www.solmaz.com">
    <img src="outputImages/logos/solmaz-logo.jpg" alt="Logo" width="220" height="200">
  </a>

<h3 align="center">Company: Solmaz Customs Consultancy/Brokerage Co.</h3>
</div>

<div align="center">
  <a href="https://kodluyoruz.org/tr/kodluyoruz/">
    <img src="outputImages/logos/kodluyoruz-logo.png" alt="Logo" width="350" height="300">
  </a>
<h3 align="center">Organizer: Kodluyoruz.org</h3>
</div>

