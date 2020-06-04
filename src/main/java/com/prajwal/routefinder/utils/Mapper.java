package com.prajwal.routefinder.utils;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    public static Map<String, String> pathMapper = new HashMap<>();
    public static Map<String, String> locationMapper = new HashMap<>();

    static {
        pathMapper.put("MalavalliBusStand", "Malavalli");
        pathMapper.put("Bhadravathi", "Bhadravathi");
        pathMapper.put("Harihar", "Harihar");
        pathMapper.put("MysurMofussilBS", "Mysore"); //todo : mysuru or mysore should be accepted
        pathMapper.put("MADIKERI", "Madikeri"); // todo : is mapping mysore mofussil to mysore right ?
        pathMapper.put("Arehalli", "Arehalli");
        pathMapper.put("Tarikere", "Tarikere");
        pathMapper.put("Hosadurga", "Hosadurga");
        pathMapper.put("Chikkamagalur", "Chikkamagalur"); //todo : naming be sure to give the right result
        pathMapper.put("Gandasi", "Gandasi");
        pathMapper.put("KOZHIKODE", "Kozhikode");
        pathMapper.put("Chitradurga", "Chitradurga");
        pathMapper.put("KANAKAPURA", "Kanakapura");
        pathMapper.put("Kodlipete", "Kodlipete");
        pathMapper.put("GubbiBS", "Gubbi");
        pathMapper.put("NitturBS", "Nittur");
        pathMapper.put("Tiptur", "Tiptur");
        pathMapper.put("Piriyapatna", "Piriyapatna");
        pathMapper.put("Kaduru", "Kaduru");
        pathMapper.put("RAMANAGARA", "Ramanagara");
        pathMapper.put("Panchanahalli", "Panchanahalli");
        pathMapper.put("KRNagara", "KRNagara");
        pathMapper.put("Kalasapura", "Kalasapura");
        pathMapper.put("MMHills", "MMHills");
        pathMapper.put("Mangalore", "Mangalore");
        pathMapper.put("BengaluruSriBasaveshwara", "Bangalore");
        pathMapper.put("Belur", "Belur");
        pathMapper.put("KUKKESUBRAMANYA", "Kukke");
        pathMapper.put("Hiriyur", "Hiriyur");
        pathMapper.put("SULLYA", "Sullya");
        pathMapper.put("Kolar", "Kolar");
        pathMapper.put("HARAPPANAHALLI", "Harappanahalli");
        pathMapper.put("BengaluruMysoreRoad", "Bangalore"); // todo : bangalore or bengaluru
        pathMapper.put("Javagal", "Javagal");
        pathMapper.put("MysoreRoad", "MysoreRoad");
        pathMapper.put("Birur", "Birur");
        pathMapper.put("HAROHALLI", "Harohalli");
        pathMapper.put("Honnali", "Honnali");
        pathMapper.put("SriBasaveshwara", "Sri Basaveshwara");
        pathMapper.put("Jayachamarajapura", "Jayachamarajapura");
        pathMapper.put("KUSHALANAGARA", "Kushalanagara");
        pathMapper.put("Hebbale", "Hebbale");
        pathMapper.put("SathnurBusstand", "Sathnur");
        pathMapper.put("DHARMASTALA", "Dharmastala");
        pathMapper.put("Sagara", "Sagara");
        pathMapper.put("Kittur", "Kittur");
        pathMapper.put("VITLA", "Vitla");
        pathMapper.put("THRISSUR", "Thrissur");
        pathMapper.put("MAGADI", "Magadi");
        pathMapper.put("NagamangalaBusStand", "Nagamangala");
        pathMapper.put("Shivamogga", "Shivamogga");
        pathMapper.put("OOTY", "Ooty");
        pathMapper.put("SrirangapatnaBusStand", "Srirangapatna");
        pathMapper.put("MaddurBusStand", "Maddur");
        pathMapper.put("MandyaBusStand", "Mandya");
        pathMapper.put("Udupi", "Udupi");
        pathMapper.put("Arasikere", "Arasikere");
        pathMapper.put("TRICHY", "Trichy");
        pathMapper.put("Kunigal", "Kunigal");
        pathMapper.put("Pavagada", "Pavagada");
        pathMapper.put("HebburuBS", "Hebburu");
        pathMapper.put("Hunsur", "Hunsur");
        pathMapper.put("GowribidanurBusStand", "Gowribidanur");
        pathMapper.put("Sira", "Sira");
        pathMapper.put("Challakere", "Challakere");
        pathMapper.put("Chamarajanagara", "Chamarajanagara");
        pathMapper.put("Halebeedu", "Halebeedu");
        pathMapper.put("PUTTUR", "Puttur");
        pathMapper.put("Sakharayapattana", "Sakharayapattana");
        pathMapper.put("ChikkanayakanahalliBS", "Chikkanayakanahalli");
        pathMapper.put("Madhugiri", "Madhugiri");
        pathMapper.put("THIRUVANATHAPURAM", "Thiruvanathapuram");
        pathMapper.put("SidlaghattaBusStand", "Sidlaghatta");
        pathMapper.put("Nanjangud", "Nanjangud");
        pathMapper.put("HuliyurDurgaBS", "Huliyurdurga");
        pathMapper.put("Saligrama", "Saligrama");
        pathMapper.put("DAVANAGERE", "Davanagere");
        pathMapper.put("ARAKALAGUD", "Arakalagud");
        pathMapper.put("Kempegowda", "Kempegowda");
        pathMapper.put("Kundapura", "Kundapura");
        pathMapper.put("Hosuru", "Hosuru");
        pathMapper.put("HASSAN", "Hassan");
        pathMapper.put("Koratagere", "Koratagere");
        pathMapper.put("Kollegala", "Kollegala");
        pathMapper.put("Turuvekere", "Turuvekere");
        pathMapper.put("Mudigere", "Mudigere");
        pathMapper.put("BengaluruKempegowda", "Bengalurukempegowda");
        pathMapper.put("BagepalliBusStand", "Bagepalli");
        pathMapper.put("Mulbagal", "Mulbagal    ");
        pathMapper.put("Sarguru", "Sarguru");
        pathMapper.put("JC_Pura", "Jc Pura");
        pathMapper.put("PandavapuraBusStand", "Pandavapura");
        pathMapper.put("DabaspeteBS", "Dabaspete");
        pathMapper.put("DoddaballapurBusStand", "Doddaballapur");
        pathMapper.put("Sringeri", "Sringeri");
        pathMapper.put("ChintamaniBusStand", "Chintamani");
        pathMapper.put("HOLENARASIPURA", "Holenarasipura");
        pathMapper.put("SOMAVARAPETE", "Somavarapete");
        pathMapper.put("Tumakur", "Tumakur");
        pathMapper.put("COIMBATORE", "Coimbatore");
        pathMapper.put("Sakleshpura", "Sakleshpura");
        pathMapper.put("PUNE", "Pune");
        pathMapper.put("SORABA", "Soraba");
        pathMapper.put("VijaypuraBusStand", "Vijaypura");
        pathMapper.put("CRPATNA", "Crpatna");
        pathMapper.put("anekal", "Anekal");
        pathMapper.put("VIRAJPETE", "Virajpete");
        pathMapper.put("BengaluruSHANTINAGARA", "Bengalurushantinagara");
        pathMapper.put("ERNAKULAM", "Ernakulam");
        pathMapper.put("ALUR", "Alur");
        pathMapper.put("KGF_BS", "Kgf");
        pathMapper.put("CHANNAPATTANA", "Channapattana");
        pathMapper.put("ChikballapurBusStand", "Chikballapur");
        pathMapper.put("TIRUPATHI", "Tirupathi");
        pathMapper.put("KRPeteBusStand", "Krpete");
        pathMapper.put("Bangarpete", "Bangarpete");
        pathMapper.put("CHENNAI", "Chennai");
        pathMapper.put("MUMBAI", "Mumbai");
        pathMapper.put("Malur", "Malur");
        pathMapper.put("Kattemalalavadi", "Kattemalalavadi");
        pathMapper.put("GUDIBANDE", "Gudibande");
        pathMapper.put("Bilikere", "Bilikere");
        pathMapper.put("Mirle", "Mirle");
        pathMapper.put("UJIRE", "Ujire");
        pathMapper.put("Banawara", "Banawara");
        pathMapper.put("Srinivaspura", "Srinivaspura");
        pathMapper.put("HDKote", "Hdkote");
        pathMapper.put("Gundlupete", "Gundlupete");
        pathMapper.put("Bettadapura", "Bettadapura");
        pathMapper.put("Kottigehara", "Kottigehara");
    }
    // This is for location mapper
    static {
        locationMapper.put("Bengaluru", "Bangalore");
    }

    public Mapper() {

    }
}
