import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double onceki_kazanc=0.00;
        double kazanc=0.00;
        double suan_kazanc=0.00;
        double motosiklet = 45.95;
        double araba = 65.95;
        double minibus = 105.05;
        double otobus = 124.70;
        double kamyon = 165.40;
        double tir = 208.75;

        int controller=0;
        int m = 1;//gun sayısı
        int araba_sayısı = 0;
        int tir_sayısı = 0;
        int kamyon_sayısı = 0;
        int otobus_sayısı = 0;
        int minibus_sayısı = 0;
        int motosiklet_sayısı = 0;
        String cevap ="hayir";
        while (cevap.equalsIgnoreCase("hayir")) {//programdan cıkılmadıgı surece gunlerı hesaplama


            System.out.println("OSMAN GAZI KOPRUSU GISE UYGULAMASI BASLATILIYOR.");
            System.out.println(m + ".GUN FIYAT TABLOSU");
            System.out.println("ARAC TURU \t GECIS UCRETI");
            System.out.println("Motosiklet \t " + motosiklet + "TL");
            System.out.println("Araba \t " + araba + " TL");
            System.out.println("Minibus \t " + minibus + " TL");
            System.out.println("Otobus \t " + otobus + "0 TL");
            System.out.println("Kamyon \t " + kamyon + "0 TL");
            System.out.println("Tir \t " + tir + " TL");
        /*0 lar hocanın verdigi gorunum icin konuldu gorsellik*/
        while(cevap.equalsIgnoreCase("hayir")){

            System.out.println("FIYATLARDA BIR DEGISIM VAR MI?");
            System.out.println("Icinde var ya da yok olan bir ifade giriniz");
            System.out.println("Ornek gecerli giris: Evet onaylıyorum.Fiyatlara"
                    + " zam var.");
            System.out.println("Ornek gecersiz giris: Var ama çok az yani "
                    + "yok sayilir.");
            System.out.println("Giris:");
            Scanner s = new Scanner(System.in);
            String girisCumlesi = s.nextLine();
            String[] cumleOgeleri = girisCumlesi.split(" ");
            boolean flag = true;
            for (int i = 0; i < cumleOgeleri.length; i++) {
                if (cumleOgeleri[i].equalsIgnoreCase("var")) {
                    controller++;
                    for (; i < cumleOgeleri.length; i++) {
                        if (cumleOgeleri[i].equalsIgnoreCase("yok") == true) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) {
                        cevap="evet";
                        System.out.println("DEGİSİM VAR BEYANINIZ ALGILANDI");
                        System.out.println("LUTFEN NE TUR BİR DEGİSİM OLDUGUNU ASAGIDAKİ BİCİMDE BELİRTİN.");
                        System.out.println("YUZDE 5 ZAM YA DA YUZDE 10 INDIRIM");
                        Scanner d = new Scanner(System.in);
                        String degisim_ifadesi = d.nextLine();
                        String degisim_ifadesi_ogeleri[] = degisim_ifadesi.split(" ");
                        int oran = 0;//zam ya da indirim oranı
                        int state = -1;
                        for (int k = 0; k < degisim_ifadesi_ogeleri.length; k++) {
                            if (degisim_ifadesi_ogeleri[k].contains("zam")) {
                                oran = Integer.parseInt(degisim_ifadesi_ogeleri[k - 1]);//oran olarak zamdan bir önceki kelimeyi al
                                state = 0;
                            } else if (degisim_ifadesi_ogeleri[k].contains("indirim")) {
                                oran = Integer.parseInt(degisim_ifadesi_ogeleri[k - 1]);//oran olarak indirimden bir önceki kelimeyi al
                                state = 1;
                            }
                        }
                        if (state == 0) {//zam varsa
                            motosiklet = motosiklet + (motosiklet * oran) / 100;
                            araba = araba + (araba * oran) / 100;
                            minibus = minibus + (minibus * oran) / 100;
                            otobus = otobus + (otobus * oran) / 100;
                            kamyon = kamyon + (kamyon * oran) / 100;
                            tir = tir + (tir * oran) / 100;
                            System.out.println("FIYATLARA YUZDE "+oran+" ZAM UYGULANDI");
                            System.out.println(m + ".GUN FIYAT TABLOSU");
                            System.out.println("ARAC TURU \t GECIS UCRETI");
                            System.out.println("Motosiklet \t " + motosiklet + "TL");
                            System.out.println("Araba \t " + araba + " TL");
                            System.out.println("Minibus \t " + minibus + " TL");
                            System.out.println("Otobus \t " + otobus + "0 TL");
                            System.out.println("Kamyon \t " + kamyon + "0 TL");
                            System.out.println("Tir \t " + tir + " TL");
                        }
                        else  if (state == 1) {//indirim varsa
                            motosiklet = motosiklet - (motosiklet * oran) / 100;
                            araba = araba - (araba * oran) / 100;
                            minibus = minibus - (minibus * oran) / 100;
                            otobus = otobus - (otobus * oran) / 100;
                            kamyon = kamyon - (kamyon * oran) / 100;
                            tir = tir - (tir * oran) / 100;
                            System.out.println("FIYATLARA YUZDE "+oran+"INDIRIM UYGULANDI");
                            //guncel fiyat tablosu
                            System.out.println(m + ".GUN FIYAT TABLOSU");
                            System.out.println("ARAC TURU \t GECIS UCRETI");
                            System.out.println("Motosiklet \t " + motosiklet + "TL");
                            System.out.println("Araba \t " + araba + " TL");
                            System.out.println("Minibus \t " + minibus + " TL");
                            System.out.println("Otobus \t " + otobus + "0 TL");
                            System.out.println("Kamyon \t " + kamyon + "0 TL");
                            System.out.println("Tir \t " + tir + " TL");
                        }


                    }else {
                        System.out.println("Girdiginiz metinde var ya da yok ifadesinden sadece biri gecmelidir.");
                        cevap = "hayir";
                    }


                } else if (cumleOgeleri[i].equalsIgnoreCase("yok")) {
                    controller++;
                    for (; i < cumleOgeleri.length; i++) {
                        if (cumleOgeleri[i].equalsIgnoreCase("var")) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true){
                        cevap="evet";
                        System.out.println("DEGİSİM YOK BEYANINIZ ALGILANDI");
                    }

                    else {
                        System.out.println("Girdiginiz metinde var ya da yok ifadesinden sadece biri gecmelidir.");
                        cevap = "hayir";
                    }

                }
            }
            if (controller==0){
                System.out.println("Girdiginiz metinde var ya da yok ifadesi gecmemektedir.");
                cevap = "hayir";
            }

        }

           cevap="hayir";
            controller=0;

            while(cevap.equalsIgnoreCase("hayir")){
              araba_sayısı = 0;
              tir_sayısı = 0;
              kamyon_sayısı = 0;
             otobus_sayısı = 0;
              minibus_sayısı = 0;
              motosiklet_sayısı = 0;
            System.out.println("SAYIN GISE GOREVLISI ,MIKFOFON GIRISI  ARIZALIDIR. LUTFEN GEBZE YONU" + m + ".GUN ARAC SAYILARINI TEK CUMLE SEKLINDE YAZI ILE GIRINIZ.");
            System.out.println("Ornek cumle: Efendim, bugun Gebze yonunde 323 motosiklet, sonra efendime soyleyim, 9543 araba ,sonracıgıma 323 minibus, 2320 otobus, 1634 kamyon ve 2131 tir gecmis bulunmaktadır.Gunluk raporumu saygılarımla arz ederim.");
            System.out.println("Giris:");
            Scanner k = new Scanner(System.in);
            String cumle = k.nextLine();
            String cumle_elemanları[] = cumle.split(" ");
            String lowerCase = cumle.toLowerCase();
            System.out.println("Girmis oldugunuz cumlenin kucuk harflerle ifade edeilmis sekli:"
            +lowerCase);
            for (int l = 0; l < cumle_elemanları.length; l++) {
                //anahtar kelimelerimiz arac isimleridir, arac isminden onceki degerler arac sayısını belirtir .
                //bu nedenle string dizisinden anahtar kelimeden onceki string alınıp ınteger turune cevrilir.
                if (cumle_elemanları[l].contains("araba")) {
                    araba_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                } else if (cumle_elemanları[l].contains("tir")) {
                    tir_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                } else if (cumle_elemanları[l].contains("kamyon")) {
                    kamyon_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                } else if (cumle_elemanları[l].contains("motosiklet")) {
                    motosiklet_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                } else if (cumle_elemanları[l].contains("minibus")) {
                    minibus_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                } else if (cumle_elemanları[l].contains("otobus")) {
                    otobus_sayısı = Integer.parseInt(cumle_elemanları[l - 1]);
                }

            }

            System.out.println("METIN ANALIZI SONUCLARINA GÖRE BEYANINIZ");//girilen degerleri beyan etme
            System.out.println(m + ".GUN GEBZE YONUNE GECEN ARAC SAYILARI TABLOSU");
            System.out.println("ARAC TURU \t SAYI");
            System.out.println("Motosiklet \t " + motosiklet_sayısı);
            System.out.println("Araba \t " + araba_sayısı);
            System.out.println("Minibus \t " + minibus_sayısı);
            System.out.println("Otobus \t " + otobus_sayısı);
            System.out.println("Kamyon \t " + kamyon_sayısı);
            System.out.println("Tir \t " +tir_sayısı);

            System.out.println("BU BEYANI ONAYLIYOR MUSUNUZ");
            System.out.println("Icinde evet ya da hayir olan bir ifade giriniz");
            System.out.println("Ornek gecerli giris: Evet onaylıyorum.tam belirttigin gibi olmus"
                    + "Saygılarımla arz ederim.");
            System.out.println("Ornek gecersiz giris: evet onaylıyorum. "
                    + "Hayirli olsun.");
            System.out.println("Giris:");

            Scanner p = new Scanner(System.in);
            String tum_cumle = p.nextLine();
            String cumle_ogeleri[] = tum_cumle.split(" ");
            boolean bayrak = true;
            for (int f = 0; f < cumle_ogeleri.length; f++) {
                if (cumle_ogeleri[f].contains("evet")) {
                    controller++;
                    for (; f < cumle_ogeleri.length; f++) {
                        if (cumle_ogeleri[f].contains("hayir")) {
                            bayrak = false;
                            break;
                        }
                    }
                    if (bayrak == true){
                        System.out.println("ONAYINIZ ALINMIS VE GEBZE YONUNDEKI DEGERLER KAYDEDILMISTIR.");
                        cevap = "evet";
                    }
                    else {
                        System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                        cevap = "hayir";
                    }


                } else if (cumle_ogeleri[f].contains("hayir")) {
                    controller++;
                    for (; f < cumle_ogeleri.length; f++) {
                        if (cumle_ogeleri[f].contains("evet")) {
                            bayrak = false;
                            break;
                        }
                    }
                    if (bayrak == true)
                        cevap = "hayir";
                    else {
                        System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                        cevap = "hayir";
                    }
                }



            }
            if (controller==0){
                System.out.println("Girdiginiz metinde evet ya da hayir ifadesi gecmemektedir.");
                cevap = "hayir";
            }
     }

            cevap="hayir";
            controller=0;
            int orhangazi_motorsiklet_sayisi=0;
            int orhangazi_araba_sayisi=0;
            int orhangazi_minibus_sayisi=0;
            int orhangazi_otobus_sayisi=0;
            int orhangazi_kamyon_sayisi=0;
            int orhangazi_tir_sayisi=0;
            while (cevap.equalsIgnoreCase("hayir")) {//verilen cevaba göre tekrar random degerler uretilir
                System.out.println("ORHAN GAZI YONUNDEKI GISE GOREVLISINE ULASILMAKTADIR.DEGERLER VERI ANALIZI" +
                        " ILE SIMULE EDILECEK.");
                System.out.println("////AZ ONCE GIRILEN DEGERLERIN +-%5 YAKINLIGINDA RASTGELE DEGERLER URETILIYOR.\\\\\\\\");
                System.out.println("////Ornegin motosiklet adeti Gebze yonunde 100 ise Orhan Gazi yonunde [95,105]" +
                        "aralıgında bir tamsayıdır.\\\\\\\\");
                System.out.println("ANALIZ SONUCU TURETILEN DEGERLER VERITABANINA AKTARILDI.");

                Random random = new Random();
                orhangazi_motorsiklet_sayisi= random.nextInt((motosiklet_sayısı+((motosiklet_sayısı*5)/100))-(motosiklet_sayısı-(motosiklet_sayısı*5)/100))+(motosiklet_sayısı-(motosiklet_sayısı*5)/100);
               /* while(orhangazi_motorsiklet_sayisi<0){
                    orhangazi_motorsiklet_sayisi= random.nextInt((motosiklet_sayısı+(motosiklet_sayısı*5)/100)-(motosiklet_sayısı-(motosiklet_sayısı*5)/100))+(motosiklet_sayısı-(motosiklet_sayısı*5)/100);
                }*/
                orhangazi_araba_sayisi= random.nextInt((araba_sayısı+((araba_sayısı*5)/100))-(araba_sayısı-(araba_sayısı*5)/100))+(araba_sayısı-(araba_sayısı*5)/100);
                /*while(orhangazi_araba_sayisi<0){
                    orhangazi_araba_sayisi= random.nextInt((araba_sayısı+(araba_sayısı*5)/100)-(araba_sayısı-(araba_sayısı*5)/100))+(araba_sayısı-(araba_sayısı*5)/100);
                }*/
                orhangazi_minibus_sayisi= random.nextInt((minibus_sayısı+((minibus_sayısı*5)/100))-(minibus_sayısı-(minibus_sayısı*5)/100))+(minibus_sayısı-(minibus_sayısı*5)/100);
              /*  while(orhangazi_minibus_sayisi<0){
                    orhangazi_minibus_sayisi= random.nextInt((minibus_sayısı+(minibus_sayısı*5)/100)-(minibus_sayısı-(minibus_sayısı*5)/100))+(minibus_sayısı-(minibus_sayısı*5)/100);
                }*/
                orhangazi_otobus_sayisi= random.nextInt((otobus_sayısı+((otobus_sayısı*5)/100))-(otobus_sayısı-(otobus_sayısı*5)/100))+(otobus_sayısı-(otobus_sayısı*5)/100);
                /*while(orhangazi_otobus_sayisi<0){
                    orhangazi_otobus_sayisi= random.nextInt((otobus_sayısı+(otobus_sayısı*5)/100)-(otobus_sayısı-(otobus_sayısı*5)/100))+(otobus_sayısı-(otobus_sayısı*5)/100);
                }*/
                orhangazi_kamyon_sayisi= random.nextInt((kamyon_sayısı+((kamyon_sayısı*5)/100))-(kamyon_sayısı-(kamyon_sayısı*5)/100))+(kamyon_sayısı-(kamyon_sayısı*5)/100);
                /*while(orhangazi_kamyon_sayisi<0){
                    orhangazi_kamyon_sayisi= random.nextInt((kamyon_sayısı+(kamyon_sayısı*5)/100)-(kamyon_sayısı-(kamyon_sayısı*5)/100))+(kamyon_sayısı-(kamyon_sayısı*5)/100);
                }*/
                orhangazi_tir_sayisi= random.nextInt((tir_sayısı+((tir_sayısı*5)/100))-(tir_sayısı-(tir_sayısı*5)/100))+(tir_sayısı-(tir_sayısı*5)/100);
                /*while(orhangazi_tir_sayisi<0){
                    orhangazi_tir_sayisi= random.nextInt((tir_sayısı+(tir_sayısı*5)/100)-(tir_sayısı-(tir_sayısı*5)/100))+(tir_sayısı-(tir_sayısı*5)/100);
                }*/

                System.out.println(m + ".GUN ORHAN GAZI YONUNE GECEN ARAC SAYILARI TABLOSU");
                System.out.println("ARAC TURU \t SAYI");
                System.out.println("Motorsiklet \t " +orhangazi_motorsiklet_sayisi );
                System.out.println("Araba \t " + orhangazi_araba_sayisi);
                System.out.println("Minibus \t " + orhangazi_minibus_sayisi);
                System.out.println("Otobus \t " +orhangazi_otobus_sayisi );
                System.out.println("Kamyon \t " +orhangazi_kamyon_sayisi );
                System.out.println("Tir \t " +orhangazi_tir_sayisi);
                System.out.println("DEGERLERI ONAYLIYOR MUSUNUZ? ONAYLAMIYORSANIZ YENI DEGERLER TURETILECEKTIR.");
                System.out.println("Icinde evet ya da hayir olan bir ifade giriniz");
                System.out.println("Ornek gecerli giris: Evet onaylıyorum.Beklendıgı gibi olmus.");
                System.out.println("Ornek gecersiz giris: evet onaylıyorum.Hayirli olsun.");
                System.out.println("Giris:");
               Scanner p = new Scanner(System.in);
                String tum_cumlem = p.nextLine();
                String cumle_ogelerim[] = tum_cumlem.split(" ");
                boolean bayrak1 = true;
                for (int r = 0; r < cumle_ogelerim.length; r++) {//alınan cumleyi kontrol etme
                    if (cumle_ogelerim[r].contains("evet")) {//eger evet denmisse
                        controller++;
                        for (; r < cumle_ogelerim.length; r++) {
                            if (cumle_ogelerim[r].contains("hayir")) {//hem evet hemhayır olmasını engellemek icin
                                bayrak1 = false;
                                break;
                            }
                        }
                        if (bayrak1 == true){
                            System.out.println("ONAYINIZ ALINMIS VE ORHAN GAZI YONUNDEKI DEGERLER DE KAYDEDILMISTIR.");
                            cevap = "evet";//hem evet hem hayır yoktur, dtring gecerlidir, evet denmistir
                        }

                        else {
                            System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                            cevap = "hayir";
                        }
                    }
                    else if (cumle_ogelerim[r].contains("hayir")) {
                        controller++;
                        for (; r < cumle_ogelerim.length; r++) {
                            if (cumle_ogelerim[r].contains("evet")) {
                                bayrak1 = false;
                                break;
                            }
                        }
                        if (bayrak1 == true)
                            cevap = "hayir";//hem evet hem hayır yoktur, string gecerlidir, hayır denmistir
                        else {
                            System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                            cevap = "hayir";
                        }
                    }

                }

                if (controller==0){
                    System.out.println("Girdiginiz metinde evet ya da hayir ifadesi gecmemektedir.");
                    cevap = "hayir";
                }
            }


            controller=0;
            System.out.println(m + ".GUNE AIT DEGERLER TABLOSU");
            System.out.println("ARAC TURU\tGEBZE YONU\tORHAN GAZI YONU\tKAZANC(TL)");
            double motorsiklet_kazanc,araba_kazanc,otobus_kazanc,minibus_kazanc,kamyon_kazanc,tir_kazanc;
            motorsiklet_kazanc=(motosiklet_sayısı+orhangazi_motorsiklet_sayisi)*motosiklet;
            araba_kazanc=(araba_sayısı+orhangazi_araba_sayisi)*araba;
            minibus_kazanc=(minibus_sayısı+orhangazi_minibus_sayisi)*minibus;
            otobus_kazanc=(otobus_sayısı+orhangazi_otobus_sayisi)*otobus;
            kamyon_kazanc=(kamyon_sayısı+orhangazi_kamyon_sayisi)*kamyon;
            tir_kazanc=(tir_sayısı+orhangazi_tir_sayisi)*tir;

            kazanc=tir_kazanc+kamyon_kazanc+motorsiklet_kazanc+otobus_kazanc+minibus_kazanc+araba_kazanc;
            suan_kazanc=tir_kazanc+kamyon_kazanc+motorsiklet_kazanc+otobus_kazanc+minibus_kazanc+araba_kazanc;

            System.out.println("Motorsiklet \t " + motosiklet_sayısı +"\t"+orhangazi_motorsiklet_sayisi+"\t"+motorsiklet_kazanc);
            System.out.println("Araba \t " + araba_sayısı +"\t"+orhangazi_araba_sayisi+"\t"+araba_kazanc);
            System.out.println("Minibus \t " + minibus_sayısı +"\t"+orhangazi_minibus_sayisi+"\t"+minibus_kazanc);
            System.out.println("Otobus \t " + otobus_sayısı +"\t"+orhangazi_otobus_sayisi+"\t"+otobus_kazanc);
            System.out.println("Kamyon \t " + kamyon_sayısı +"\t"+orhangazi_kamyon_sayisi+"\t"+kamyon_kazanc);
            System.out.println("Tir \t " + tir_sayısı +"\t"+orhangazi_tir_sayisi+"\t"+tir_kazanc);
            System.out.println("Onceki günlerden gelen kazanc :"+onceki_kazanc+"TL");
            System.out.println("Bugunluk kazanc :"+kazanc+"TL");
            System.out.println("Su anki kazanc :"+suan_kazanc+"TL");
            System.out.println("Gunluk ortalama kazanc :"+(kazanc/m)+"TL");

            System.out.println("GUN SONU HESAP KAPAMA ISLEMI YAPILDI.IYI GECELER!");
            System.out.println("YENIDEN MERHABA! BUGUNUN KAYDINA GECMEK ISTIYOR MUSUNUZ?ISTEMIYORSANIZ" +
                    "KOD SONLANACAKTIR.");
            boolean deadend = true;
            while(deadend){
                System.out.println("Icinde evet ya da hayir olan bir ifade giriniz");
                System.out.println("Giris:");
                Scanner p = new Scanner(System.in);
                String tum_cumlem = p.nextLine();
                String cumle_ogelerim[] = tum_cumlem.split(" ");
                boolean bayrak1 = true;
                for (int r = 0; r < cumle_ogelerim.length; r++) {//alınan cumleyi kontrol etme
                    if (cumle_ogelerim[r].contains("evet")) {//eger evet denmisse
                        controller++;
                        for (; r < cumle_ogelerim.length; r++) {
                            if (cumle_ogelerim[r].contains("hayir")) {//hem evet hemhayır olmasını engellemek icin
                                bayrak1 = false;
                                break;
                            }
                        }
                        if (bayrak1 == true){
                            cevap = "hayir";//donguye devam et
                            m++;//kullanıcı diger gune gecmek isteyince gun sayısı attırılır
                            onceki_kazanc=kazanc;
                            deadend=false;
                            break;
                        }else {
                            System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                            cevap = "hayir";
                        }

                    }
                    else if (cumle_ogelerim[r].contains("hayir")) {
                        controller++;
                        for (; r < cumle_ogelerim.length; r++) {
                            if (cumle_ogelerim[r].contains("evet")) {
                                bayrak1 = false;
                                break;
                            }
                        }
                        if (bayrak1 == true){
                            cevap = "evet";//donguyu bitir
                            deadend=false;
                        }

                        else {
                            System.out.println("Girdiginiz metinde evet ya da hayir ifadesinden sadece biri gecmelidir.");
                            cevap = "hayir";
                        }
                    }
                }
                if (controller==0){
                    System.out.println("Girdiginiz metinde evet ya da hayir ifadesi gecmemektedir.");

                }
            }

        }
    }
}