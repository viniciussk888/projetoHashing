package projetohashing;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		ListaClientes lc = new ListaClientes();
		lc.tamanho(Integer.parseInt(JOptionPane.showInputDialog("Digite o Tamanho da lista: ")));
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n" 
					+ "1 - Adicionar Cliente\n"
					+ "2 - Imprimir Clientes\n" 
					+ "3 - Buscar Cliente\n" 
					+ "4 - Remover Cliente\n" 
					+ "5 - Sair"));

			switch (op) {
			case 1:
				Cliente c = new Cliente();
				c.nome = JOptionPane.showInputDialog("Nome: ");
				c.cpf = JOptionPane.showInputDialog("CPF: ");
				c.endereco = JOptionPane.showInputDialog("Endereço: ");
				c.idade = JOptionPane.showInputDialog("Idade: ");
				c.telefone = JOptionPane.showInputDialog("Fone: ");
				lc.adicionar(c);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, lc.imprimir());
				break;
			case 3:
				JOptionPane.showMessageDialog(null, lc.buscarCliente(JOptionPane.showInputDialog("Digite o cpf")));
				break;
			case 4:
				boolean retorno = lc.remover(JOptionPane.showInputDialog("Digite o número do CPF para remover o cliente:"));
				if(retorno == true) {
					JOptionPane.showMessageDialog(null, "Removido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao remover!");
				}
				break;
			case 5:
				op = 0;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
				break;
			}
		} while (op != 0);
	}

}
