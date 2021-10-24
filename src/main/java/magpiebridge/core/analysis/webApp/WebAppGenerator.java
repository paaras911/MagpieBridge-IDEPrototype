package magpiebridge.core.analysis.webApp;

import static j2html.TagCreator.a;
import static j2html.TagCreator.b;
import static j2html.TagCreator.body;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.each;
import static j2html.TagCreator.h3;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.i;
import static j2html.TagCreator.img;
import static j2html.TagCreator.input;
import static j2html.TagCreator.p;
import static j2html.TagCreator.rawHtml;
import static j2html.TagCreator.script;
import static j2html.TagCreator.span;
import static j2html.TagCreator.style;
import static j2html.TagCreator.table;
import static j2html.TagCreator.tbody;
import static j2html.TagCreator.td;
import static j2html.TagCreator.th;
import static j2html.TagCreator.thead;
import static j2html.TagCreator.title;
import static j2html.TagCreator.tr;

import j2html.tags.ContainerTag;
import j2html.tags.UnescapedText;
import java.io.File;
import magpiebridge.core.MagpieServer;

/** The class generates a HTML page when analysis results are consumed by the server. */
public class WebAppGenerator {

  public static String generateHTML(
      String serverAddress, WebAppData data, MagpieServer magpieServer) {
    return html(generateHeader(), generateBody(data)).renderFormatted();
  }

  private static ContainerTag generateHeader() {
    return head(
            title("MagpieBridge WebApp"),
            new UnescapedText(
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"  crossorigin=\"anonymous\">\n"
                    + "\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\"  crossorigin=\"anonymous\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" integrity=\"sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />"
                    + "\n"
                    + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
                    + "<script src=\"https://rawgit.com/padolsey/jQuery-Plugins/master/sortElements/jquery.sortElements.js\"></script>\n"
                    + "<script src=\"https://rawgit.com/kimmobrunfeldt/progressbar.js/1.0.0/dist/progressbar.js\"></script>"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>"),
            style(
                "* { box-sizing: border-box; padding: 0.4rem; }\n"
                    + " html { scroll-behavior: smooth; }\n"
                    + ".scroll{ overflow: scroll;}\n"
                    + ".card-header{ background-color: white !important;}\n"
                    + ".logo{ margin-left: 2rem;}\n"
                    + ".card{ min-height: 360px; }\n"
                    + ".form-data{ padding: 0.8rem;	}\n"
                    + "thead{ background-color: #009dff !important;}\n"
                    + ".dropdown{ float: right;}\n"
                    + "#fixedText{\n"
                    + "  color: #28a745!important;\n"
                    + "  margin-left: 0.05 rem;\n"
                    + "}\n"
                    + "fixed_btn{  float: right;}\n"
                    + ".dropbtn {  background-color: #009dff; color: white; padding: 16px;font-size: 16px; border: none; cursor: pointer;}\n"
                    + "a{ cursor: pointer; text-decoration: none}\n"
                    + ".dropdown-content { display: none;position: absolute; background-color: #f9f9f9;  min-width: 160px;box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2); z-index: 1;}\n"
                    + ".dropdown-content a:hover {background-color: #f1f1f1;}\n"
                    + ".dropdown:hover .dropdown-content {display: block;}\n"
                    + ".dropdown-content a {color: black; padding: 12px 16px;  text-decoration: none; display: block;}\n"
                    + ".btn{"
                    + " background-color: #009dff !important;"
                    + "  border: none;"
                    + "  color: black;"
                    + "  padding: 15px 32px;"
                    + "  text-align: center;"
                    + "  text-decoration: none;"
                    + "  display: inline-block;"
                    + "  font-size: 16px;"
                    + "  cursor: pointer;"
                    + "  position: absolute;"
                    + "  bottom: 0;"
                    + "  left: 0;"
                    + "  width: 100%;}\n"
                    + "	 .sts{display: block; padding-top: 2rem;}\n"
                    + "  .sts-block{margin-top: 50%; margin-left: 3rem;}\n"
                    + "  .txt-clr{ color:black !important;}\n"
                    + "  #warn, #errs, #changes{font-size:xx-large !important;}\n"
                    + "  body{background-color:lightgray !important;}\n"
                    + "  #change-warnings{ margin-top: 1rem;}\n"
                    + "  .errs, .warns{width: max-content;	}\n"
                    + "  span.changed-text{padding: 2px !important;}\n"
                    + "	.changed-text{"
                    + " color: #28a745!important;"
                    + " border: 2px solid #28a745!important;"
                    + " margin-right: 0.7rem;"
                    + " border-radius: 8px;}\n"
                    + " span.sem-changed{"
                    + " padding: 2px !important;}\n"
                    + " .sem-changed{"
                    + " color: #EF7738!important;"
                    + " border: 2px solid #EF7738!important;"
                    + " margin-right: 0.7rem;"
                    + " border-radius: 8px;}\n"
                    + "	.sem-changed, .changed-text{"
                    + " position: relative;display: inline-block;}\n"
                    + "	.sem-changed .tooltiptext,.changed-text .tooltiptext {"
                    + " visibility: hidden;"
                    + " width: 240px;"
                    + " background-color: #555;"
                    + " color: #fff;"
                    + " text-align: center;"
                    + "border-radius: 6px;"
                    + " padding: 5px 0;"
                    + " position: absolute;"
                    + " z-index: 1;"
                    + " bottom: 125%;"
                    + " left: 50%;"
                    + " margin-left: -60px;"
                    + " opacity: 0;"
                    + " transition: opacity 0.3s;}\n"
                    + "	.sem-changed .tooltiptext::after, .changed-text .tooltiptext::after {"
                    + " content: '';"
                    + " position: absolute;"
                    + " top: 100%;"
                    + " left: 50%;"
                    + " margin-left: -5px;"
                    + " border-width: 5px;"
                    + " border-style: solid;"
                    + " border-color: #555 transparent;}\n"
                    + " .sem-changed:hover .tooltiptext, .changed-text:hover .tooltiptext { visibility: visible;opacity: 1;}\n"
                    + " #container {"
                    + " margin-top: 1rem;"
                    + " margin-left: 2.5rem;"
                    + " width: 250px;"
                    + " height: 250px;"
                    + " position: relative;}\n"
                    + " .sem-changed{ color: #EF7738!important;\r\n"
                    + "  border: 2px solid #EF7738!important;\r\n"
                    + "  margin-right: 0.7rem;\r\n"
                    + "  border-radius: 8px;}\n"
                    + ".dashed{ color:green !important;"
                    + " text-decoration:   line-through; }"))
        .with(generateScript());
  }

  private static ContainerTag generateBody(WebAppData results) {
    return body(
        div(h3(b("MagpieBridge Dashboard"))),
        div(
                div(div(
                            div(b("Introduction and Progress")).withClass("card-header"),
                            div(div(
                                        div(
                                                div(
                                                    b("Project: "),
                                                    span(getProjectName(
                                                            results
                                                                .webAppResults()
                                                                .iterator()
                                                                .next()
                                                                .position()
                                                                .getURL()
                                                                .getFile()))
                                                        .withId("prj-name")),
                                                div(
                                                    b("Source Path: "),
                                                    span(getProjectPath(
                                                            results
                                                                .webAppResults()
                                                                .iterator()
                                                                .next()
                                                                .position()
                                                                .getURL()
                                                                .toString()))
                                                        .withId("prj-name")),
                                                div(
                                                    b("Analysis Duration: "),
                                                    span(results.duration()).withId("prj-time")),
                                                div(
                                                    b("Analysis Start Time: "),
                                                    span(results.startTime()).withId("prj-start")),
                                                div(
                                                    b("Analysis End Time: "),
                                                    span(results.endTime()).withId("prj-end")),
                                                div(
                                                    b("Git Branch: "),
                                                    span(results.gitBranch()).withId("git-branch")),
                                                div(
                                                    b("Git Commit Hash: "),
                                                    span(results.gitHashValue())
                                                        .withId("git-hash")))
                                            .withClass("col-md-4"),
                                        div(div().withId("container")).withClass("col-md-4"),
                                        div(
                                                div(
                                                    img()
                                                        .withSrc("")
                                                        .withClass("img-fluid float-right")),
                                                p(
                                                        div(
                                                            a(
                                                                    span(results
                                                                            .lowCount()
                                                                            .toString())
                                                                        .withId("warn")
                                                                        .withClass(
                                                                            "badge badge-pill badge-light"),
                                                                    b("Low").withClass("txt-clr"))
                                                                .withHref("#change_errors")),
                                                        div(
                                                            a(
                                                                    span(results
                                                                            .highCount()
                                                                            .toString())
                                                                        .withId("errs")
                                                                        .withClass(
                                                                            "badge badge-pill badge-danger"),
                                                                    b("High").withClass("txt-clr"))
                                                                .withHref("#change_errors")),
                                                        div(
                                                            a(
                                                                    span(results
                                                                            .changesCount()
                                                                            .toString())
                                                                        .withId("changes")
                                                                        .withClass(
                                                                            "badge badge-pill badge-light"),
                                                                    b("File Changes")
                                                                        .withClass("txt-clr"))
                                                                .withHref("#change_errors")))
                                                    .withClass("sts-block"))
                                            .withClass("col-md-4"))
                                    .withClass("row"))
                                .withClass("card-body"))
                        .withClass("col card"))
                    .withClass("row"),
                div(div(
                            div(
                                    b("Analysis Summary"),
                                    div(
                                            button("Filter").withClass("dropbtn"),
                                            div(
                                                    div(
                                                        input()
                                                            .withType("checkbox")
                                                            .withId("filter_vulnerabilities")
                                                            .attr(
                                                                "onClick",
                                                                "filter('filter-vulnerabilities')"),
                                                        span("Vulnerabilities")),
                                                    div(
                                                        input()
                                                            .withType("checkbox")
                                                            .withId("filter-fixes")
                                                            .attr(
                                                                "onClick",
                                                                "filter('filter-fixes')"),
                                                        span("Fixed Code")),
                                                    div(
                                                        input()
                                                            .withType("checkbox")
                                                            .withId("filter-changes")
                                                            .attr(
                                                                "onClick",
                                                                "filter('filter-changes')"),
                                                        span("Changed code")))
                                                .withClass("dropdown-content filter"))
                                        .withClass("dropdown"))
                                .withClass("card-header"),
                            div(table(
                                        thead(
                                                tr(
                                                    th(
                                                        span(
                                                            input()
                                                                .withType("checkbox")
                                                                .withId("select_all"))),
                                                    th(i("Filename").withClass("fas fa-sort"))
                                                        .withId("file_name"),
                                                    th(i("Line Number").withClass("fas fa-sort"))
                                                        .withId("line_no"),
                                                    th(i("Message").withClass("fas fa-sort"))
                                                        .withId("msg"),
                                                    th(i("Severity").withClass("fas fa-sort"))
                                                        .withId("severity"),
                                                    th("Repair")))
                                            .withClass("tab-head"),
                                        tbody(
                                                each(
                                                    results.webAppResults(),
                                                    result ->
                                                        tr(
                                                                td(
                                                                    input()
                                                                        .withName("checkbox")
                                                                        .withType("checkbox")
                                                                        .attr(
                                                                            "onClick",
                                                                            "rowChecked(this)")),
                                                                td(
                                                                    a(getFileName(
                                                                            result
                                                                                .position()
                                                                                .getURL()
                                                                                .getFile()))
                                                                        .withClass("file_click"),
                                                                    span("").withId("fixedText")),
                                                                td(
                                                                    Integer.toString(
                                                                        result
                                                                            .position()
                                                                            .getFirstLine())),
                                                                td(checkForChanges(result)),
                                                                td(result.severityLevel()),
                                                                td("-"))
                                                            .withClass(getRowClass(result))))
                                            .withId("change_errors"))
                                    .withClass("table table-hover table-striped table-bordered ")
                                    .withId("analysis_table"))
                                .withClass("card-body"))
                        .withClass("col card"))
                    .withClass("row"))
            .withClass("container-fluid"));
  }

  /** Assign class based on the whether it is a change or a vulnerability */
  private static String getRowClass(WebAnalysisResult result) {

    if (result.changed() == null) return "vulnerabilities";
    else return "changes";
  }

  /** The method checks for the type of change and assigns the style class. */
  private static ContainerTag checkForChanges(WebAnalysisResult result) {

    if (result.changed() == "false")
      return div(
          p(span("Commit changes and rerun analysis").withClass("tooltiptext"), span("Changed"))
              .withClass("changed-text"),
          span(result.toString(true)));
    else if (result.changed() == "true")
      return div(
          p(span("Commit changes and rerun analysis").withClass("tooltiptext"), span("Changed"))
              .withClass("sem-changed"),
          span("Un-analysed"));
    else return div(span(result.toString(true)));
  }

  /** Gets the path from URL */
  private static String getProjectPath(String path) {

    String projectPath = path.substring(0, path.indexOf("/src"));
    return projectPath;
  }

  /** Get the Project Name from URL. */
  private static String getProjectName(String fileName) {
    String projectName = fileName.substring(fileName.indexOf("/"), fileName.indexOf("/src"));
    File file = new File(projectName);
    return file.getName();
  }

  private static String getFileName(String filePath) {

    File file = new File(filePath);
    return file.getName();
  }

  private static ContainerTag generateScript() {
    String scriptCode =
        "window.onload = function onLoad() {\n"
            + "this.listenSelectAll();\n"
            + "this.sortTable();\n"
            + "this.startProgressBar();\n"
            + "this.disableCheckboxForChanges();\n"
            + "}\n"
            + "function  listenSelectAll(){\n"
            + "var table = document.getElementById('analysis_table');\n"
            + "var checkItAll = document.getElementById('select_all');\n"
            + "checkItAll.addEventListener('change', function() {\n"
            + "var inputs = table.querySelectorAll('tbody>tr>td>input');\n"
            + "if (checkItAll.checked) {\n"
            + " inputs.forEach(function(input) {\n"
            + " input.checked = true;});\n"
            + "markAsFixed(true);}\n"
            + "else if(!checkItAll.checked) {\n"
            + "inputs.forEach(function(input) {\n"
            + "input.checked = false;});\n "
            + "markAsFixed(false);}});}\n"
            + "function startProgressBar(){\n"
            + "var  bar = new ProgressBar.Circle(container, {\n"
            + " color: '#aaa',\n"
            + "strokeWidth: 4,\n"
            + " trailWidth: 1,\n"
            + "easing: 'easeInOut',\n"
            + " duration: 10,\n"
            + " text: {\n"
            + "   autoStyleContainer: false \n"
            + " }, \n"
            + " from: { color: '#aaa', width: 3 }, \n"
            + " to: { color: '#009dff', width: 5 }, \n"
            + " step: function (state, circle) {  \n"
            + "      circle.path.setAttribute('stroke', state.color); \n"
            + "      circle.path.setAttribute('stroke-width', state.width); \n"
            + "      var value = Math.round(circle.value() * 100);  \n"
            + "     if (value === 0) {  \n"
            + "        circle.setText('');  \n"
            + "      } else {  \n"
            + "        circle.setText(value +'%'); \n"
            + "      }  \n"
            + "} \n"
            + " }); \n"
            + " bar.text.style.fontFamily = 'Raleway, Helvetica, sans-serif';\n"
            + "  bar.text.style.fontSize = '2rem';\n"
            + " bar.animate(1.0); \n"
            + "} \n"
            + "function rowChecked(elt){\n"
            + "if(elt.checked){\n"
            + "		 addFixedClass(elt);\n"
            + "        }\n"
            + "    else  {\n"
            + "		   removeFixedClass(elt);\n"
            + "        var table = document.getElementById(\"analysis-table\");\n"
            + "        var checkItAll = document.getElementById(\"select_all\");\n"
            + "        checkItAll.checked = false;\n"
            + "    }   }\n"
            + "function sortTable() {\n"
            + "	  var table = $('table');\n"
            + "	  $('#line_no, #severity, #file_name, #msg')\n"
            + "	    .each(function () {\n"
            + "	      var th = $(this),\n"
            + "	        thIndex = th.index(),\n"
            + "	        inverse = false;\n"
            + "	      th.click(function () {\n"
            + "	        table.find('td').filter(function () {\n"
            + "	          return $(this).index() === thIndex;\n"
            + "	        }).sortElements(function (a, b) {\n"
            + "	          if ($.text([a]) == $.text([b]))\n"
            + "	            return 0;\n"
            + "	          return $.text([a]) > $.text([b]) ? inverse ? -1 : 1 : inverse ? 1 : -1;\n"
            + "	        }, function () {\n"
            + "	          return this.parentNode;\n"
            + "	        });\n"
            + "	        inverse = !inverse;\n"
            + "	      });\n"
            + "	    });\n"
            + "	}\n"
            + "function markAsFixed(bool){\n"
            + "var cb = document.getElementsByName('checkbox')\n"
            + "if(bool==true){\n"
            + "cb.forEach(checkIfMarked)\n"
            + "function checkIfMarked(item, index){\n"
            + " if(item.checked){\n"
            + " addFixedClass(item);\n"
            + "}}}\n"
            + "else {\n"
            + "cb.forEach(checkIfMarked)\n"
            + "function checkIfMarked(item, index){\n"
            + "if(!item.checked){\n"
            + "removeFixedClass(item)\n"
            + " } }}}\n"
            + "function addFixedClass(elt){\n"
            + "var fixedText = 'Fixed'+' '+'&#10003';\n"
            + "var tag = elt.parentElement.nextElementSibling.lastElementChild;\n"
            + "tag.innerHTML = fixedText;\n"
            + "elt.parentElement.parentElement.classList.remove('vulnerabilities');\n"
            + "elt.parentElement.parentElement.classList.add('fixes');}\n"
            + "function removeFixedClass(elt){\n"
            + "var fixedText = 'Fixed'+' '+'&#10003';\n"
            + "var tag = elt.parentElement.nextElementSibling.lastElementChild;\n"
            + "tag.innerHTML = '';\n"
            + "elt.parentElement.parentElement.classList.remove('fixed_text');\n"
            + "elt.parentElement.parentElement.classList.add(\"vulnerabilities\");}\n"
            + "function filter(property){\r\n"
            + "  var filter = document.getElementById(property);\r\n"
            + "  var fixes = document.getElementById(\"filter-fixes\");\r\n"
            + "  var vulnerabilities = document.getElementById(\"filter_vulnerabilities\");\r\n"
            + "  var changes = document.getElementById(\"filter-changes\");\r\n"
            + "\r\n"
            + "  var fixedElts = Array.from(document.getElementsByClassName(\"fixes\"));\r\n"
            + "  var changedElts = Array.from(document.getElementsByClassName(\"changes\"));\r\n"
            + "  var vulnerabilityElts = Array.from(document.getElementsByClassName(\"vulnerabilities\"));\r\n"
            + "  \r\n"
            + "  if(fixes.checked && !vulnerabilities.checked && !changes.checked){ \r\n"
            + "    fixedElts.forEach(showPropertyRows);\r\n"
            + "    changedElts.forEach(hidePropertyRows);\r\n"
            + "    vulnerabilityElts.forEach(hidePropertyRows);\r\n"
            + "}\r\n"
            + "  else if(fixes.checked && vulnerabilities.checked && !changes.checked){\r\n"
            + "    fixedElts.forEach(showPropertyRows);\r\n"
            + "    changedElts.forEach(hidePropertyRows);\r\n"
            + "    vulnerabilityElts.forEach(showPropertyRows);\r\n"
            + "}\r\n"
            + "else if(fixes.checked && !vulnerabilities.checked && changes.checked){\r\n"
            + "    fixedElts.forEach(showPropertyRows);\r\n"
            + "    changedElts.forEach(showPropertyRows);\r\n"
            + "    vulnerabilityElts.forEach(hidePropertyRows);\r\n"
            + "}\r\n"
            + "else if (!fixes.checked && vulnerabilities.checked && changes.checked){\r\n"
            + "  fixedElts.forEach(hidePropertyRows);\r\n"
            + "  changedElts.forEach(showPropertyRows);\r\n"
            + "  vulnerabilityElts.forEach(showPropertyRows);\r\n"
            + "}\r\n"
            + "else if (!fixes.checked && vulnerabilities.checked && !changes.checked){\r\n"
            + "    fixedElts.forEach(hidePropertyRows);\r\n"
            + "    changedElts.forEach(hidePropertyRows);\r\n"
            + "    vulnerabilityElts.forEach(showPropertyRows);\r\n"
            + "}\r\n"
            + "else if (fixes.checked && !vulnerabilities.checked && !changes.checked){\r\n"
            + "  fixedElts.forEach(showPropertyRows);\r\n"
            + "  changedElts.forEach(hidePropertyRows);\r\n"
            + "  vulnerabilityElts.forEach(hidePropertyRows);\r\n"
            + "}\r\n"
            + "else if(!fixes.checked && !vulnerabilities.checked && changes.checked){\r\n"
            + "  fixedElts.forEach(hidePropertyRows);\r\n"
            + "  changedElts.forEach(showPropertyRows);\r\n"
            + "  vulnerabilityElts.forEach(hidePropertyRows);\r\n"
            + "}\r\n"
            + "else {\r\n"
            + "  fixedElts.forEach(showPropertyRows);\r\n"
            + "  changedElts.forEach(showPropertyRows);\r\n"
            + "  vulnerabilityElts.forEach(showPropertyRows);\r\n"
            + "}\r\n"
            + "}\r\n"
            + "function showPropertyRows(item, index){\r\n"
            + "  item.style.display ='';\r\n"
            + "}\r\n"
            + "\r\n"
            + "function hidePropertyRows(item, index){\r\n"
            + "  item.style.display ='none';\r\n"
            + "}\n"
            + "function disableCheckboxForChanges(){\r\n"
            + "  var changeCheckBoxRow = Array.from(document.getElementsByClassName('changes'));\r\n"
            + "  changeCheckBoxRow.forEach(item =>{\r\n"
            + " let changedElt = item.children[3].children[0].children[0];\r\n"
            + "		  if(changedElt&&changedElt.className=='sem-changed'){"
            + "    const elt = item.getElementsByTagName('input'); \r\n"
            + "    elt.checkbox.disabled = true;\r\n"
            + "		}\n"
            + "  })\n"
            + "}";

    return script(rawHtml(scriptCode));
  }
}
