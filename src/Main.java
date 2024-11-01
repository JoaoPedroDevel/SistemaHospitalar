import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pacientes> listaPacientes = new ArrayList<>();
        List<Medicos> listaMedicos = new ArrayList<>();
        List<Consultas> listaConsultas = new ArrayList<>();
        
        String nomeP;
        String nomeM;
        int escolha;

        // Formato de data brasileiro
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoISO = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("BEM VINDO AO SISTEMA!\nQual operação deseja realizar?\n");
            System.out.println("1. Cadastrar Paciente\n" +
                               "2. Cadastrar Médico\n" +
                               "3. Registrar Consulta\n" +
                               "4. Listar Consultas\n" +
                               "5. Consulta por Paciente\n" +
                               "6. Listar Pacientes\n" +
                               "7. Listar Médicos\n" +
                               "8. Sair");

            System.out.print("Qual operação deseja? ");
            escolha = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    nomeP = sc.nextLine();
                    
                    // Verifica se o paciente já está cadastrado
                    boolean pacienteExistente = false;
                    for (Pacientes p : listaPacientes) {
                        if (p.getNome().equalsIgnoreCase(nomeP)) {
                            pacienteExistente = true;
                            break;
                        }
                    }
                    if (pacienteExistente) {
                        System.out.println("Paciente já cadastrado.\n");
                        break;
                    }

                    LocalDate nascimentoP;
                    while (true) {
                        try {
                            System.out.print("Data de Nascimento do Paciente (dd/MM/yyyy): ");
                            String nascimentoInput = sc.nextLine();
                            nascimentoP = LocalDate.parse(nascimentoInput, formatoBrasileiro);
                            break; // Sai do loop se a data estiver correta
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Por favor, insira no formato dd/MM/yyyy.");
                        }
                    }

                    listaPacientes.add(new Pacientes(nomeP, nascimentoP));
                    System.out.println("Paciente " + nomeP + " adicionado.\n");
                    break;

                case 2:
                    System.out.print("Nome do Médico: ");
                    nomeM = sc.nextLine();
                    
                    // Verifica se o médico já está cadastrado
                    boolean medicoExistente = false;
                    for (Medicos m : listaMedicos) {
                        if (m.getNomeMedico().equalsIgnoreCase(nomeM)) {
                            medicoExistente = true;
                            break;
                        }
                    }
                    if (medicoExistente) {
                        System.out.println("Médico já cadastrado.\n");
                        break;
                    }

                    String especialidadeMedico;
                    System.out.print("Especialidade do Médico: ");
                    especialidadeMedico = sc.nextLine();
                    listaMedicos.add(new Medicos(nomeM, especialidadeMedico));
                    System.out.println("Médico " + nomeM + " adicionado.\n");
                    break;

                case 3:
                    if (listaPacientes.isEmpty() || listaMedicos.isEmpty()) {
                        System.out.println("Cadastre pelo menos um paciente e um médico antes de registrar uma consulta.\n");
                        break;
                    }

                    System.out.println("Selecione um paciente:");
                    for (int i = 0; i < listaPacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + listaPacientes.get(i));
                    }
                    System.out.print("Escolha o número do paciente: ");
                    int pacienteEscolhido = sc.nextInt() - 1;

                    System.out.println("Selecione um médico:");
                    for (int i = 0; i < listaMedicos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaMedicos.get(i));
                    }
                    System.out.print("Escolha o número do médico: ");
                    int medicoEscolhido = sc.nextInt() - 1;
                    sc.nextLine(); // Limpa o buffer

                    String dataConsulta;
                    LocalDate dataConsultaLocal;
                    while (true) {
                        System.out.print("Data da Consulta (dd/MM/yyyy ou yyyy-MM-dd): ");
                        dataConsulta = sc.nextLine();
                        try {
                            if (dataConsulta.contains("/")) {
                                dataConsultaLocal = LocalDate.parse(dataConsulta, formatoBrasileiro);
                            } else {
                                dataConsultaLocal = LocalDate.parse(dataConsulta, formatoISO);
                            }
                            // Verifica se a data da consulta não é no futuro
                            if (dataConsultaLocal.isAfter(LocalDate.now())) {
                                System.out.println("Não é possível agendar uma consulta para uma data futura.");
                                continue;
                            }
                            break; // Sai do loop se a data estiver correta
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Por favor, insira no formato correto.");
                        }
                    }

                    double valorConsulta;
                    while (true) {
                        System.out.print("Valor da consulta (use vírgula como separador decimal): ");
                        String valorInput = sc.nextLine().replace(",", ".");
                        try {
                            valorConsulta = Double.parseDouble(valorInput);
                            if (valorConsulta < 0) {
                                System.out.println("Valor não pode ser negativo. Tente novamente.");
                                continue;
                            }
                            break; // Sai do loop se o valor estiver correto
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Insira um número válido.");
                        }
                    }

                    Consultas consulta = new Consultas(listaPacientes.get(pacienteEscolhido), listaMedicos.get(medicoEscolhido), valorConsulta, dataConsultaLocal);
                    listaConsultas.add(consulta);
                    System.out.println("Consulta agendada com sucesso!\n");
                    break;

                case 4:
                    System.out.println("Consultas registradas:");
                    for (Consultas consultaList : listaConsultas) {
                        System.out.println(consultaList);
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Digite o nome do paciente: ");
                    String nomePacienteConsulta = sc.nextLine();
                    boolean pacienteEncontrado = false;

                    for (Consultas consultas : listaConsultas) {
                        if (consultas.getPaciente().getNome().equalsIgnoreCase(nomePacienteConsulta)) {
                            System.out.println(consultas);
                            pacienteEncontrado = true;
                        }
                    }

                    if (!pacienteEncontrado) {
                        System.out.println("Nenhuma consulta encontrada para o paciente: " + nomePacienteConsulta);
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Pacientes registrados:");
                    for (Pacientes paciente : listaPacientes) {
                        System.out.println(paciente);
                    }
                    System.out.println();
                    break;

                case 7: 
                    System.out.println("Médicos registrados:");
                    for (Medicos medicoList : listaMedicos) {
                        System.out.println(medicoList);
                    }
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
