package br.com.jcnsistemas.readwrite;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Andrade Sampaio
 */
public class TestaLeituraEscrita {

    public static void main(String[] args) throws IOException {

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dataFormatado = hoje.format(formatter);

        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
        LocalDateTime horaAtual = LocalDateTime.now(fusoHorarioDeSaoPaulo);
        formatter = DateTimeFormatter.ofPattern("HHmmss");
        String horaFormatado = horaAtual.format(formatter);

        ReadWrite.run(dataFormatado, horaFormatado);

    }

}
