package exam.test16;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	CustomDateEditor customDateEditor;
	
	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(java.util.Date.class, customDateEditor);
	}
}
