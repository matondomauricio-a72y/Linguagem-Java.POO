/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Matondo Maurício
 */


public class Emprestimo {

    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    private static final double MULTA_POR_DIA = 200;

    public Emprestimo(Livro livro, int Prazo) {

        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(Prazo);
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean Atrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }

    public long calcularDiasAtraso() {

        if (!Atrasado()) {
            return 0;
        }

        return ChronoUnit.DAYS.between( dataDevolucao, LocalDate.now());
    }

    public double calcularMulta() {

        return calcularDiasAtraso() * MULTA_POR_DIA;
    }

    public String info() {

        return String.format(
                "%s | Emprestado: %s | Prazo: %s | Atrasado: %s | Multa: %.2f KZ",
                livro.getTitulo(),
                dataEmprestimo,
                dataDevolucao,
                Atrasado() ? "Sim" : "Não", calcularMulta());
    }
}