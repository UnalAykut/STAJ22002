@n11.com
Feature: n11 Mobil Uygulaması
  Scenario: n11 Mobil Uygulamasından Telefon Satın Alma Testi
    When Kategoriler menüsüne tıklanır
    And Elektronik kategorisi seçilir
    And Telefon ve Aksesuarları kategorisi seçilir
    And Cep Telefonu kategorisi seçilir
    And Marka filtreleme seçeneği belirlenir
    And Filtreleme menüsüne tıklanır
    And Ürünler filtrelenir
    And Sonuçları Göster butonuna tıklanır
    And Ürün sepete eklenir
    And Sepete gidilir
    Then Sepetteki ürün kontrol edilir
