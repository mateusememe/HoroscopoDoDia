package util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
Aquário: de 21 janeiro a 18 fevereiro
Peixes: de 19 fevereiro a 20 março
Áries: de 21 março a 20 abril //1 zodiaco
Touro: de 21 abril a 20 maio
Gêmeos: de 21 maio a 20 junho   
Câncer: de 21 junho a 22 julho
Leão: de 23 julho a 22 agosto
Virgem: de 23 agosto a 22 setembro
Libra: de 23 setembro a 22 outubro
Escorpião: de 23 outubro a 21 novembro
Sagitário: de 22 novembro a 21 dezembro

Capricórnio: de 22 dezembro a 20 janeiro



*/
public class Horoscopo {

    public Horoscopo() {
    }
    
    
    public static String buscaSigno(String dtNasc){
        String dt = dtNasc.substring(5), res="";
        if(dt.compareTo("01-20")>0 && dt.compareTo("12-22")<0){
            if(dt.compareTo("02-19")<0)
                res="aquario";
            else if(dt.compareTo("03-21")<0)
                res="peixes";
            else if(dt.compareTo("04-21")<0)
                res="aries";
            else if(dt.compareTo("05-21")<0)
                res="touro";
            else if(dt.compareTo("06-21")<0)
                res="gemeos";
            else if(dt.compareTo("07-23")<0)
                res="cancer";
            else if(dt.compareTo("08-23")<0)
                res="leao";
            else if(dt.compareTo("09-23")<0)
                res="virgem";
            else if(dt.compareTo("10-23")<0)
                res="libra";
            else if(dt.compareTo("11-22")<0)
                res="escorpiao";
            else
                res="sagitario";
        }else
           res="capricornio";
        
        return res;
    }
    public static String buscaPrevisaoImagem(String signo, String arquivo) {
        try(
                FileInputStream fis = new FileInputStream(arquivo);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader arq = new BufferedReader(isr)
                ){
            
            String subL, linhaH;
            
            while(arq != null){
                linhaH = arq.readLine();
                if(linhaH.startsWith(signo, 0)){
                    subL = linhaH.substring(linhaH.indexOf("#") + 1);
                    arq.close();
                    return subL;
                }
                
            }
            arq.close();
        }catch(IOException IOe){
            return IOe.getMessage();
        }

        return null;
       
    }
    
}
