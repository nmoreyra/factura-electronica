package io.nm.facturaElectronica.configuration;

public class Configuration {
	private static Configuration instance = null;

	private Configuration() {
	}

	public static Configuration getInstance() {
		if (instance == null) {
			synchronized (Configuration.class) {
				if (instance == null) {
					instance = new Configuration();
				}
			}
		}
		return instance;
	}
	
	private String configPrueba;

	public String getConfigPrueba() {
		return configPrueba;
	}

	public void setConfigPrueba(String configPrueba) {
		this.configPrueba = configPrueba;
	}

	
	
}
