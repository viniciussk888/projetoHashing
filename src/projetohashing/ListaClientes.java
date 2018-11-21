package projetohashing;

import javax.swing.JOptionPane;

public class ListaClientes {
	Cliente lista[];

	void tamanho(int tamanhoLista) {
		lista = new Cliente[tamanhoLista * 2];
	}

	public void adicionar(Cliente dados) {
		int indice = metodoDobra((dados.cpf));
		if (lista[indice] == null) {
			lista[indice] = dados;
		} else {
			int novoId = colisaoEmInterior();
			lista[novoId] = dados;
		}
	}

	private int metodoDobra(String cpf) {
		do {
			String aux = "";
			if (cpf.length() % 2 != 0) { // Se o tamanho do CPF for impar
				cpf = cpf + '0';
			}
			for (int i = 0; i < cpf.length() / 2; i++) {
				int primeiro = Character.getNumericValue(cpf.charAt(i)); // Converte de Char para int
				int ultimo = Character.getNumericValue(cpf.charAt(cpf.length() - (i + 1)));
				int soma = primeiro + ultimo;
				if (soma >= 10) {
					soma %= 10;
				}
				aux += soma;
			}
			cpf = aux;
		} while (cpf.length() != 1);
		return Integer.parseInt(cpf);
	}

	private int colisaoEmInterior() {
		int novoIndice = 0;
		int r = lista.length / 2;
		for (int i = r; i < lista.length; i++) {
			if (lista[i] == null) {
				novoIndice = i;
				break;
			}
		}
		return novoIndice;
	}

	public String imprimir() {
		String imp = "";
		for (int i = 0; i < lista.length; i++) {
                    if(lista[i]!=null){
			imp += "-----------------------------------------------------------------\n";
			imp += lista[i] + "\n";
                    }
		}
		return imp;
	}

	public Cliente buscarCliente(String cpf) {

		int posicao = metodoDobra(cpf);
		int aux = lista.length / 2;
		Cliente retorno = null;

		if (lista[posicao] != null) {

			if (lista[posicao].cpf.equals(cpf)) {
				retorno = lista[posicao];
			} else {
				boolean encontrado = false;
				if (lista[aux] != null) {
					do {
						if (lista[aux].cpf.equals(cpf)) {
							encontrado = true;
							retorno = lista[aux];
						} else {
							aux++;
						}
					} while (encontrado == false);
				} else {
					retorno = null;
				}
			}

		} else {
			retorno = null;
		}

		return retorno;
	}

	public boolean remover(String cpf) {
		boolean retorno = false;
		int posicao = metodoDobra(cpf);

		int aux = lista.length / 2;

		if (lista[posicao] != null) {

			if (lista[posicao].cpf.equals(cpf)) {
				lista[posicao] = null;
				retorno = true;
			} else {
				boolean encontrado = false;
				if (lista[aux] != null) {
					do {
						if (lista[aux].cpf.equals(cpf)) {
							encontrado = true;
							retorno = true;
							lista[aux] = null;
						} else {
							aux++;
						}
					} while (encontrado == false);
				} else {
					retorno = false;
				}
			}

		} else {
			retorno = false;
		}
		return retorno;
	}
}
