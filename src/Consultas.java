import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consultas {
    private Pacientes paciente;
    private Medicos medico;
    private double valorConsulta;
    private LocalDate dataConsulta;

    public Consultas(Pacientes paciente, Medicos medico, double valorConsulta, LocalDate dataConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.valorConsulta = valorConsulta;
        this.dataConsulta = dataConsulta;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public Medicos getMedico() {
        return medico;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    @Override
    public String toString() {
        return "Consulta: " + paciente.getNome() + " com " + medico.getNomeMedico() + " na data " + dataConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - Valor: R$ " + String.format("%.2f", valorConsulta).replace(".", ",");
    }
}
