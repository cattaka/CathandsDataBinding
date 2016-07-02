package net.cattaka.util.cathandsdatabinding.processor;

import net.cattaka.util.cathandsdatabinding.core.ObservableObject;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by cattaka on 16/07/02.
 */
public class CathandsDataBindingProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        ObservableObjectProcessor observableObjectProcessor = new ObservableObjectProcessor();
        for (Element element : roundEnv.getElementsAnnotatedWith(ObservableObject.class)) {
            if (element instanceof TypeElement) {
                observableObjectProcessor.process((TypeElement) element, roundEnv);
            }
        }
        return false;
    }
}
