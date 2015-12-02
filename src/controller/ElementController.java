package controller;

import utils.ArrayList;
import utils.HashMap;
import enums.Element;

public class ElementController {

	private HashMap<ArrayList<Element>, ArrayList<Element>> equations = new HashMap<>();

	public ElementController() {
		createEquations();
	}

	public ArrayList<Element> trimElements(ArrayList<Element> list) {

		ArrayList<Element> listOld = new ArrayList<>(list);

		for (ArrayList<Element> equationElement : this.equations.getKeys()) {

			if (!listContainsEquation(list, equationElement))
				continue;

			list = removeEquationFromList(list, equationElement);
			list = addEquationToList(list,
					this.equations.getValue(equationElement));
			list = sortList(list);

			System.out.println("used");
			equationElement.printList();
			System.out.println("->");
			System.out.println();
			this.equations.getValue(equationElement).printList();
			System.out.println("list old");
			listOld.printList();
			System.out.println("list new");
			list.printList();
			System.out.println();

			list = trimElements(list);

			break;

		}

		return list;

	}

	private ArrayList<Element> addEquationToList(ArrayList<Element> list,
			ArrayList<Element> equationElement) {

		for (Element element : equationElement)
			list.add(element);

		return list;

	}

	private ArrayList<Element> removeEquationFromList(ArrayList<Element> list,
			ArrayList<Element> equationElement) {

		for (Element element : equationElement)
			list.remove(element);

		return list;

	}

	private boolean listContainsEquation(ArrayList<Element> list,
			ArrayList<Element> equationElement) {

		ArrayList<Element> listClone = list.clone();

		for (Element element : equationElement) {

			if (listClone.contains(element))
				listClone.remove(element);
			else
				return false;

		}

		return true;

	}

	private ArrayList<Element> sortList(ArrayList<Element> list) {

		ArrayList<Element> listSorted = new ArrayList<>();
		ArrayList<Element> elements = new ArrayList<>(Element.values());

		for (Element element : elements)
			while (list.contains(element)) {
				list.remove(element);
				listSorted.add(element);
			}

		return listSorted;

	}

	private void createEquations() {

		// a2 = 1

		ArrayList<Element> key = new ArrayList<>();
		ArrayList<Element> value = new ArrayList<>();

		key.add(Element.A);
		key.add(Element.A);

		this.equations.addEntry(key, value);

		// b3 = b

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.B);
		key.add(Element.B);
		key.add(Element.B);
		value.add(Element.B);

		this.equations.addEntry(key, value);

		// b2c = c

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.B);
		key.add(Element.B);
		key.add(Element.C);
		value.add(Element.C);

		this.equations.addEntry(key, value);

		// c3 = ac2

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.C);
		key.add(Element.C);
		key.add(Element.C);
		value.add(Element.A);
		value.add(Element.C);
		value.add(Element.C);

		this.equations.addEntry(key, value);

		// b2d = d

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.B);
		key.add(Element.B);
		key.add(Element.D);
		value.add(Element.D);

		this.equations.addEntry(key, value);

		// cd = ad

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.C);
		key.add(Element.D);
		value.add(Element.A);
		value.add(Element.D);

		this.equations.addEntry(key, value);

		// d2 = c2

		key = new ArrayList<>();
		value = new ArrayList<>();

		key.add(Element.D);
		key.add(Element.D);
		value.add(Element.C);
		value.add(Element.C);

		this.equations.addEntry(key, value);

	}

}
