package br.com.springboot.thymeleaf.exemplothymeleaf.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAREFA")
public class Tarefa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long id;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 25)
    @Column(name = "titulo_tarefa")
    private String tituloTarefa;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 100)
    @Column(name = "dsc_tarefa")
    private String dscTarefa;

    @NotNull
    @NotEmpty
    @Column(name = "flg_conclusao")
    private String flagConclusao;

    @NotNull
    @NotEmpty
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @NotNull
    @NotEmpty
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
