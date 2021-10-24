package magpiebridge.core.analysis.webApp;

import com.ibm.wala.cast.tree.CAstSourcePositionMap.Position;
import com.ibm.wala.util.collections.Pair;
import magpiebridge.core.AnalysisResult;
import magpiebridge.core.Kind;
import org.eclipse.lsp4j.DiagnosticSeverity;

/** The class represents the analysis results for Prototype. */
public class WebAnalysisResult implements AnalysisResult {

  private Position position;
  private Kind kind;
  private String message;
  private DiagnosticSeverity severity;
  private Pair<Position, String> repair;
  private String code;
  private String changed;
  private Iterable<Pair<Position, String>> related;
  private String severityLevel;

  public WebAnalysisResult(
      Position position,
      Kind kind,
      String message,
      DiagnosticSeverity severity,
      Pair<Position, String> repair,
      String code,
      String changed,
      Iterable<Pair<Position, String>> related,
      String severityLevel) {
    this.position = position;
    this.kind = kind;
    this.message = message;
    this.severity = severity;
    this.repair = repair;
    this.code = code;
    this.changed = changed;
    this.related = related;
    this.severityLevel = severityLevel;
  }

  @Override
  public Kind kind() {

    return kind;
  }

  @Override
  public String toString(boolean useMarkdown) {

    return message;
  }

  @Override
  public Position position() {

    return position;
  }

  @Override
  public Iterable<Pair<Position, String>> related() {

    return related;
  }

  @Override
  public DiagnosticSeverity severity() {

    return severity;
  }

  @Override
  public Pair<Position, String> repair() {

    return repair;
  }

  @Override
  public String code() {

    return code;
  }

  public String changed() {

    return changed;
  }

  public String severityLevel() {
    return severityLevel;
  }
}
