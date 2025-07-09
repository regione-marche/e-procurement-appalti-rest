package it.maggioli.appalti.rest.dto;

import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe per stampare le informazioni di Build dell'artefatto
 * @author gabriele.nencini
 *
 */
public class VersionDto {
  private String group;
  private String artifact;
  private String name;
  private String version;
  private Instant time;
  
  /**
   * @return the group
   */
  public String getGroup() {
    return group;
  }
  
  /**
   * @param group the group to set
   */
  public void setGroup(String group) {
    this.group = group;
  }
  
  /**
   * @return the artifact
   */
  public String getArtifact() {
    return artifact;
  }
  
  /**
   * @param artifact the artifact to set
   */
  public void setArtifact(String artifact) {
    this.artifact = artifact;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * @return the version
   */
  public String getVersion() {
    return version;
  }
  
  /**
   * @param version the version to set
   */
  public void setVersion(String version) {
    this.version = version;
  }
  
  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDateTime() {
    if(time!=null)
      return Date.from(time);
    return null;
  }
   
  /**
   * @param time the time to set
   */
  public void setTime(Instant time) {
    this.time = time;
  }
  
  
}
