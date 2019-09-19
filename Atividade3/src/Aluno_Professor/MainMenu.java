package Aluno_Professor;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class MainMenu {
    
   public static void main(String[] args) throws SQLException{
        PessoaDao d = new PessoaDao();
        MainMenu.mostrarmenu(d); 
    }
    public static void mostrarmenu(PessoaDao d) throws SQLException{
     int op =-1;
        do{
            String opt = JOptionPane.showInputDialog("[1] [SALVAR] \n[2] [BUSCAR PELO NOME]\n[3] [BUSCAR TODOS] \n[4] [REMOVER] \n[5] [ALTERAR DADOS]\n[0] [SAIR]");
            
            switch(opt){
              case "1":
               d.salvarPessoa(op);
              break;
              case "2":
               int x =-1;
               while(x!=0){
                   int ler = Integer.parseInt(JOptionPane.showInputDialog("(1)- Professor \n(2) - Aluno \n(0)    - Sair"));
                   switch(ler){
                       case 1:
                           d.buscarProfessorNoBD();
                       break;
                       case 2:
                           d.buscarAlunoNoBD();
                       break;
                       case 0:
                           JOptionPane.showMessageDialog(null, "Voltar ao menu!!!!");
                           x=0;
                       break;
                       default: JOptionPane.showMessageDialog(null,"Opção Invaliada");
                   }
               }  
             break;
              case "3":
                  int c = -1;
                 while(c!=0){
                   int ler = Integer.parseInt(JOptionPane.showInputDialog("(1)- Professor \n(2) - Aluno \n(0)    - Sair"));
                   switch(ler){
                       case 1:
                           d.buscarTodosProfessores();
                       break;
                       case 2:
                           d.buscarTodosAlunos();
                       break;
                       case 0:
                           JOptionPane.showMessageDialog(null, "Voltar ao menu!!!!");
                           c=0;
                       break;
                       default: JOptionPane.showMessageDialog(null,"Opção Invaliada");
                   }
               }
              break;
              case "4":
                 int y =-1;
               while(y!=0){
                   int ler = Integer.parseInt(JOptionPane.showInputDialog("[1]- Professor \n[2] - Aluno \n[0] - Sair"));
                   switch(ler){
                       case 1:
                           d.deletarProfessorNoBD();
                       break;
                       case 2:
                           d.deletarAlunoNoBD();
                       break;
                       case 0:
                           JOptionPane.showMessageDialog(null, "Voltar ao menu!!!!");
                           y=0;
                       break;
                       default: JOptionPane.showMessageDialog(null,"Opção Invaliada");
                   }
               }
                  break;
              case "5":
                  int z=-1;
                  while(z!=0){
                   int ler = Integer.parseInt(JOptionPane.showInputDialog("[1]- Professor \n[2] - Aluno \n[0] - Sair"));
                   switch(ler){
                       case 1:
                          d.alterarProfessorNoBD();
                       break;
                       case 2:
                           d.alterarAlunnoNoBD();
                       break;
                       case 0:
                           JOptionPane.showMessageDialog(null, "Voltar ao menu!!!!");
                           z=0;
                           break;
                       default: JOptionPane.showMessageDialog(null,"Opção Invaliada");
                   }
               }
                  break;
              case "0":
                  JOptionPane.showMessageDialog(null, "Saindo do Sistema!!!!!");
                  op = 0;
                 break;
              default:JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }while(op !=0); 
        
    }
        
}
