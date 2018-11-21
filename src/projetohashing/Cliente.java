package projetohashing;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cliente {

	String nome;
	String endereco;
	String idade;
	String telefone;
	String cpf;

	@Override
	public String toString() {
		return "Nome: " + nome + "   |   Idade: " + idade + "   |   Fone: " + telefone + "   |   Endereço: " + endereco
				+ "   |   CPF: " + cpf;
	}

}
