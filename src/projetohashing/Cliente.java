package projetohashing;

import java.util.ArrayList;

public class Cliente {

   static String nome;
   static String endereco;
   static String idade;
   static String telefone;
   static String cpf;

    static Cliente lista[];

    public Cliente(int tamanhoLista) {
        lista = new Cliente[tamanhoLista * 2];
    }

    public void adicionar(Cliente dados) {
        int posicao = metodoDobra((dados.cpf));
        if (lista[posicao] == null) {
            lista[posicao] = dados;
        } else {
            colisaoEmInterior(dados);
        }
    }
    
	private int metodoDobra(String cpf) {
		do {
			String aux = "";
			if(cpf.length()%2 != 0) { // Se o tamanho do CPF for impar
				cpf = cpf+'0';
			}
			for (int i = 0; i < cpf.length()/2; i++) {
				int primeiro = Character.getNumericValue(cpf.charAt(i)); // Converte de Char para int
				int ultimo = Character.getNumericValue(cpf.charAt(cpf.length()-(i+1)));
				int soma = primeiro+ultimo;
				if(soma >= 10) {
					soma %= 10;
				}
				aux += soma;
			}
			cpf = aux;
		} while (cpf.length() != 1);
		return Integer.parseInt(cpf);
	}

//    public int hash(long cpf) {
//        int hash = (int) (cpf % lista.length);
//        return hash;
//    }

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
