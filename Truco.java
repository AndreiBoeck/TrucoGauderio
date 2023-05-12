import java.io.IOException;
import java.util.Scanner;

public class Truco {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] CartasJogador = mao.jogador();
        int[] ordemjogador = mao.valor(CartasJogador);
        String[] CartasAdversario = maoadversario.adversario();
        int[] ordemadversario = maoadversario.ordenado(CartasAdversario);
        int escolha;
        int pontosjogador = 0;
        int pontosadversario = 0;
        int valorrodada = 1;
        int envido;
        System.out.println("Rodada 1:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s ", CartasJogador[i]);
        }
        System.out.printf("\nAções: \n[1] Truco     [2] Envido     [3] Flor     [4] Fugir\n");
        escolha = in.nextInt();
        switch (escolha) {
            case 1:
                if (pensamento.truco(ordemadversario) == 1)
                    pontosjogador += 1;
                else if (pensamento.truco(ordemadversario) == 2)
                    valorrodada += 1;
                else if (pensamento.truco(ordemadversario) == 3) {
                    valorrodada += 1;
                    System.out.printf("ReTruco!\n [1] Quero e vale quatro!!     [2] Aceito!     [3] Fujo\n");
                    escolha = in.nextInt();
                    switch (escolha) {
                        case 1 -> valorrodada += 2;
                        case 2 -> valorrodada += 1;
                        case 3 -> pontosadversario += valorrodada;
                    }
                }
                break;
            case 2:
                System.out.println("[1] Envido     [2] RealEnvido     [3] FaltaEnvido\n");
                escolha = in.nextInt();
                if (escolha == 1) {
                    switch (pensamento.envido(escolha)) {
                        case 3:
                            System.out.printf("FaltaEnvido!!\n [1] Aceito     [2] Fujo\n");
                            escolha = in.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println(maoadversario.envidopontos(true));
                                    if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                        pontosjogador += Math.abs(pontosjogador - 24);
                                    } else {
                                        pontosadversario += Math.abs(pontosadversario - 24);
                                    }
                                case 2:
                                    pontosadversario += 5;
                            }
                        case 2:
                            System.out.printf("RealEnvido!\n [1] Aceito     [2] FaltaEnvido     [3] Fujo\n");
                            escolha = in.nextInt();
                            switch (escolha) {
                                case 1:

                                    if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                        pontosjogador += 5;
                                    } else {
                                        pontosadversario += 5;
                                    }
                                case 2:
                                    if (pensamento.envido(3) == 1) {
                                        if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                            pontosjogador += Math.abs(pontosjogador - 24);
                                        } else {
                                            pontosadversario += Math.abs(pontosadversario - 24);
                                        }
                                    }
                                case 3:
                                    pontosadversario += 3;
                            }
                        case 1:
                            if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                pontosjogador += 3;
                            } else {
                                pontosadversario += 3;
                            }
                        case 0:
                            pontosjogador += 1;
                            break;
                    }
                }
                if (escolha == 2) {
                    switch (pensamento.envido(escolha)) {
                        case 2:
                            System.out.printf("FaltaEnvido!!\n [1] Aceito     [2] Fujo\n");
                            escolha = in.nextInt();
                            switch (escolha) {
                                case 1:
                                    System.out.println(maoadversario.envidopontos(true));
                                    if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                        pontosjogador += Math.abs(pontosjogador - 24);
                                    } else {
                                        pontosadversario += Math.abs(pontosadversario - 24);
                                    }
                                case 2:
                                    pontosadversario += 5;
                            }
                        case 1:
                            if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                pontosjogador += 3;
                            } else {
                                pontosadversario += 3;
                            }
                        case 0:
                            pontosjogador += 1;
                            break;
                    }
                    if (escolha == 3) {
                        switch (pensamento.envido(escolha)) {
                            case 1:
                                System.out.println(maoadversario.envidopontos(true));
                                if (mao.envidopontos(mao.envido()) > maoadversario.envidopontos(maoadversario.envido())) {
                                    pontosjogador += Math.abs(pontosjogador - 24);
                                } else {
                                    pontosadversario += Math.abs(pontosadversario - 24);
                                }
                            case 0:
                                pontosjogador += 5;
                                break;
                        }
                    }
                }
            case 3:
                System.out.println("Flor");
                if(mao.flor()) {
                    pontosjogador += 5;
                }
                else{
                    pontosadversario+=1;
                }
        }
    }
}