public class Medicos {
    private String nomeMedico;
    private String especialidadeMedico;

    public Medicos(String nomeMedico, String especialidadeMedico) {
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeMedico + ", Especialidade: " + especialidadeMedico;
    }
}
