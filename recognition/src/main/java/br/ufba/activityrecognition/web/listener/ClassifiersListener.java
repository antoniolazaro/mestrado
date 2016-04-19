package br.ufba.activityrecognition.web.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.classifier.ClassifierAb;
import br.ufba.activityrecognition.business.classifier.J48Classifier;
import br.ufba.activityrecognition.business.classifier.KNNClassifier;
import br.ufba.activityrecognition.business.classifier.SVMClassifier;


public class ClassifiersListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ClassifiersListener.class);

	public static final String CLASSIFIER_J48_ATTRIBUTE_NAME = "classifierJ48";
	public static final String CLASSIFIER_KNN_ATTRIBUTE_NAME = "classifierKNN";
	public static final String CLASSIFIER_SVM_ATTRIBUTE_NAME = "classifierSVM";

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try{
			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR J48."+new Date());
			ClassifierAb classifierJ48 = new J48Classifier();
			classifierJ48.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR J48."+new Date());
			servletContextEvent.getServletContext().setAttribute(CLASSIFIER_J48_ATTRIBUTE_NAME, classifierJ48);
			logger.info("setAttribute do CLASSIFICADOR J48."+new Date());

			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR KNN."+new Date());
			ClassifierAb classifierKNN = new KNNClassifier();
			classifierKNN.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR KNN."+new Date());
			servletContextEvent.getServletContext().setAttribute(CLASSIFIER_KNN_ATTRIBUTE_NAME, classifierKNN);
			logger.info("setAttribute do CLASSIFICADOR KNN."+new Date());

			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR SVM."+new Date());
			ClassifierAb classifierSVM = new SVMClassifier();
			classifierSVM.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR SVM."+new Date());
			servletContextEvent.getServletContext().setAttribute(CLASSIFIER_SVM_ATTRIBUTE_NAME, classifierSVM);
			logger.info("setAttribute do CLASSIFICADOR SVM."+new Date());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
