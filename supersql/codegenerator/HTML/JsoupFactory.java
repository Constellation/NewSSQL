package supersql.codegenerator.HTML;

import java.util.ArrayList;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.TFE;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;
import supersql.parser.SSQLparser;

public class JsoupFactory {

	public static Element createJsElement(String src) {
		Attributes attributes = new Attributes();
		attributes.put("type", "text/javascript");
		attributes.put("src", src);
		return new Element(Tag.valueOf("script"), "", attributes);
	}

	public static ArrayList<Element> createJsElements(String... srcs) {
		ArrayList<Element> elements = new ArrayList<Element>();
		for (String string : srcs) {
			elements.add(createJsElement(string));
		}
		return elements;
	}

	public static Element createStylesheetElement(String src) {
		return createStylesheetElement(src, null);
	}

	public static Element createStylesheetElement(String src, String media) {
		Attributes attributes = new Attributes();
		attributes.put("rel", "stylesheet");
		attributes.put("type", "text/css");
		attributes.put("href", src);
		if (media != null) {
			attributes.put("media", media);
		}
		return new Element(Tag.valueOf("link"), "", attributes);
	}

	public static ArrayList<Element> createStylesheetElements(String... srcs) {
		ArrayList<Element> elements = new ArrayList<Element>();
		for (String string : srcs) {
			elements.add(createStylesheetElement(string));
		}
		return elements;
	}

	public static ArrayList<Element> createStylesheetElements(String[]... srcs) {
		ArrayList<Element> elements = new ArrayList<Element>();
		for (String[] strings : srcs) {
			if (strings.length != 2)
				continue;
			elements.add(createStylesheetElement(strings[0], strings[1]));
		}
		return elements;
	}

	public static Element createInput(String type, String name, String value) {
		Attributes attributes = new Attributes();
		attributes.put("type", type);
		if(!name.isEmpty())
			attributes.put("name", name);
		attributes.put("value", value);
		return new Element(Tag.valueOf("input"), "", attributes);
	}

	public static Element createLink(String href, String id, String content,
			String... classes) {
		Element element = new Element(Tag.valueOf("a"), "").attr("href", href);
		for (String cls : classes) {
			element.addClass(cls);
		}
		if (!id.isEmpty()) {
			element.attr("id", id);
		}
		element.html(content);
		return element;
	}

	public static Element createForm(Connector connector, String inputType,
			String submitText, String inputValue, String formContentClass,
			String formContentElementsClass, Element result) {
		ExtList<TFE> tfes = connector.tfes;
		ExtList<ExtList<String>> dataInfo = connector.getData();

		Element form = result.tagName("form");
		form.attr("class", "form vertical box nest")
				.attr("action", "/servlet/supersql.form.Update")
				.attr("method", "post").attr("name", "theForm");
		form.appendChild(JsoupFactory.createInput("hidden", "tableinfo",
				SSQLparser.get_from_info_st()));
		form.appendChild(JsoupFactory.createInput("hidden", "configfile",
				GlobalEnv.getconfigfile()));
		form.appendChild(JsoupFactory.createInput("hidden", "sql_param",
				inputType));
		Element formContent = new Element(Tag.valueOf("div"), "");
		formContent.attr("class", "box").addClass(formContentClass);

		int i = 0;
		boolean noInputValue = false;

		if (inputValue == null)
			noInputValue = true;

		while (i < tfes.size()) {
			ITFE tfe = (ITFE) tfes.get(i);
			tfe.addDeco(submitText, true);
			Element nextItem = ((Element) connector
					.createNextItemNode(dataInfo));

			if (tfe.getClass() == HTMLAttribute.class) {
				if (noInputValue)
					inputValue = nextItem.text();
				String name = tfe.toString().split("\\.")[tfe.toString().split(
						"\\.").length - 1];

				formContent
						.appendElement("div")
						.attr("class", "box " + HTMLEnv.getClassID(tfe))
						.addClass(formContentElementsClass)
						.appendChild(
								JsoupFactory.createInput(inputType, name,
										inputValue));

			} else {
				formContent.appendChild(nextItem);
			}
			i++;
		}

		form.appendChild(formContent).appendChild(
				JsoupFactory.createInput("submit", "", submitText));
		return form;
	}

	public static Element createLoginForm(Connector connector, Element result) {
		int tfes_size = connector.tfes.size();
		ExtList<ExtList<String>> dataInfo = connector.getData();
		Element form = createSessionForm(result, "login");
		int i = 0;
		while (i < tfes_size) {
			Element nextItem = ((Element) connector
					.createNextItemNode(dataInfo));
			form.appendChild(nextItem);
			i++;
		}
		return form;
	}

	public static Element createSessionForm(Element result, String name) {
		Element form = result
				.tagName("form")
				.attr("action",
						GlobalEnv.getFileDirectory()
								+ "/servlet/supersql.form.Session")
				.attr("method", "post")
				.attr("name", name)
				.appendChild(
						JsoupFactory.createInput("hidden", "configfile",
								GlobalEnv.getconfigfile()));
		if (name.contains("login"))
			form.appendChild(JsoupFactory.createInput("hidden", "tableinfo",
					SSQLparser.get_from_info_st()));
		return form;
	}
}
