package com.presto.banking.common;

interface PrestoConfigMBean {

	public void setThreadCount(int noOfThreads);

	public int getThreadCount();

	public void setSchemaName(String schemaName);

	public String getSchemaName();

	// any method starting with get and set are considered
	// as attributes getter and setter methods, so I am
	// using do* for operation.
	public String doConfig();
}

class SystemConfig implements PrestoConfigMBean {

	private int threadCount;
	private String schemaName;

	public SystemConfig(int numThreads, String schema) {
		this.threadCount = numThreads;
		this.schemaName = schema;
	}

	public void setThreadCount(int noOfThreads) {
		this.threadCount = noOfThreads;
	}

	public int getThreadCount() {
		return this.threadCount;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public String doConfig() {
		return "No of Threads=" + this.threadCount + " and DB Schema Name=" + this.schemaName;
	}

}
