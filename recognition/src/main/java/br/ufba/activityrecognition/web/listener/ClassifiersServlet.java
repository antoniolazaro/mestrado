package br.ufba.activityrecognition.web.listener;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.business.classifier.ClassifierAb;
import br.ufba.activityrecognition.business.classifier.J48Classifier;
import br.ufba.activityrecognition.business.classifier.KNNClassifier;
import br.ufba.activityrecognition.business.classifier.SVMClassifier;


public class ClassifiersServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(ClassifiersServlet.class);

	public static final String CLASSIFIER_J48_ATTRIBUTE_NAME = "classifierJ48";
	public static final String CLASSIFIER_KNN_ATTRIBUTE_NAME = "classifierKNN";
	public static final String CLASSIFIER_SVM_ATTRIBUTE_NAME = "classifierSVM";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR J48."+new Date());
			ClassifierAb classifierJ48 = new J48Classifier();
			classifierJ48.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR J48."+new Date());
			request.getServletContext().setAttribute(CLASSIFIER_J48_ATTRIBUTE_NAME, classifierJ48);
			logger.info("setAttribute do CLASSIFICADOR J48."+new Date());

			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR KNN."+new Date());
			ClassifierAb classifierKNN = new KNNClassifier();
			classifierKNN.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR KNN."+new Date());
			request.getServletContext().setAttribute(CLASSIFIER_KNN_ATTRIBUTE_NAME, classifierKNN);
			logger.info("setAttribute do CLASSIFICADOR KNN."+new Date());

			logger.info("VAI INICIAR CARGA DO CLASSIFICADOR SVM."+new Date());
			ClassifierAb classifierSVM = new SVMClassifier();
			classifierSVM.classifierTrainingInstances();
			logger.info("FINALIZOU CARGA E CLASSIFICACAO DO CLASSIFICADOR SVM."+new Date());
			request.getServletContext().setAttribute(CLASSIFIER_SVM_ATTRIBUTE_NAME, classifierSVM);
			logger.info("setAttribute do CLASSIFICADOR SVM."+new Date());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
