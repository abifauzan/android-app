package com.example.dicodingfirstsubmission;

import java.util.ArrayList;

public class DestinationData {

    public static String[][] data = new String[][]{
            {"Farmhouse Lembang", "Farmhouse Lembang bisa dikatakan salah satu tempat wisata di Bandung terbaru. " +
            "Tempat ini langsung menyedot banyak pengunjung karena lokasinya yang strategis, dan banyaknya " +
            "spot berfoto yang bagus banget.", "https://www.nativeindonesia.com/wp-content/uploads/2017/11/farmhouse-lembang-bandung.jpg"},
            {"Kebun Teh Sukawarna", "Nah, bagi anda yang ingin ngadem di kebun teh di Lembang, kebun teh Sukawana bisa jadi alternatif nih. " +
            "Tempatnya memang sedikit tersembunyi sehingga rada jarang yang datang kesini.",
            "https://www.nativeindonesia.com/wp-content/uploads/2017/11/kebun-teh-sukawana.jpg"},
            {"Curug Cinulang Cicalengka", "Curug Cinulang terletak di perbatasan kabupaten Bandung dengan Sumedang. Tapi tempatnya lebih " +
            "mudah dijangkau dari Bandung, tepatnya dari Cicalengka.",
            "https://www.nativeindonesia.com/wp-content/uploads/2017/11/curug-cinulang-cicalengka-bandung-dari-bawah.jpg"},
            {"Gunung Tangkuban Perahu", "Gunung Tangkuban Perahu merupakan salah satu situs wisata terkenal di Indonesia. Terletak di daerah " +
            "Lembang, sekitar 20 kilometer di utara Kota Bandung, gunung yang bentuknya menyerupai perahu terbalik ini selalu " +
            "padat pengunjung pada akhir pekan dan waktu liburan.", "https://www.nativeindonesia.com/wp-content/uploads/2014/09/kawah-tangkuban-perahu-2.jpg"},
            {"Danau Situ Patenggang", "Danau Situ Patenggang terletak sekitar 7 Km dari Kawah Putih. Pemandangan yang disuguhkan danau ini sangat indah. " +
            "Dikelilingi oleh lembah dan perkebunan teh yang hijau, banyak pengunjung menjadikan tempat ini sebagai tempat bersantai bersama keluarga dan teman.",
            "https://www.nativeindonesia.com/wp-content/uploads/2017/11/situ-patenggang-pagi-hari.jpg"}
    };

    public static ArrayList<Destination> getListData(){
        Destination destination = null;
        ArrayList<Destination> list = new ArrayList<>();
        for (String[] aData : data) {
            destination = new Destination();
            destination.setTitle(aData[0]);
            destination.setDescription(aData[1]);
            destination.setPhoto(aData[2]);

            list.add(destination);
        }

        return list;
    }
}
