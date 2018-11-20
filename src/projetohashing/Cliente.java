package projetohashing;

import java.util.ArrayList;

public class Cliente {

   static String nome;
   static String endereco;
   static String idade;
   static String telefone;
   static long cpf;

    static Cliente lista[];

    public Cliente(int tamanhoLista) {
        lista = new Cliente[tamanhoLista * 2];
    }

    public void adicionar(Cliente dados) {
        int posicao = hash((dados.cpf));
        if (lista[posicao] == null) {
            lista[posicao] = dados;
        } else {
            colisaoEmInterior(dados);
        }
    }

    public int hash(long cpf) {
        int hash = (int) (cpf % lista.length);
        return hash;
    }

    public static void colisaoEmInterior(Cliente dados) {
        int r = lista.length / 2;
        for (int i = r; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = dados;
                i = lista.length;
            }

        }
    }
    public void imprimir(){
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
            
        }
    }

    @Override
    public String toString() {
        return "Nome:"+nome
                + "\nIdade: "+idade
                + "\nFone: "+telefone
                + "\nEndereço: "+endereco
                + "\nCPF: "+cpf;
    }
    

}
