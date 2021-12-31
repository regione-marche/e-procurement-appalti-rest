package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per un file allegato
 * <br>Contiene il file codificato in Base64
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "fileAllegato",description = "oggetto che rappresenta un file allegato")
public class FileDto {
  private String nomeFile;
  private String fileBase64Encoded;
  
  public FileDto(String nomeFile, String fileBase64Encoded) {
    this.nomeFile = nomeFile;
    this.fileBase64Encoded = fileBase64Encoded;
  }
  
  @ApiModelProperty(value = "il nome del file allegato")
  public String getNomeFile() {
    return nomeFile;
  }
  
  public void setNomeFile(String nomeFile) {
    this.nomeFile = nomeFile;
  }
  
  @ApiModelProperty(value = "contenuto del file codificato in base 64",example = "ZXhhbXBsZQ==")
  public String getFileBase64Encoded() {
    return fileBase64Encoded;
  }
  
  public void setFileBase64Encoded(String fileBase64Encoded) {
    this.fileBase64Encoded = fileBase64Encoded;
  }

  @Override
  public String toString() {
    return "FileDto [" + (nomeFile != null ? "nomeFile=" + nomeFile : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fileBase64Encoded == null) ? 0 : fileBase64Encoded.hashCode());
    result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    FileDto other = (FileDto) obj;
    if (fileBase64Encoded == null) {
      if (other.fileBase64Encoded != null) return false;
    } else if (!fileBase64Encoded.equals(other.fileBase64Encoded)) return false;
    if (nomeFile == null) {
      if (other.nomeFile != null) return false;
    } else if (!nomeFile.equals(other.nomeFile)) return false;
    return true;
  }
  
}
