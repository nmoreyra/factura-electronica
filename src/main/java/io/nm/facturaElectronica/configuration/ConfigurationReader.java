package io.nm.facturaElectronica.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigurationReader {

	private final String propFileName = "facturaElectronica.properties";

	private static final Logger LOGGER = Logger.getLogger("io.nm.facturaElectronica.configuration.ConfigurationReader");

	public boolean loadConfiguration() {
		String error = "Failed while reading parameter, using facturaElectronica.properties -> ";
		boolean result = true;
		try {
			LOGGER.log(Level.INFO, "Start reading configuration for facturaElectronica");
			Configuration conf = Configuration.getInstance();
			ConfigurationEntry configPrueba = getConfigurationEntry("facturaElectronica.configPrueba");
					
			if (configPrueba.getParameterConfiguration() != null)
				conf.setConfigPrueba(configPrueba.getParameterConfiguration());
			else {
				conf.setConfigPrueba(configPrueba.getFileConfiguration());
				LOGGER.log(Level.WARNING, error + "facturaElectronica.ConfigPrueba");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Failed reading configuration");
			result = false;
		}
		return result;
	}

	private ConfigurationEntry getConfigurationEntry(String propertyName) {
		ConfigurationEntry result = null;
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			}
			String parameterConfiguration = System.getProperty(propertyName);
			String fileConfiguration = prop.getProperty(propertyName);
			result = new ConfigurationEntry(parameterConfiguration, fileConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
