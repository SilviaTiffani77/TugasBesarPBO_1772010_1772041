package com.Tubes.controller;
import java.util.Scanner;
public class ParkirMasukController {



    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
      //array yang dibutuhkan
      double []jamMasuk = new double[5];
      double []menitMasuk = new double[5];

      double []jamKeluar = new double[5];
      double []menitKeluar = new double[5];
      double []bayar = new double[5];
      double total = 0;

      //masukkan data
      for(int x=0; x<5; x++)
      {
        System.out.print("Jam Masuk    : ");
        jamMasuk[x] = sc.nextDouble();
        System.out.print("Menit Masuk    : ");
        menitMasuk[x] = sc.nextDouble();
        System.out.print("Jam Keluar    : ");
        jamKeluar[x] = sc.nextDouble();
        System.out.print("Menit Keluar    : ");
        menitKeluar[x] = sc.nextDouble();

        //hitung lama parkir untuk ditampilkan
        Double jamParkir = (jamKeluar[x]-jamMasuk[x]);
        Double menitParkir = (menitKeluar[x]-menitMasuk[x]);
        if(menitParkir<0){
          jamParkir = jamParkir-1;
          menitParkir = menitParkir+60;
        }
        System.out.println("lama parkir    : "+jamParkir+"jam "+menitParkir+"menit");

        //hitung lama parkir untuk hitung biaya
        double lamaParkir = Math.ceil((((jamKeluar[x]*60)+menitKeluar[x])-((jamMasuk[x]*60)+menitMasuk[x]))/60);

        //hitung dan tampilkan biaya parkir
        if(lamaParkir<2){bayar[x]=5000;
        }else{bayar[x]=5000+((lamaParkir-2)*2000);}
        System.out.println("Biaya Parkir    : "+bayar[x]);
        System.out.println();

        //hitung pendapatan
        total = total+bayar[x];

        //next or stop
        for(int cek=1;cek<=3;cek++){
          System.out.print("Apakah ada yang lain? (y/t)    : ");
          String lanjut = sc.next();
          if(lanjut.equals("y")||lanjut.equals("Y")){cek=4;}
          if(lanjut.equals("t")||lanjut.equals("T")){cek=4;x=5;}
          if(!(lanjut.equals("t")||lanjut.equals("T")||lanjut.equals("y")||lanjut.equals("Y")))
          {
            System.out.println("Masukkan hanya terdiri dari y atau t");
            System.out.println("Anda mempunyai "+(3-cek)+" kesempatan lagi");
            System.out.println();
            if(cek-3==0){x=5;}
          }
        }
        System.out.println();
      }

      System.out.println("Total Pendapatan Hari Ini : "+total);
    }
  }

