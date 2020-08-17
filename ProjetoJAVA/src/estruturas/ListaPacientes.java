package estruturas;

import static javax.swing.JOptionPane.showMessageDialog;

import pacientes.Paciente;
import pacientes.Status;

public class ListaPacientes {

	private class NO {
		private Paciente dado;
		private NO prox;
	}

	private static NO lista = null;
	private int registro=1;
	
	public boolean isEmpty() {
		if (lista == null)
			return true;
		else
			return false;
	}

	public void add(Paciente elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (isEmpty()) {
			novo.dado.setRegistro(registro);
			registro++;
			lista = novo;
			novo.prox = null;
			
		} 
		else if(acharCPF(elem)){
			showMessageDialog(null,"CPF encontrado na base de dados");
		}
		else if (!novo.dado.getCPF().equals(lista.dado.getCPF())) {
				novo.prox = lista;
				novo.dado.setRegistro(registro);
				lista = novo;
				registro++;
			} 
		
		     else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (!novo.dado.getCPF().equals(lista.dado.getCPF()))
						aux = aux.prox;
						
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	
	public boolean acharCPF(Paciente elem) {
		NO aux = lista;
		int i =0;
		while (aux != null) {
			if (elem.getCPF().equals(aux.dado.getCPF())) {
				i++;
			}
			aux = aux.prox;	
		}
		return i>0;
	}
	
	
	public int count() {
		int cont = 0;
		NO aux = lista;
		while (aux != null) {
			cont++;
			aux = aux.prox;
		}
		return cont;
	}
	
	public String show() {
		NO aux = lista;
		String listapacientes="LISTA DE PACIENTES\n";
		while (aux != null) {
			listapacientes += aux.dado.toString()+"\n";
			aux = aux.prox;
			
		}
			return listapacientes;
	}
	
	
	
	 public boolean internar(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.INTERNADO);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	 	 
	  public boolean obito(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.OBITO);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	 
	  public boolean darAlta(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.EMALTA);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	 
	  public boolean filaInternacao(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.FILAINTERNACAO);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	  
	  public boolean liberar(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.LIBERADO);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	  
	  public boolean filaatendimento(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					aux.dado.setStatus(Status.FILAATENDIMENTO);
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	   
	  public boolean mostrarPaciente(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					i++;
					showMessageDialog(null,aux.dado.toString());
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	  
	  public boolean acharPacienteMorto(String elem) {
			NO aux = lista;
			int i =0;
			while (aux != null) {
				if (elem.equals(aux.dado.getCPF())) {
					if(aux.dado.getStatus().equals(Status.OBITO)) {
						i++;
					}
				}
				aux = aux.prox;	
			}
			return i>0;
		}
	  
	 
}


