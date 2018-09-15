package io.nm.facturaElectronica.configuration;

public class ConfigurationEntry {
	private String parameterConfiguration;
	private String fileConfiguration;

	public String getParameterConfiguration() {
		return parameterConfiguration;
	}

	public void setParameterConfiguration(String parameterConfiguration) {
		this.parameterConfiguration = parameterConfiguration;
	}

	public String getFileConfiguration() {
		return fileConfiguration;
	}

	public void setFileConfiguration(String fileConfiguration) {
		this.fileConfiguration = fileConfiguration;
	}

	public ConfigurationEntry(String parameterConfiguration, String fileConfiguration) {
		super();
		this.parameterConfiguration = parameterConfiguration;
		this.fileConfiguration = fileConfiguration;
	}

}
