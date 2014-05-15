package br.com.caelum.notasfiscais.util;

import javax.faces.component.UIComponent;

public class ComponentResolver {

	public UIComponent findComponent(UIComponent component, String id) {

		if (component.getId().equals(id)) {
			return component;
		}

		UIComponent bingo = null;

		for (UIComponent filho : component.getChildren()) {
			bingo = this.findComponent(filho, id);
			if (bingo != null)
				return bingo;
		}

		return null;
	}

}
