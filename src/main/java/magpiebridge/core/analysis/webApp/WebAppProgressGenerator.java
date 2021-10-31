package magpiebridge.core.analysis.webApp;

import static j2html.TagCreator.a;
import static j2html.TagCreator.b;
import static j2html.TagCreator.body;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
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
import static j2html.TagCreator.th;
import static j2html.TagCreator.thead;
import static j2html.TagCreator.title;
import static j2html.TagCreator.tr;

import j2html.tags.ContainerTag;
import j2html.tags.UnescapedText;

/** The class generates HTML page when analysis starts. */
public class WebAppProgressGenerator {

  public static String generateProgressHTML(String serverAddress) {

    return html(generateHeader(), generateBody()).renderFormatted();
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
                    + "#container {\n"
                    + "margin-top: 1rem;\n"
                    + "margin-left: 2.5rem;\n"
                    + "width: 250px;\n"
                    + "height: 250px;\n"
                    + "position: relative;\n"
                    + "  }"
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
                    + "	 .sts{display: block; padding-top: 2rem;}\n"
                    + "  .sts-block{margin-left: 3rem;}\n"
                    + "  .txt-clr{ color:black !important;}\n"
                    + "  #warn, #errs, #changes{font-size:xx-large !important;}\n"
                    + "  body{background-color:lightgray !important;}\n"
                    + "  #change-warnings{ margin-top: 1rem;}\n"
                    + "  .errs, .warns{width: max-content;	}\n"
                    + "   .img-container{\r\n"
                    + "  display:inline;"
                    + "}\r\n"
                    + "\r\n"
                    + ".img-container span {\r\n"
                    + "  padding-left: 20px;\r\n"
                    + "}\r\n"
                    + "\r\n"
                    + ".img-container .color-box{\r\n"
                    + "  width: 10px;\r\n"
                    + "  height: 10px;\r\n"
                    + "  display: inline-block;\r\n"
                    + "  \r\n"
                    + " \r\n"
                    + "}"))
        .with(generateScript());
  }

  private static ContainerTag generateBody() {
    return body(
        div(h3(b("MagpieBridge Dashboard"))),
        div(
                div(div(
                            div(b("Introduction and Progress")).withClass("card-header"),
                            div(div(
                                        div(
                                                div(b("Project: "), span().withId("prj-name")),
                                                div(b("Source Path: "), span().withId("prj-name")),
                                                div(b("Analysis Duration: "), span()),
                                                div(
                                                    b("Analysis Start Time: "),
                                                    span().withId("prj-start")),
                                                div(b("Analysis End Time: "), span()),
                                                div(b("Git Branch: "), span().withId("git-branch")),
                                                div(
                                                    b("Git Commit Hash: "),
                                                    span().withId("git-hash")))
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
                                                                    span()
                                                                        .withId("warn")
                                                                        .withClass(
                                                                            "badge badge-pill badge-light"),
                                                                    b("Low").withClass("txt-clr"))
                                                                .withHref("#change_errors")),
                                                        div(
                                                            a(
                                                                    span()
                                                                        .withId("errs")
                                                                        .withClass(
                                                                            "badge badge-pill badge-danger"),
                                                                    b("High").withClass("txt-clr"))
                                                                .withHref("#change_errors")),
                                                        div(
                                                            a(
                                                                    span()
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
                                                            .withId("filter_vulnerabilities"),
                                                        span("Vulnerabilities")),
                                                    div(
                                                        input()
                                                            .withType("checkbox")
                                                            .withId("filter-fixes"),
                                                        span("Fixed Code")),
                                                    div(
                                                        input()
                                                            .withType("checkbox")
                                                            .withId("filter-changes"),
                                                        span("Changed code")))
                                                .withClass("dropdown-content filter"))
                                        .withClass("dropdown"),
                                    div(
                                        div(
                                                span("Semantic Changes"),
                                                div()
                                                    .withClass("color-box")
                                                    .withStyle("background-color: #EF7738;"))
                                            .withClass("img-container"),
                                        div(
                                                span("Non-semantic Changes"),
                                                div()
                                                    .withClass("color-box")
                                                    .withStyle("background-color: #28a745;"))
                                            .withClass("img-container")))
                                .withClass("card-header"),
                            div(table(
                                        thead(
                                                tr(
                                                    th(span(input().withType("checkbox"))),
                                                    th(i("Filename").withClass("fas fa-sort")),
                                                    th(i("Line Number").withClass("fas fa-sort")),
                                                    th(i("Message").withClass("fas fa-sort")),
                                                    th(i("Severity").withClass("fas fa-sort")),
                                                    th("Repair")))
                                            .withClass("tab-head"),
                                        tbody())
                                    .withClass("table table-striped table-bordered ")
                                    .withId("analysis_table"))
                                .withClass("card-body"))
                        .withClass("col card"))
                    .withClass("row"))
            .withClass("container-fluid"));
  }

  private static ContainerTag generateScript() {
    String scriptCode =
        "window.onload = function onLoad() {\n"
            + "	var bar = new ProgressBar.Circle(container, {\n"
            + "	    color: '#6590FF',\n"
            + "	    strokeWidth: 4,\n"
            + "	    trailWidth: 1,\n"
            + "	    easing: 'easeInOut',\n"
            + "	    duration: 60000,\n"
            + "	    text: {\n"
            + "	      autoStyleContainer: false\n"
            + "	    },\n"
            + "	    from: { color: '#aaa', width: 3 }, \n"
            + "	    to: { color: '#6590FF', width: 5 }, \n"
            + "	    step: function(state, circle) { \n"
            + "	      circle.path.setAttribute('stroke', state.color); \n"
            + "	      circle.path.setAttribute('stroke-width', state.width); \n"
            + "	      var value = Math.round(circle.value() * 100); \n"
            + "	      if (value === 0) { \n"
            + "	        circle.setText(''); \n"
            + "	      } else { \n"
            + "	        circle.setText(value+'%'); \n"
            + "	      } } \n"
            + "	  }); \n"
            + "	  bar.text.style.fontFamily = 'Raleway, Helvetica, sans-serif';\n"
            + "	  bar.text.style.fontSize = '2rem';\n"
            + "	  bar.animate(1.0);  // Number from 0.0 to 1.0\n"
            + "	}";

    return script(rawHtml(scriptCode));
  }
}
