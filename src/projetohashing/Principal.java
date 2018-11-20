package projetohashing;

import javax.swing.JOptionPane;


public class Principal {

    
    public static void main(String[] args) {
      Cliente dados = new Cliente(Integer.parseInt(JOptionPane.showInputDialog("Digite o Tamanho da lista: ")));
        int op=9;
     do{
       op=Integer.parseInt(JOptionPane.showInputDialog("MENU: \n"
               + "1 - Adicionar Cliente\n"
               + "2 - Imprimir Clientes\n"
               + "3 - Buscar Cliente\n"
               + "4 - Remover Cliente\n"
               + "5 - Sair"));
       
       switch(op){
           case 1:
             dados.nome = JOptionPane.showInputDialog("Nome: ");
             dados.cpf = JOptionPane.showInputDialog("CPF: ");
             dados.endereco = JOptionPane.showInputDialog("Endereço: ");
             dados.idade = JOptionPane.showInputDialog("Idade: ");
             dados.telefone = JOptionPane.showInputDialog("Fone: ");
             dados.adicionar(dados);
               
               break;
           case 2:
               dados.imprimir();
               break;
           case 3:
               dados.buscarCliente(JOptionPane.showInputDialog("Digite o cpf"));
               break;
           case 4:
        	   
        	   break;
           case 5:
              op=0;
               break;
           default:
               JOptionPane.showMessageDialog(null,"Digite uma opçao valida!");
               break;
       }  
     }while(op!=0);
    }

}
