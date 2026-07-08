package com.gestao.impressorasAPI.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Conversor Jackson para LocalDate.
 *
 * Entrada aceita:
 * - ddMMyyyy   (01012026)
 * - dd/MM/yyyy (01/01/2026)
 *
 * Saída:
 * - dd/MM/yyyy (01/01/2026)
 *
 * Exemplo de uso:
 *
 * <pre>
 * {@code
 * @JsonDeserialize(using = DataConversor.LocalDateDeserializer.class)
 * @JsonSerialize(using = DataConversor.LocalDateSerializer.class)
 * private LocalDate dataInstalacao;
 * }
 * </pre>
 */
public final class DataConversor {

    private static final DateTimeFormatter FORMATO_SEM_SEPARADOR =
            DateTimeFormatter.ofPattern("ddMMyyyy");

    private static final DateTimeFormatter FORMATO_COM_SEPARADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final String REGEX_SEM_SEPARADOR = "\\d{8}";
    private static final String REGEX_COM_SEPARADOR = "\\d{2}/\\d{2}/\\d{4}";

    private DataConversor() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    /**
     * Converte uma String para LocalDate.
     *
     * Formatos aceitos:
     * - ddMMyyyy
     * - dd/MM/yyyy
     */
    public static LocalDate paraLocalDate(String valor) {

        if (valor == null || valor.isBlank()) {
            return null;
        }

        String data = valor.trim();

        try {

            if (data.matches(REGEX_SEM_SEPARADOR)) {
                return LocalDate.parse(data, FORMATO_SEM_SEPARADOR);
            }

            if (data.matches(REGEX_COM_SEPARADOR)) {
                return LocalDate.parse(data, FORMATO_COM_SEPARADOR);
            }

        } catch (DateTimeParseException e) {
            throw criarExcecao(valor, e);
        }

        throw criarExcecao(valor);
    }

    /**
     * Formata um LocalDate para dd/MM/yyyy.
     */
    public static String paraDataFormatada(LocalDate data) {
        return data == null ? null : data.format(FORMATO_COM_SEPARADOR);
    }

    private static IllegalArgumentException criarExcecao(String valor) {
        return new IllegalArgumentException(
                "Data inválida: \"" + valor +
                        "\". Utilize os formatos ddMMyyyy (01012026) ou dd/MM/yyyy (01/01/2026).");
    }

    private static IllegalArgumentException criarExcecao(String valor, Exception causa) {
        return new IllegalArgumentException(
                "Data inválida: \"" + valor +
                        "\". Utilize os formatos ddMMyyyy (01012026) ou dd/MM/yyyy (01/01/2026).",
                causa);
    }

    /**
     * Converte o valor recebido no JSON para LocalDate.
     */
    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser parser,
                                     DeserializationContext context) throws IOException {

            return paraLocalDate(parser.getText());
        }
    }

    /**
     * Converte um LocalDate para String no formato dd/MM/yyyy.
     */
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate value,
                              JsonGenerator generator,
                              SerializerProvider serializers) throws IOException {

            generator.writeString(paraDataFormatada(value));
        }
    }
}