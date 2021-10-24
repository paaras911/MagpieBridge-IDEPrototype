package magpiebridge.core.analysis.webApp;

import java.util.Collection;

/** This class represents the data of Prototype. */
public class WebAppData {

  private String projectName;
  private String sourcePath;
  private String startTime;
  private String endTime;
  private String duration;
  private String gitBranch;
  private String gitHashValue;
  private Integer lowCount;
  private Integer highCount;
  private Integer changesCount;
  private Collection<WebAnalysisResult> webAppResults;

  public WebAppData(
      String projectName,
      String sourcePath,
      String startTime,
      String endTime,
      String duration,
      String gitBranch,
      String gitHashValue,
      Integer lowCount,
      Integer highCount,
      Integer changesCount,
      Collection<WebAnalysisResult> webAppResults) {
    this.projectName = projectName;
    this.sourcePath = sourcePath;
    this.startTime = startTime;
    this.endTime = endTime;
    this.duration = duration;
    this.gitBranch = gitBranch;
    this.gitHashValue = gitHashValue;
    this.webAppResults = webAppResults;
    this.lowCount = lowCount;
    this.highCount = highCount;
    this.changesCount = changesCount;
  }

  public String projectName() {
    return projectName;
  }

  public String sourcePath() {
    return sourcePath;
  }

  public String startTime() {
    return startTime;
  }

  public String endTime() {
    return endTime;
  }

  public String duration() {
    return duration;
  }

  public String gitBranch() {
    return gitBranch;
  }

  public String gitHashValue() {
    return gitHashValue;
  }

  public Integer changesCount() {
    return changesCount;
  }

  public Integer highCount() {
    return highCount;
  }

  public Integer lowCount() {
    return lowCount;
  }

  public Collection<WebAnalysisResult> webAppResults() {
    return webAppResults;
  }
}
