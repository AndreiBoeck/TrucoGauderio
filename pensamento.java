public class pensamento {
    public static int truco(int[] aquilos){
        int decisao = 0;
        for(int i = 0; i<3; i++){
            decisao += aquilos[i];
        }
        if (decisao>21){return 1;}
        else if(decisao<21 && decisao>=15){return 2;}
        else{return 3;}
    }
    public static int envido(int envido){
        int pontos = maoadversario.envidopontos(maoadversario.envido());
        switch (envido) {
            case 1 -> {
                if (pontos >= 30)
                    return 3;
                else if (pontos >= 25) {
                    return 2;
                } else if (mao.envido()) {
                    return 1;
                } else {
                    return 0;
                }
            }
            case 2 -> {
                if (pontos >= 30)
                    return 2;
                else if (pontos >= 25)
                    return 1;
                else
                    return 0;
            }
            case 3 -> {
                if (pontos >= 30) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }
}
