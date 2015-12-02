package controller;

import utils.ArrayList;
import utils.HashMap;
import enums.Element;

public class ElementController {

	private HashMap<ArrayList<Element>, ArrayList<Element>> equations = new HashMap<>();
	private ArrayList<ArrayList<Element>> perfectPositions = new ArrayList<>();

	public ElementController() {
		createEquations();
		createPerfectPositions();
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

		this.equations.addEntry(getElementList(Element.A, Element.A),
				new ArrayList<Element>());

		// b3 = b

		this.equations.addEntry(
				getElementList(Element.B, Element.B, Element.B),
				getElementList(Element.B));

		// b2c = c

		this.equations.addEntry(
				getElementList(Element.B, Element.B, Element.C),
				getElementList(Element.C));

		// c3 = ac2

		this.equations.addEntry(
				getElementList(Element.C, Element.C, Element.C),
				getElementList(Element.A, Element.C, Element.C));

		// b2d = d

		this.equations.addEntry(
				getElementList(Element.B, Element.B, Element.D),
				getElementList(Element.D));

		// cd = ad

		this.equations.addEntry(getElementList(Element.C, Element.D),
				getElementList(Element.A, Element.D));

		// d2 = c2

		this.equations.addEntry(getElementList(Element.D, Element.D),
				getElementList(Element.C, Element.C));

	}

	private void createPerfectPositions() {

		this.perfectPositions.add(getElementList(Element.A));
		this.perfectPositions.add(getElementList(Element.B, Element.B));
		this.perfectPositions.add(getElementList(Element.B, Element.C));
		this.perfectPositions.add(getElementList(Element.C, Element.C));

	}

	private ArrayList<Element> getElementList(Element... element) {
		return new ArrayList<>(element);
	}

	public boolean isPerfectPosition(ArrayList<Element> list) {

		for (ArrayList<Element> pPosition : this.perfectPositions) {

			if (pPosition.size() != list.size())
				continue;

			ArrayList<Element> listTemp = list.clone();

			boolean notFound = false;

			for (Element element : pPosition)
				if (listTemp.contains(element))
					listTemp.remove(element);
				else
					notFound = true;

			if (notFound)
				continue;

			if (!listTemp.isEmpty())
				continue;

			return true;

		}

		return false;

	}
}
