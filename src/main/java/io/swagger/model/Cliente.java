package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Cliente
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-01T14:51:54.578Z")


public class Cliente   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("sobrenome")
  private String sobrenome = null;

  @JsonProperty("iniciais")
  private String iniciais = null;

  @JsonProperty("dataNascimento")
  private LocalDate dataNascimento = null;

  @JsonProperty("dataAtualizacao")
  private OffsetDateTime dataAtualizacao = null;

  @JsonProperty("status")
  private Boolean status = null;

  /**
   * Gets or Sets tipo
   */
  public enum TipoEnum {
    INTERNO("interno"),
    
    EXTERNO("externo");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  public Cliente id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do cliente.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador do cliente.")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cliente nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do cliente.
   * @return nome
  **/
  @ApiModelProperty(value = "Nome do cliente.")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cliente sobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
    return this;
  }

  /**
   * Sobrenome do cliente
   * @return sobrenome
  **/
  @ApiModelProperty(value = "Sobrenome do cliente")


  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public Cliente iniciais(String iniciais) {
    this.iniciais = iniciais;
    return this;
  }

  /**
   * Get iniciais
   * @return iniciais
  **/
  @ApiModelProperty(value = "")

@Size(min=2,max=7) 
  public String getIniciais() {
    return iniciais;
  }

  public void setIniciais(String iniciais) {
    this.iniciais = iniciais;
  }

  public Cliente dataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Data de nascimento do cliente
   * @return dataNascimento
  **/
  @ApiModelProperty(value = "Data de nascimento do cliente")

  @Valid

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Cliente dataAtualizacao(OffsetDateTime dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
    return this;
  }

  /**
   * Data de atualização do dados do cliente.
   * @return dataAtualizacao
  **/
  @ApiModelProperty(value = "Data de atualização do dados do cliente.")

  @Valid

  public OffsetDateTime getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  public Cliente status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * Status ativo ou inativo do cliente
   * @return status
  **/
  @ApiModelProperty(value = "Status ativo ou inativo do cliente")


  public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Cliente tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
  **/
  @ApiModelProperty(value = "")


  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.id, cliente.id) &&
        Objects.equals(this.nome, cliente.nome) &&
        Objects.equals(this.sobrenome, cliente.sobrenome) &&
        Objects.equals(this.iniciais, cliente.iniciais) &&
        Objects.equals(this.dataNascimento, cliente.dataNascimento) &&
        Objects.equals(this.dataAtualizacao, cliente.dataAtualizacao) &&
        Objects.equals(this.status, cliente.status) &&
        Objects.equals(this.tipo, cliente.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, sobrenome, iniciais, dataNascimento, dataAtualizacao, status, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    sobrenome: ").append(toIndentedString(sobrenome)).append("\n");
    sb.append("    iniciais: ").append(toIndentedString(iniciais)).append("\n");
    sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
    sb.append("    dataAtualizacao: ").append(toIndentedString(dataAtualizacao)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

