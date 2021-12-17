package br.edu.univas.main;
import br.edu.univas.vo.Participante;
import java.util.Scanner;


public class Recuperacao {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int indexArray = 0;
        Participante[] participantes = new Participante[20];

        do {
            printMenu();
            option = readIntegerValue(scanner);

            if (option == 1) {
                cadastrarParticipante(scanner, participantes, indexArray);
                indexArray++;

            } else if (option == 2) {
                listar(participantes, indexArray);

            } else if (option == 3) {
                removerParticipante(scanner, participantes, indexArray);

            } else if (option != 4) {
                System.out.println("Por favor digite a opção correta!");
            }
        } while (option != 4);

        scanner.close();
    }

    public static void cadastrarParticipante(Scanner scanner, Participante[] participantes, int indexArray) {
        System.out.println("Cadastro do Participante");
        Participante novoParticipante = new Participante();

        System.out.println("Por favor, digite o nome:");
        novoParticipante.nome = scanner.nextLine();

        System.out.println("Por favor, digite o e-mail:");
        novoParticipante.email = scanner.nextLine();

        participantes[indexArray] = novoParticipante;
    }

    public static void listar(Participante[] participantes, int indexArray) {
        for (int i = 0; i < indexArray; i++) {
            Participante participante = participantes[i];
            if (participante != null) {
                System.out.println("Nome: " + participante.nome);
                System.out.println("E-mail: " + participante.email);
            }
        }
    }

    public static void removerParticipante(Scanner scanner, Participante[] xuxa, int indexArray) {
        System.out.println("Por favor digite o Nome a ser removido:");
        int pessoa = readIntegerValue(scanner);
        boolean participanteRemovido = false;

        for (int i = 0; i < indexArray; i++) {
            Participante participante = xuxa[i];
           
			if (participante.pessoa == pessoa ) {
                xuxa[i] = null;
                System.out.println("Participante removido com sucesso!");
                participanteRemovido = true;
                break;
            }
        }

        if (!participanteRemovido) {
            System.out.println("Esse Nome digitado não foi encontrado!");
        }
    }

    public static void printMenu() {
        System.out.println("1. Cadastro de Participante");
        System.out.println("2. Listar todos os participantes");
        System.out.println("3. Remover um participante cadastrado");
        System.out.println("4. Sair");
    }

    public static int readIntegerValue(Scanner scanner) {
        int aux = scanner.nextInt();
        scanner.nextLine();
        return aux;
    }
}