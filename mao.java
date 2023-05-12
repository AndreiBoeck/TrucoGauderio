import java.util.Random;

public class mao {
    public static String[] jogador(){
        Random rn = new Random();
        String naipe = "";
        String[] mao = new String[3];
        int carta1 = rn.nextInt(41);
        int carta2 = 0;
        for(int i=0;i<3;i++) {
            switch (carta1) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> naipe = carta1 + " Espada";
                case 9 -> naipe = "11 Espada";
                case 10 -> naipe = "12 Espada";
                case 11, 12, 13, 14, 15, 16, 17, 18 -> naipe = (carta1 % 10) + " Paus";
                case 19 -> naipe = "11 Paus";
                case 20 -> naipe = "12 Paus";
                case 21, 22, 23, 24, 25, 26, 27, 28 -> naipe = (carta1 % 20) + " Ouros";
                case 29 -> naipe = "11 Ouros";
                case 30 -> naipe = "12 Ouros";
                case 31, 32, 33, 34, 35, 36, 37, 38 -> naipe = (carta1 % 30) + " Copas";
                case 39 -> naipe = "11 Copas";
                case 40 -> naipe = "12 Copas";
            }
            mao[i] = naipe;
            carta1 = rn.nextInt(41);
            while(carta1==carta2) {
                carta1 = rn.nextInt(41);
            }
            carta2 = carta1;
            }
        return mao;
    }
    public static int[] valor(String[] mao){
        int[] ordem = new int[3];
        for(int i = 0; i<3; i++) {
            String naipe = mao[i];
            switch (naipe) {
                case "1 Espada" -> ordem[i] = 1;
                case "1 Paus" -> ordem[i] = 2;
                case "7 Espada" -> ordem[i] = 3;
                case "7 Ouros" -> ordem[i] = 4;
                case "3 Espada", "3 Paus", "3 Ouros", "3 Copas" -> ordem[i] = 5;
                case "2 Espada", "2 Paus", "2 Ouros", "2 Copas" -> ordem[i] = 6;
                case "1 Ouros", "1 Copas" -> ordem[i] = 7;
                case "12 Espada", "12 Paus", "12 Ouros", "12 Copas" -> ordem[i] = 8;
                case "11 Espada", "11 Paus", "11 Ouros", "11 Copas" -> ordem[i] = 9;
                case "10 Espada", "10 Paus", "10 Ouros", "10 Copas" -> ordem[i] = 10;
                case "7 Paus", "7 Copas" -> ordem[i] = 11;
                case "6 Espada", "6 Paus", "6 Ouros", "6 Copas" -> ordem[i] = 12;
                case "5 Espada", "5 Paus", "5 Ouros", "5 Copas" -> ordem[i] = 13;
                case "4 Espada", "4 Paus", "4 Ouros", "4 Copas" -> ordem[i] = 14;
            }
        }
        return ordem;
    }
    public static boolean envido(){
        String[] mao = jogador();
        int espada = 0;
        int paus = 0;
        int ouros = 0;
        int copas = 0;
        for (int i = 0; i<mao.length; i++){
            if(mao[i].contains("Espada")){espada++;}
            if(mao[i].contains("Paus")){paus++;}
            if(mao[i].contains("Ouros")){ouros++;}
            if(mao[i].contains("Copas")){copas++;}
        }
        if(espada >= 2 || paus >= 2 || ouros >= 2 || copas >= 2){return true;}
        else {return false;}
    }
    public static int envidopontos(boolean validar){
        int[] mao = valor(jogador());
        int pontos = 20;
        for (int i = 0; i < mao.length; i++){
            switch (mao[i]){
                case 1, 2, 7:
                    pontos+=1;
                case 6:
                    pontos+=2;
                case 5:
                    pontos+=3;
                case 14:
                    pontos+=4;
                case 13:
                    pontos+=5;
                case 12:
                    pontos+=6;
                case 11, 4, 3:
                    pontos+=7;
            }
        }
        if(validar){
            return pontos;
        }
        else {
            return 0;
        }

    }
    public static boolean flor(){
        String[] mao = jogador();
        int espada = 0;
        int paus = 0;
        int ouros = 0;
        int copas = 0;
        for (int i = 0; i<mao.length; i++){
            if(mao[i].contains("Espada")){espada++;}
            if(mao[i].contains("Paus")){paus++;}
            if(mao[i].contains("Ouros")){ouros++;}
            if(mao[i].contains("Copas")){copas++;}
        }
        if(espada >= 3 || paus >= 3 || ouros >= 3 || copas >= 3){return true;}
        else {return false;}
    }
}
