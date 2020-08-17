package pacientes;

import java.util.Scanner;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;

public class Paciente {
	
	private String nome;
	private String CPF;
	private int registro;
	private Status status;
	
	Scanner L = new Scanner(System.in);
	
	public Paciente(String nome, String CPF, Status status) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.status = status;
	}

	
	public Paciente atender() {
		int i = 0;
		String nome1="";
		String CPF1="";
		do {
			try {
				nome1 = showInputDialog("Informar nome do paciente");
				i = nome1.length();
				if(i==0) {
					showMessageDialog(null, "Nome não pode ser vazio");
				}
			} catch (Exception e) {
					showMessageDialog(null, "Insira um Nome para continuar");
			}
			
		} while (i==0);
		
		do {
			i=0;
			try {
				CPF1 = showInputDialog("Informar CPF do paciente");
				i = CPF1.length();
				if(i==0) {
					showMessageDialog(null, "CPF não pode ser vazio");
				}	
			} catch (Exception e) {
					showMessageDialog(null, "Insira um CPF para continuar");
			}
			
		} while (i==0);
		
		Paciente aux = new Paciente(nome1,CPF1,Status.FILAATENDIMENTO);
		return aux;
	}

	@Override
	public String toString() {
		return "Nome: "+ nome +
			   "\nCPF: " + CPF +  
			   "\nRegistro: "+registro+
			   "\nStatus: " + status+"\n";
				
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}

