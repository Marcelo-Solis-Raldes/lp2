package Aluno_Professor;

/**
 *
 * @author Marcelo
 */
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LerMetodos {
    
    public void lerProfessor(Professor professor){
        
        professor.setNome(JOptionPane.showInputDialog("Digite seu Nome: "));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite sua Idade: ")));
        professor.setSexo(JOptionPane.showInputDialog("Digite seu sexo: "));
        professor.setCpf(JOptionPane.showInputDialog("Digite seu cpf: "));
        professor.setSiape(JOptionPane.showInputDialog("Digite seu Siape"));
        
    }
    public void lerAluno(Aluno aluno){
        
        aluno.setNome(JOptionPane.showInputDialog("Digite seu Nome: "));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: ")));
        aluno.setSexo(JOptionPane.showInputDialog("Digite o sexo: "));
        aluno.setCpf(JOptionPane.showInputDialog("digite seu cpf: "));
        aluno.setRa(JOptionPane.showInputDialog("Digite seu Ra: "));
      // pessoas.add(aluno);
    }
    
    public String nome(){
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        return nome;
    }
     public String cpf() {
        String cpf = JOptionPane.showInputDialog("digite seu Cpf:");
        return cpf;
    }
}
