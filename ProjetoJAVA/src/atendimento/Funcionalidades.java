package atendimento;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Scanner;

import estruturas.FilaPacientes;
import estruturas.ListaPacientes;
import pacientes.Paciente;
import pacientes.Status;

public class Funcionalidades {
	
	static Scanner le = new Scanner(System.in);
	private static int controle=0;
	private static String[] UTI =  new String[3];
	private static FilaPacientes filaAtendimento = new FilaPacientes();
	private static FilaPacientes filaEsperaUTI = new FilaPacientes();
	private static ListaPacientes  listaPacientes = new ListaPacientes();
	private static Paciente paciente = new Paciente("","",Status.FILAATENDIMENTO);
	
	public static void iniciar() {
		filaAtendimento.init();
		filaEsperaUTI.init();
		uti();
		menu();
	}
	
	public static void uti() {
		for (int i = 0; i < UTI.length; i++) {
			UTI[i] = "livre";
		}
	}
	
	public static boolean isfull() {
		if(controle == UTI.length) {
			return false;
		} else
			return true;
		
	}	
	
	public static int resposta() {
		int aux = 0,i=0;	
		do {
			try {
				aux = parseInt(showInputDialog("Apresenta tosse?\n1 - SIM\n2 - NÃO"));
				if(aux < 1 || aux > 2) {
					throw new OpcaoInvalidaException();
				}
			
			}catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número"); 
			} 
			catch (OpcaoInvalidaException e) {
				showMessageDialog(null, "A opção deve estar entre 1 e 2");
			}
			if(aux ==1) {
				i=4;
			}else if(aux == 2) {
				i=4;
			}
		}while(i!=4);
		
		return aux;
		
	}
	
	// case 1
	
	public static void pegarSenha() {
		paciente = paciente.atender();
		
		if(listaPacientes.acharPacienteMorto(paciente.getCPF())) {
			showMessageDialog(null, "Paciente com CPF "+paciente.getCPF()+" morto");
			
		}else if(listaPacientes.acharCPF(paciente)){
			showMessageDialog(null, "paciente com o CPF "+ paciente.getCPF()+" esta sendo atendido novamente");
			listaPacientes.filaatendimento(paciente.getCPF());
			filaAtendimento.enqueue(paciente);	
			
		}
		else {
			listaPacientes.add(paciente);
			filaAtendimento.enqueue(paciente);	
		}	
	}
	
	// case 2
	
	public static void atenderPaciente() {
		
		if(filaAtendimento.isEmpty()) {
			showMessageDialog(null, "Fila para o Atendimento esta vazia\n");
		} else if(atendimento() == 5) {
			if(isfull()) {
				paciente = filaAtendimento.dequeue();
				UTI[controle] = paciente.getCPF();				
				listaPacientes.internar(paciente.getCPF());
				controle++;
				showMessageDialog(null, "Paciente em estado grave. Foi internado!");
			}else {
				showMessageDialog(null,"Paciente colocado na fila de espera - Área de internação lotada!");
				paciente = filaAtendimento.dequeue();
				filaEsperaUTI.enqueue(paciente);
				listaPacientes.filaInternacao(paciente.getCPF());
				
			}	
		}else {
			paciente = filaAtendimento.dequeue();
			showMessageDialog(null,"Paciente com o CPF "+ paciente.getCPF()+ " foi mandado para casa pois não precisa de internação\n");		
			listaPacientes.liberar(paciente.getCPF());
			
			
		}
	}
	
	public static int apresentaTosse() {
		int aux = 0,i=0;
		do {
			try {
				aux = parseInt(showInputDialog("Apresenta tosse?\n1 - SIM\n2 - NÃO"));
				if(aux < 1 || aux > 2) {
					throw new OpcaoInvalidaException();
				}
			
			}catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número."); 
			} 
			catch (OpcaoInvalidaException e) {
				showMessageDialog(null, "A opção deve estar entre 1 e 2.");
			}
			if(aux ==1) {
				i=4;
			}else if(aux == 2) {
				i=4;
			}
		}while(i!=4);
		
		return aux;
	}
	
	public static int apresentaCansaco() {
		int aux = 0,i=0;
		do {
			try {
				aux = parseInt(showInputDialog("Apresenta Cansaço?\n1 - SIM\n2 - NÃO"));
				if(aux < 1 || aux > 2) {
					throw new OpcaoInvalidaException();
				}
			
			}catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número."); 
			} 
			catch (OpcaoInvalidaException e) {
				showMessageDialog(null, "A opção deve estar entre 1 e 2.");
			}
			if(aux ==1) {
				i=4;
			}else if(aux == 2) {
				i=4;
			}
		}while(i!=4);
		
		return aux;
	}

  public static int apresentaFebre() {
		int aux = 0,i=0;
		do {
			try {
				aux = parseInt(showInputDialog("Apresenta Febre?\n1 - SIM\n2 - NÃO"));
				if(aux < 1 || aux > 2) {
					throw new OpcaoInvalidaException();
				}
			
			}catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número."); 
			} 
			catch (OpcaoInvalidaException e) {
				showMessageDialog(null, "A opção deve estar entre 1 e 2.");
			}
			if(aux ==1) {
				i=4;
			}else if(aux == 2) {
				i=4;
			}
		}while(i!=4);
		
		return aux;
	}

  public static int dificuldadeRespirar() {
  		int aux = 0,i=0;
  		do {
  			try {
  				aux = parseInt(showInputDialog("Apresenta dificuldade Respirar?\n1 - SIM\n2 - NÃO"));
  				if(aux < 1 || aux > 2) {
  					throw new OpcaoInvalidaException();
  				}
  			
  			}catch(NumberFormatException e) {
  				showMessageDialog(null, "A opção deve ser um número."); 
  			} 
  			catch (OpcaoInvalidaException e) {
  				showMessageDialog(null, "A opção deve estar entre 1 e 2.");
  			}
  			if(aux ==1) {
  				i=4;
  			}else if(aux == 2) {
  				i=4;
  			}
  		}while(i!=4);
  		
  		return aux;
  	}
	
	public static int atendimento() {
		int internar=1;
		if(apresentaTosse() == 1) {
			internar++;
		}
		if(apresentaFebre() == 1) {
			internar++;
		}
		if(apresentaCansaco() == 1) {
			internar++;
		}
		if(dificuldadeRespirar() == 1) {			
			internar++;
		}
		return internar;
	}
	
	// case 3
	
		public static void mostrarUti() {
			String aux="";
			for (int i = 0; i < UTI.length; i++) {
				aux +=UTI[i]+"\n";
			}
			showMessageDialog(null,"CPF dos pacientes na área de internação\n"+aux);
		}
	
	// case 4
		
	public static int verificaObito() {
	  		int aux = 0,i=0;
	  		do {
	  			try {
	  				aux = parseInt(showInputDialog("Paciente esta morto?\n1 - SIM\n2 - NÃO"));
	  				if(aux < 1 || aux > 2) {
	  					throw new OpcaoInvalidaException();
	  				}
	  			
	  			}catch(NumberFormatException e) {
	  				showMessageDialog(null, "A opção deve ser um número."); 
	  			} 
	  			catch (OpcaoInvalidaException e) {
	  				showMessageDialog(null, "A opção deve estar entre 1 e 2.");
	  			}
	  			if(aux ==1) {
	  				i=4;
	  			}else if(aux == 2) {
	  				i=4;
	  			}
	  		}while(i!=4);
	  		
	  		return aux;
	  	}
	
	public static void liberarPacienteInternado() {
		String auxCPF;
		int aux = 0;
		auxCPF = showInputDialog("Pesquisar CPF do Paciente");	
		try {
			for (int i = 0; i < controle; i++) {
				if(UTI[i].equals(auxCPF)) {
					for (int j = i; j < controle-1; j++) {
						UTI[j] = UTI[j+1];
					}
					controle--;
					UTI[controle] = "Livre";
					if(verificaObito() == 1) {
						showMessageDialog(null,"Paciente dado como morto");
						listaPacientes.obito(auxCPF);
						aux=1;
					}else {
						showMessageDialog(null,"Paciente que possui CPF " +auxCPF +" foi mandado para casa");
						listaPacientes.darAlta(auxCPF);
						aux=1;
					}
				}	
			}
			if(aux!=1){
				showMessageDialog(null,"Paciente não encontrado");
			}	
		} catch (ArrayIndexOutOfBoundsException aux1) {
			showMessageDialog(null,"Paciente não encontrado\n");
		}
	} 
	
	// case 5
	
	public static void internarPacFilaDeEspera() {
		if(filaEsperaUTI.isEmpty()) {
			showMessageDialog(null,"A Fila de espara da UTI esta vazia\n");
		}else if(isfull()) {
			paciente = filaEsperaUTI.dequeue();
			UTI[controle] = paciente.getCPF();
			listaPacientes.internar(paciente.getCPF());
			controle++;
			showMessageDialog(null,"Paciente em estado grave foi internado");;
		}else if(controle ==3 ) {
			showMessageDialog(null, "UTI Lotada");
		}
	}
	
	// case 6 
	
	public static void listaDePacientes() {
		showMessageDialog(null, listaPacientes.show());
	}
	
	// case 7 
	
	public static void pesquisarPaciente() {
		
		try {
		  String aux = showInputDialog("Informe o CPF do paciente");
		  if(listaPacientes.mostrarPaciente(aux)) {
		  	
		  }else{
			showMessageDialog(null,"Paciente não encontrado");
		  }
		} catch (NullPointerException e) {
		
		}
	}
	
	public static void menu() {
		String aux="";
	      aux += "1 - Inserir na fila de espera de atendimento\n";
				aux += "2 - Atender paciente\n";
				aux += "3 - Mostrar pacientes na UTI\n";
				aux += "4 - Liberar espaço na área da UTI\n";
				aux += "5 - Internar paciente da fila de espera\n";
				aux += "6 - Mostrar lista de pacientes\n";
				aux += "7 - Encontrar paciente\n";
				aux += "8 - Numero de pacientes que passaram pelo hospital\n";
				aux += "9 - Sair\n";
		
		int opcao=0;
		do {	
			try {
			opcao = parseInt(showInputDialog(aux));
			if(opcao < 1 || opcao > 9) {
				throw new OpcaoInvalidaException(); 
			}
			switch (opcao) {
				case 1:
					pegarSenha();
					break;
				case 2:
					atenderPaciente();
					break;
				case 3:
					mostrarUti();
					break;
				case 4:
					liberarPacienteInternado();
					break;
				case 5:
		 			internarPacFilaDeEspera();
					break;	
				case 6:
					listaDePacientes();
					break;
				case 7:
					pesquisarPaciente();
					break;	
				case 8:
					showMessageDialog(null, "Registros "+listaPacientes.count());
					break;
				case 9:
					opcao=10;
					break;				
			 }
			
		} catch(NumberFormatException e) {
			showMessageDialog(null, "A opção deve ser um número.\n"); // e --> e.toString() 
		} catch (OpcaoInvalidaException e) {
			showMessageDialog(null, "A opção deve estar entre 1 e 9.");
		}	
		} while (opcao!=10);	
		
	}

}
