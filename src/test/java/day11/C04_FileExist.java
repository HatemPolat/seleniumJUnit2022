package day11;

import net.bytebuddy.implementation.bind.annotation.Pipe;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
     public void test1(){


        System.out.println(System.getProperty("User.dir"));
        System.out.println(System.getProperty(""));

        String dosyaYolu="C:\\Users\\Hewlett Packard\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web sitesinden indirdigimiz yada windows icinde olusturdugumuz dosyanin
        indigini yada orda oldugunu test edebilmem icin o dosyanin uzerine shift tusuna basili olarak sag click yapip
        dosyanin yolunu kopyalayip bir String degiskene atariz ve
        dosyayi dogrulamak icin Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));Bu method u kullaniriz.

         */

    }
}
