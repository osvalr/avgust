package com.sakerk.generador.generate;

import javax.xml.bind.JAXBException;

import com.sakerk.generador.definition.GeneradorUtil;

public class MainGenerate {

	public static void main(String[] args) throws JAXBException {

		GeneradorUtil util = new GeneradorUtil();
		util.loadXml("Query.xml");
	}

}
