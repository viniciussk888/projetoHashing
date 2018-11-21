package projetohashing;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		ListaClientes lc = new ListaClientes();
                String tamanho =JOptionPane.showInputDialog("Digite o Tamanho da lista: ");
                int tam = Integer.parseInt(tamanho);
		lc.tamanho(tam);
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("MENU DE OPÇOES:\nEspaços Restantes: "+tam+"\n\n" 
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
                                tam--;
				break;
			case 2:
				JOptionPane.showMessageDialog(null, lc.imprimir());
				break;
			case 3: 
                                String cpf = JOptionPane.showInputDialog("Digite o CPF:");
                                if(lc.buscarCliente(cpf)!=null){
                                    JOptionPane.showMessageDialog(null, lc.buscarCliente(cpf));
                                }else{
                                    JOptionPane.showMessageDialog(null,"Cliente nao encontrado!");
                                }
                                
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
